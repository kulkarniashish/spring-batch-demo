/**
 * 
 */
package com.demo.batch.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ashish
 *
 */
public class JobScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] springConfig = 
			{
				"classpath:job-quartz.xml",
				"classpath:spring-batch-job1.xml",
				"classpath:printHelloJob.xml"
//				"classpath:spring-batch-job2.xml",
//				"classpath:printWorldJob.xml"
			};
		
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

	}

}
