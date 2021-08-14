import { Construct, Stack, StackProps, Stage, StageProps } from '@aws-cdk/core';
import * as codepipeline from '@aws-cdk/aws-codepipeline';
import { CdkPipeline } from '@aws-cdk/pipelines';

export class CodeSeisApp extends Stage{
    constructor(scope: Construct, id: string, props?: StackProps) {
      super(scope, id, props);

    }
}