package com.microservice1.microservice1.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@ConfigurationProperties(prefix = "m1")
@Data
public class M1Configuration {

	private String data;
	private int limit;
}
