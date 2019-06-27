package com.journaldev.spring.di.services;

import org.springframework.stereotype.Service;

@Service(value="twitterService")
public class TwitterService implements MessageService {

	public boolean sendMessage(String msg, String rec) {
		System.out.println("Twitter message Sent to "+rec+ " with Message="+msg);
		return true;
	}

}
