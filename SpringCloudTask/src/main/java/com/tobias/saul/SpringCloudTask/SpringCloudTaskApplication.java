package com.tobias.saul.SpringCloudTask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			// //parameters : stationid, licence plate, timestamp
			
			if(null != args) {
				System.out.println("parameter length is: " + args.length);
				
				String stationId = args[0];
				String licencePlate = args[1];
				String timeStamp = args[2];
				
				System.out.println("Station Id: " + stationId);
				System.out.println("Licence Plate: " + licencePlate);
				System.out.println("Time Stamp: " + timeStamp);
			}
			
		}
		
	}

}
