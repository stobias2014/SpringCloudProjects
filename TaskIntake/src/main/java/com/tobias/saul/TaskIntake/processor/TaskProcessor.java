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
		
		List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
		
		TaskLaunchRequest request =  new TaskLaunchRequest(url, input, null, null, null);
		
		System.out.println("created task request");
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		
		this.source.output().send(message);
	}

}
