package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	// javaMailSender
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(String sub, String body, String to) {
		boolean isSend = false;
		try {
			//set all details 
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setSubject(sub);
			msg.setText(body);
			msg.setTo(to);
           // send msg using mailSender
			mailSender.send(msg);
			//make flag true
			isSend=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				return isSend;
	}

}
