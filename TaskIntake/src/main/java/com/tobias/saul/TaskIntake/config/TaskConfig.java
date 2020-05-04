package com.tobias.saul.TaskIntake.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tobias.saul.TaskIntake.processor.TaskProcessor;

@Configuration
public class TaskConfig {
	
	@Bean
	public TaskProcessor taskProcessor(){
		return new TaskProcessor();
	}

}
