package com.example.myspringbootstarter;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


public class IncomeClient {
    private final RestTemplate restTemplate;
    private final String incomeApiUrl;

    public IncomeClient(RestTemplate restTemplate, String incomeApiUrl) {
        this.restTemplate = restTemplate;
        this.incomeApiUrl = incomeApiUrl;
    }

    public Double getMonthlyIncome(Long userId) {
        try {
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    incomeApiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );

            if (response.getBody() != null) {
                for (Map<String, Object> incomeData : response.getBody()) {
                    Object incomeUserId = incomeData.get("userId");
                    Object monthlyIncome = incomeData.get("monthlyIncome");

                    if (incomeUserId != null && incomeUserId.toString().equals(userId.toString())) {
                        if (monthlyIncome != null) {
                            return Double.parseDouble(monthlyIncome.toString());
                        }
                    }
                }
            }
            return 0.0;
        } catch (Exception e) {
            return 0.0;
        }
    }
}
