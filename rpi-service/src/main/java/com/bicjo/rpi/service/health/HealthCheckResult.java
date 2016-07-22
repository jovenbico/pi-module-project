package com.bicjo.rpi.service.health;

import java.util.ArrayList;
import java.util.List;

public class HealthCheckResult {

	private boolean ok = true;
	private List<String> messages = new ArrayList<>();

	public void notOk() {
		this.ok = false;
	}

	public boolean isOk() {
		return ok;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void addResult(String message) {
		messages.add(message);
	}

}
