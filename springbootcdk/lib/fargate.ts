import * as cdk from '@aws-cdk/core';
import * as ec2 from '@aws-cdk/aws-ec2';
import * as ecs from '@aws-cdk/aws-ecs';
import * as ecs_patterns from '@aws-cdk/aws-ecs-patterns';
import { CdkPipeline, SimpleSynthAction } from '@aws-cdk/pipelines';
import * as codepipeline from '@aws-cdk/aws-codepipeline';
import * as codepipeline_actions from '@aws-cdk/aws-codepipeline-actions';
import { WorkshopPipelineStage } from './pipeline-stage';
import { ManagedPolicy, Role, ServicePrincipal, PolicyStatement, Effect } from '@aws-cdk/aws-iam';

export class SpringbootfagateStack extends cdk.Stack {
  constructor(scope: cdk.Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    
    // The code that defines your stack goes here
    const vpc = new ec2.Vpc(this,"MyVpc",{
      maxAzs:2
    });
    
    const cluster = new ecs.Cluster(this,"MyCluster",{
      vpc: vpc
    });

    const ecsFargateServiceRole = new Role(this, 'FargateTaskExecutionServiceRole', {
      assumedBy: new ServicePrincipal('ecs-tasks.amazonaws.com')
    });

    ecsFargateServiceRole.addToPolicy(
      new PolicyStatement({
        effect: Effect.ALLOW,
        resources: ['*'],
        actions: [            
          'ecr:GetAuthorizationToken',
          'ecr:BatchCheckLayerAvailability',
          'ecr:GetDownloadUrlForLayer',
          'ecr:BatchGetImage',
          'logs:CreateLogStream',
          'logs:PutLogEvents'
        ]
      })
    );

    const Service = new ecs_patterns.ApplicationLoadBalancedFargateService(this, "Service", {
        cluster: cluster,
        memoryLimitMiB: 1024,
        cpu: 512,
        desiredCount: 2,
        taskImageOptions: {
          image: ecs.ContainerImage.fromAsset("../springbooteclipse/"),
          containerPort: 8080
        },
        
      });
      
      Service.targetGroup.configureHealthCheck({ path: "/actuator/health"});


      const sourceArtifact = new codepipeline.Artifact();
      const cloudAssemblyArtifact = new codepipeline.Artifact();
      
      const pipeline = new CdkPipeline(this, 'SeisPipeline', {
        pipelineName: 'SeisPipeline',
        cloudAssemblyArtifact,
        selfMutating:true,        
        sourceAction: new codepipeline_actions.GitHubSourceAction({
          actionName: 'GitHub',
          output: sourceArtifact,
          oauthToken: cdk.SecretValue.secretsManager('github-oauth'),
          // Replace these with your actual GitHub project info
          owner: 'cgxinyi',
          repo: 'CodeTest-Seis',
          branch: 'main',
          
        }), synthAction: SimpleSynthAction.standardNpmSynth({
          sourceArtifact,
          cloudAssemblyArtifact,
          subdirectory: 'springbootcdk',
          installCommand:'cd ../springbooteclipse && npm install -g aws-cdk typescript',
          
          buildCommand: 'mvn install && npm install',
          synthCommand:'npx run cdk synth',
         
          environment: {
            
            privileged: true,
            
          }
        }),
      });
    
    //change check
      const deploy = new WorkshopPipelineStage(this, 'Deploy');
      pipeline.addApplicationStage(deploy);
      
      new cdk.CfnOutput(this, "loadBalancerUrl", {
        value: Service.loadBalancer.loadBalancerDnsName,
        exportName: "loadBalancerUrl",
      });

      ecsFargateServiceRole.addManagedPolicy(
        ManagedPolicy.fromAwsManagedPolicyName('AmazonECSTaskExecutionRolePolicy')
    );
  }


  
  
}


