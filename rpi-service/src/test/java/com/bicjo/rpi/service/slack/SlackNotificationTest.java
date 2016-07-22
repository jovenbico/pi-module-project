package com.bicjo.rpi.service.slack;

import org.junit.Assert;
import org.junit.Test;

import com.bicjo.rpi.service.slack.SimpleSlackNotification;
import com.bicjo.rpi.service.slack.SlackNotification;

public class SlackNotificationTest extends Assert {

	private SlackNotification slack = new SimpleSlackNotification();

	// learning test
	@Test
	public void send_ok() {

		String message = "hello world";
		slack.send(message);

	}

}
