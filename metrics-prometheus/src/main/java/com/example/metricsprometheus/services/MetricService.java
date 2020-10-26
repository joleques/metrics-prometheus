package com.example.metricsprometheus.services;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Component
public class MetricService {

	Logger LOGGER = getLogger(MetricService.class);
	
	@Autowired
	private MeterRegistry registry;

	@Async
	public void incrementStatus(String status, int delay) {

		increment("status.service", "status", status, 0, delay * 1000);

	}

	private void increment(String name, String key, String value, int counter, int delay) {
		while (counter < 100) {
			try {
				for (int i = 0; i < 5; i++) {
					Tags tags = Tags.of(key, value);
					registry.counter(name, tags).increment();
				}
				Thread.sleep(delay);
				LOGGER.info(String.format("Incrementando %s - Total: %d", value, counter));
				counter++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
