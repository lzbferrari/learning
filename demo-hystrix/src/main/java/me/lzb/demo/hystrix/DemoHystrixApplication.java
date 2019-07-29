package me.lzb.demo.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class DemoHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHystrixApplication.class, args);
	}

}
