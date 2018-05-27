package com.join.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(String to, String title, String content) {

		MimeMessage mail = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setTo(to);
			helper.setReplyTo("jointest@onet.pl");
			helper.setFrom("jointest@onet.pl");
			helper.setSubject(title);
			helper.setText(content);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mail);
	}
}
