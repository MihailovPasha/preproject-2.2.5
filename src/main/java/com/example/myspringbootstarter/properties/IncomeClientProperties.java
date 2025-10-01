package com.example.myspringbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "income.client")
public class IncomeClientProperties {
    private String apiUrl = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}
