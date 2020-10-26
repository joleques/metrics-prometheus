package com.example.metricsprometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MetricsPrometheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsPrometheusApplication.class, args);
	}

}
