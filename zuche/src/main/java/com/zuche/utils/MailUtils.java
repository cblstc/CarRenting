package com.zuche.utils;

import java.net.UnknownHostException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的工具类
 * @author cbl
 *
 */
public class MailUtils {

	/**
	 * 
	 * @param fromEmail  发件人
	 * @param username   发件人用户名
	 * @param password   发件人密码
	 * @param toEmail    收件人
	 * @param subject    主题
	 * @param content    内容
	 * @throws MessagingException
	 * @throws UnknownHostException
	 */
	public static void sendMail(String fromEmail, String username, String password, String toEmail, String subject, String content) throws MessagingException, UnknownHostException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		Message msg = new MimeMessage(session);
		msg.setSubject(subject);
		
		msg.setText(content);
		msg.setFrom(new InternetAddress(fromEmail));
		Transport transport = session.getTransport();
		transport.connect(username, password);
		transport.sendMessage(msg, new Address[] {new InternetAddress(toEmail)});
		transport.close();
	}
}
