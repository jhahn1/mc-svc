package com.mc.mcsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = "com.mc.mcsvc")
@EnableAutoConfiguration
@PropertySources({@PropertySource("classpath:application.properties")})
public class McSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(McSvcApplication.class, args);
	}
}
