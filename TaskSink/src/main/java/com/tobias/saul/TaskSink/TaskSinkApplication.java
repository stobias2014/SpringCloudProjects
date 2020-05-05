package com.tobias.saul.TaskSink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
//@EnableBinding(Sink.class)
public class TaskSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSinkApplication.class, args);
	}

}
