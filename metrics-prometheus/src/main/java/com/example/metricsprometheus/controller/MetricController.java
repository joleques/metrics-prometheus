package com.example.metricsprometheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.metricsprometheus.services.MetricService;


@RestController
@RequestMapping("/teste-metric")
public class MetricController {

	@Autowired
	private MetricService service;
	
	@PostMapping("/error")
	public String counterError() {
		String status = "ERROR";
		int delay = 1;
		service.incrementStatus(status, delay);
		return String.format("Teste do contador de erros iniciado com delay de %ds a cada 5 incrementos, durando %d segundos", delay, delay * 100);
	}
	
	@PostMapping("/success")
	public String counterSuccess() {
		String status = "SUCCESS";
		int delay = 2;
		service.incrementStatus(status, delay);
		return String.format("Teste do contador de erros iniciado com delay de %ds a cada 5 incrementos, durando %d segundos", delay, delay * 100);
	}
	
	@PostMapping("/pending")
	public String counterPending() {
		String status = "PENDING";
		int delay = 3;
		service.incrementStatus(status, delay);
		return String.format("Teste do contador de erros iniciado com delay de %ds a cada 5 incrementos, durando %d segundos", delay, delay * 100);
	}
	
}
