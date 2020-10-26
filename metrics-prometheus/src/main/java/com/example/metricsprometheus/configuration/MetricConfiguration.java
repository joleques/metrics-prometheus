package com.example.metricsprometheus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MetricConfiguration {
	
	
	@Bean(name = "typeMensage")
	public Counter createCounterOne(MeterRegistry meterRegistry) {
		return Counter.builder("tipo.mensagem")
				.tag("tipo", "sms")
				.tag("tipo", "email")
				.tag("tipo", "push")
				.description("Tipo de envio de mensagem")
				.register(meterRegistry);
	}
	

	@Bean(name = "statusService")
	public Counter createCounterTwo(MeterRegistry meterRegistry) {
		return Counter.builder("status.service")
				.tag("status", "ERROR")
				.tag("status", "SUCCESS")
				.tag("status", "PENDING")
				.description("Status do Serviço")
				.register(meterRegistry);
	}
	
	
}
