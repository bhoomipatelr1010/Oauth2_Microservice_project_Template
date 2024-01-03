package com.microservice2.microservice2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "m2")
@Component
@Data
public class M2Configuration {

	private String data;
	private int limit;
}
