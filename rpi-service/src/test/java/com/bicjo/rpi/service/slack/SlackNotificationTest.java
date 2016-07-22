package com.bicjo.rpi.service.slack;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SlackNotificationTest extends Assert {

	private SlackNotification slack = new SimpleSlackNotification();

	// learning test
	@Test
	public void send_ok() {

		String message = "hello world";
		slack.send(message);

		List<String> messages = new ArrayList<>();
		messages.add("abcd");
		messages.add("xyz");
		slack.send(messages);
	}

}
