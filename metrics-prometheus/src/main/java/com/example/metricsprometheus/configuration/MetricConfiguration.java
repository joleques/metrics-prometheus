package com.example.metricsprometheus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MetricConfiguration {
	
	
	@Bean(name = "counterOne")
	public Counter createCounterOne(MeterRegistry meterRegistry) {
		return Counter.builder("teste.get_1")
				.tag("tipo", "sms")
				.tag("tipo", "email")
				.tag("tipo", "callback")
				.description("teste do primeiro get")
				.register(meterRegistry);
	}
	

	@Bean(name = "counterTwo")
	public Counter createCounterTwo(MeterRegistry meterRegistry) {
		return Counter.builder("teste.get_2").tag("tipo", "get_2").description("teste do segundo get").register(meterRegistry);
	}
	
	/*
	 * @Bean public TimedAspect timedAspect(MeterRegistry registry) { return new
	 * TimedAspect(registry); }
	 */
	
}
