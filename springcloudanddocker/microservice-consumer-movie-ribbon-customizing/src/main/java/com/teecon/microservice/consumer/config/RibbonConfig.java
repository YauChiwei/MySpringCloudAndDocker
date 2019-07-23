package com.teecon.microservice.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
该类不能放在主应用程序上下文@ComponentScan所扫描的包中
否则该类中的配置信息将被所有@RibbonClient共享
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
