/**
 * 
 */
package com.demo.batch.launcher;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ashish
 *
 */
public class Job1Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] springConfig  = 
			{	
				"classpath:spring-batch-job1.xml",
				"classpath:printHelloJob.xml",
				"classpath:inte-demo.xml"
			};
	 
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	 
		//Create Launcher and launch the Job
		JobLauncher job1Launcher = (JobLauncher) context.getBean("job1Launcher");
		
		//Create a Job
		Job job = (Job) context.getBean("printHelloJob");
		
		try {
			 
			JobExecution execution = job1Launcher.run(job, new JobParameters());
			System.out.println("Exit Status from Job1: " + execution.getStatus());
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
