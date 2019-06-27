package com.journaldev.spring.di.services;

import org.springframework.stereotype.Service;

@Service(value = "emailServiceService")
public class EmailService implements MessageService {

	public boolean sendMessage(String msg, String rec) {
		System.out.println("Email Sent to "+rec+ " with Message="+msg);
		return true;
	}

}
