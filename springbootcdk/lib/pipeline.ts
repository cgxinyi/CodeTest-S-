import { SpringbootfagateStack } from './fargate';
import { Stage, Construct, StageProps } from '@aws-cdk/core';

export class WorkshopPipelineStage extends Stage {
    constructor(scope: Construct, id: string, props?: StageProps) {
        super(scope, id, props);

        new SpringbootfagateStack(this, 'Service');
    }
}