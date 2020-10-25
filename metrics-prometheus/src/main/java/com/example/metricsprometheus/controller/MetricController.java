package com.example.metricsprometheus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.metricsprometheus.services.MetricService;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;


@RestController
@RequestMapping("/teste-metric")
public class MetricController {

	@Autowired
	private Counter counterOne;
	
	@Autowired
	private Counter counterTwo;
	
	@Autowired
	private MetricService service;
	
	@Autowired
	private MeterRegistry registry;
	
	@GetMapping("/")
	public String getTest() {
		counterOne.increment();
		return "Teste de um get incrementando no primeiro contador";
	}	

	@GetMapping("/teste_2")
	public String getTest2() {
		counterTwo.increment();
		return "Teste de um get incrementando no segundo contador";
	}

	@GetMapping("/teste_2/{tipo}")
	public String getTest3(@PathVariable String tipo) {
		Tags tags = Tags.of("tipo",tipo);
		registry.counter("teste_get_1", tags).increment();
		return "Teste de um get incrementando no primeiro contador";
	}	
	
	@PostMapping("/save")
	public String save() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return service.save("tempo para salvar.....");
	}
}
