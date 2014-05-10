/**
 * 
 */
package com.demo.batch.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author ashish
 *
 */
public class PrintHelloTasklet implements Tasklet {

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		
		System.out.println("printing Hello...");
		
		return RepeatStatus.FINISHED;
	}

}
