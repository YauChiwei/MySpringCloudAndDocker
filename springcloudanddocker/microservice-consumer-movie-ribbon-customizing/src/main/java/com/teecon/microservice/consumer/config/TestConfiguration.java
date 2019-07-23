package com.teecon.microservice.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="microservice-provider-user-instance", configuration = RibbonConfig.class)
public class TestConfiguration {
}
