package com.bicjo.rpi.service.health;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bicjo.rpi.service.slack.SimpleSlackNotification;
import com.bicjo.rpi.service.slack.SlackNotification;
import com.pi4j.system.SystemInfo;

public class SimpleHealthChecker implements HealthChecker {

	private final Logger LOG = LogManager.getLogger(getClass());

	private final static float CPU_TEMP_NOT_OK = 60;
	private final static String CPU_TEMP_NOT_OK_MESSAGE = "CPU temp not OK";

	private float currentCPUTemp;

	@Override
	public void check() {
		HealthCheckResult healthCheckResult = new HealthCheckResult();

		if (cpuTemperature()) {
			healthCheckResult.notOk();
			healthCheckResult.addResult(CPU_TEMP_NOT_OK_MESSAGE + " " + currentCPUTemp);
		}

		if (!healthCheckResult.isOk()) {
			SlackNotification notification = new SimpleSlackNotification();
			notification.send(healthCheckResult.getMessages());
		}

	}

	private boolean cpuTemperature() {
		boolean result = true;

		try {

			currentCPUTemp = SystemInfo.getCpuTemperature();
			if (currentCPUTemp >= CPU_TEMP_NOT_OK) {
				result = false;
			}

		} catch (NumberFormatException | IOException | InterruptedException e) {
			LOG.error(e.getMessage(), e);
		}

		return result;
	}

}
