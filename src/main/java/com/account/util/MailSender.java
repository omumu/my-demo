package com.account.util;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.account.model.Mail;

@Repository("mailSender")
public class MailSender {
	//注入 配置文件中的 javaMailSender
	@Resource
	private JavaMailSender javaMailSender;

	public void sendSimpleMail(Mail mail) {
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		// JavaMailSender sender = (JavaMailSender)
		// ac.getBean("javaMailSender");
		SimpleMailMessage simpleMail = new SimpleMailMessage();
		simpleMail.setFrom(mail.getFrom());
		simpleMail.setTo(mail.getTo());
		simpleMail.setSubject(mail.getSubject());
		simpleMail.setSentDate(new Date());
		simpleMail.setText(mail.getContentText());
		javaMailSender.send(simpleMail);
		System.out.println("发送成功！");
	}

	public void sendHtmlMail(Mail mail) {
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		// JavaMailSender sender = (JavaMailSender)
		// ac.getBean("javaMailSender");
		MimeMessage messageMail = javaMailSender.createMimeMessage();
		try {
			System.out.println("邮件正在以html的形式开始发送！");
			MimeMessageHelper helper = new MimeMessageHelper(messageMail, true, "UTF-8");
			helper.setFrom(mail.getFrom());
			helper.setTo(new InternetAddress("\"" + MimeUtility.encodeText("qq邮箱") + "\"<" + mail.getTo() + ">"));
			helper.setSentDate(new Date());
			helper.setReplyTo(mail.getFrom());
			helper.setSubject(mail.getSubject());// 主题
			helper.setText(mail.getContentText(), true);
			// 设置邮件内容！！！
			javaMailSender.send(messageMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("html 邮件发送成功！");
	}

	// 带附件的邮件 未启用
	public void sendFileMail(Mail mail) {
		// ApplicationContext ac = new
		// ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		// JavaMailSender sender = (JavaMailSender)
		// ac.getBean("javaMailSender");
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			System.out.println("邮件 以html 形式发送 with 文件！！！！");
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setFrom("joecqupt@126.com");
			helper.setTo(new InternetAddress("\"" + MimeUtility.encodeText("qq邮箱") + "\"<469391363@qq.com>"));
			helper.setSentDate(new Date());
			helper.setReplyTo("joecqupt@126.com");
			helper.setSubject("html mail test");// 主题
			helper.setText("<html><head><meta charset='utf-8'/></head><body><h1>hello i am joe!</h1></body></html>",
					true);
			helper.addAttachment(MimeUtility.encodeText("附件.jpg"), new File("images/ys.jpg"));
			// helper.addInline(MimeUtility.encodeText("pic01.jpg"), new
			// File("images/ys.jpg"));
			// 现在一般不这样内嵌图片了！！
			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("发送成功！！");
	}
}
