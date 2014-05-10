package com.demo.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;

public class Job1CustomStepListener implements StepExecutionListener {

	@Autowired
	MessageChannel inputChannel;
	
	public void beforeStep(StepExecution stepExecution) {
		// Nothing to do here ... go on	with rpocessing	
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("StepExecutionListener - afterStep : Job1 :");
		
		if(stepExecution.getStatus().equals(BatchStatus.COMPLETED)){
			System.out.println("Sending Message to Job2...");
			
			//Sending SUCCESS Message	
			inputChannel.send(new GenericMessage<BatchStatus>(BatchStatus.COMPLETED));
		}
		
		return null;
	}

	

}
