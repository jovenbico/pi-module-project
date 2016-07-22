package com.bicjo.rpi.service.slack;

import java.util.List;

public interface SlackNotification {

	public void send(String message);

	public void send(List<String> messages);

}
