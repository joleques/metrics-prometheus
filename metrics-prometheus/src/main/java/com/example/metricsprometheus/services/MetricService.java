package com.example.metricsprometheus.services;

import org.springframework.stereotype.Component;

import io.micrometer.core.annotation.Timed;

@Component
public class MetricService {


	@Timed(description = "Tempo de um salvamento")
	public String save(String texto) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return texto;
	}
}
