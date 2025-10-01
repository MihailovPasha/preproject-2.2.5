package com.example.myspringbootstarter.config;

import com.example.myspringbootstarter.IncomeClient;
import com.example.myspringbootstarter.properties.IncomeClientProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@AutoConfiguration
@ConditionalOnClass(IncomeClient.class)
@EnableConfigurationProperties(IncomeClientProperties.class)
public class IncomeClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean
    public IncomeClient incomeClient(RestTemplate restTemplate, IncomeClientProperties properties) {
        return new IncomeClient(restTemplate, properties.getApiUrl());
    }
}
