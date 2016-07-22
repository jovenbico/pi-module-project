package com.bicjo.rpi.service.health;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class HealthCheckerTest {

	private final Logger LOG = LogManager.getLogger(getClass());

	@Test
	public void temperature_convert() {
		String line = "temp=42.8'C";
		String parts[] = line.split("[=']", 3);
		float cpuTemp = Float.parseFloat(parts[1]);

		LOG.debug(cpuTemp);
	}

}
