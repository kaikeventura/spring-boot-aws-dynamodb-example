package com.kaikeventura.dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamodbApplication.class, args);
	}

}
