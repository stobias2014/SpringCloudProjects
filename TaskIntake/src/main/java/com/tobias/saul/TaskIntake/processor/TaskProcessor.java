package com.tobias.saul.TaskIntake.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {
	
	@Autowired
	private Source source;
	
	public void publishRequestA(String payload) {
		String url = "maven://com.tobias.saul:SpringCloudTask:jar:0.0.1-SNAPSHOT";
		// maven://org.springframework.cloud.task.app:timestamp-task:jar:1.0.0.BUILD-SNAPSHOT
		//String jarUrl = "/Users/saultobias/.m2/repository/com/tobias/saul/SpringCloudTask/0.0.1-SNAPSHOT/SpringCloudTask-0.0.1-SNAPSHOT.jar";
		
		
		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
		
		TaskLaunchRequest request =  new TaskLaunchRequest(url, input, null, null, "Toll Processor");
		System.out.println("\nURI: " + request.getUri());
		System.out.println("Command Line Arguments: " + request.getCommandlineArguments());
		System.out.println();
		
		System.out.println("\nInside Task processor ------> Created task request");
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		
		this.source.output().send(message);
	}

}
