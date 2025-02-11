package com.example.productservice.configurations;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
}
