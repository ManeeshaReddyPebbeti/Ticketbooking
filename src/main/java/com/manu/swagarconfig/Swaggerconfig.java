package com.manu.swagarconfig;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Swaggerconfig {
	@Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder()
                .group("ticketbooking-api")
                .packagesToScan("com.manu.conroller") 
                .build();
	}
}
