package com.example.basiceProjectForConversionCurrency.conversionCurrency.config;

import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

    @Value("${currency.base.url}")
    private String CURRENCY_URL;



    @Bean
    @Qualifier("CurrencyRestClient")
    RestClient getRestClient(){
        return RestClient.builder()
                .baseUrl(CURRENCY_URL)
                .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                .build();
    }

}
