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
public class Job2Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] springConfig  = 
			{	
				"classpath:spring-batch-job2.xml",
				"classpath:printWorldJob.xml"
			};
	 
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		
		//Create Launcher and launch the Job
		JobLauncher job2Launcher = (JobLauncher) context.getBean("job2Launcher");
		
		//Create a Job
		Job job = (Job) context.getBean("printWorldJob");
		
		try {
			
			JobExecution execution = job2Launcher.run(job, new JobParameters());
			System.out.println("Exit Status from Job2: " + execution.getStatus());
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
