package com.example.basiceProjectForConversionCurrency.conversionCurrency.RestClient.model;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseCurrencyDto {
    private Map<String, Double> data;

    // Getters and Setters
    public Map<String, Double> getData() {
        return data;
    }

    public void setData(Map<String, Double> data) {
        this.data = data;
    }
}
