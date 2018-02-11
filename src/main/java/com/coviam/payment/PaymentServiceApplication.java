package com.coviam.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
@EnableTransactionManagement
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate template =  new RestTemplate();
		template.getMessageConverters().add(new FormHttpMessageConverter());
		template.setErrorHandler(new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				// Don't want restTemplate to handle my error.
			}
		});
		return template;
	}

}
