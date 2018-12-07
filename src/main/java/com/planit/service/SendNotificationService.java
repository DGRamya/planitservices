package com.planit.service;

import org.springframework.stereotype.Service;

import com.planit.model.EmailDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class SendNotificationService {
	private JavaMailSender javaMailSender;

	@Autowired
	public SendNotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(EmailDetail emailDetail) throws MailException {
		System.out.println("Sending email from service ... " + emailDetail.getEmailId());
		String emailId = emailDetail.getEmailId().toString();  
		String[] sendTo = emailId.substring(1, emailId.length()-1).split(",");
		SimpleMailMessage mail = new SimpleMailMessage();
		System.out.println("sendEmail :: " + sendTo);
		for(String s : sendTo) {
			System.out.println("s :: " + s);
		}
		mail.setTo(sendTo);
		String content = emailDetail.getEmailContent();
		content = content + "\n" + 
		"Where: " + emailDetail.getEmailVenue() + "\n" +
				"When: " + emailDetail.getEmailDate(); 
		mail.setFrom("planit.p532@gmail.com");
		mail.setSubject(emailDetail.getEmailSubject());
		mail.setText(content);
		javaMailSender.send(mail);
		System.out.println("mail sent succesfully!");
	}
}
