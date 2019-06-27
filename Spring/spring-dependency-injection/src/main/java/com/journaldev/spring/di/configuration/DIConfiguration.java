package com.journaldev.spring.di.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.journaldev.spring.di.services.EmailService;
import com.journaldev.spring.di.services.MessageService;

@Configuration
@ComponentScan(value={"com.journaldev.spring.di"})
public class DIConfiguration {

	@Bean(name = "emailServiceBean")
	public MessageService getMessageService(){
		return new EmailService();
	}

}
