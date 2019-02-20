package com.core.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮箱工具类 JavaMail 版本: 1.6.0 JDK 版本: JDK 1.7及 以上（必须）
 * 
 * @author huangdongwen
 *
 */
public class SendEmail {
	// 获取邮箱配置文件
	public static DBInfoUtils properties = new DBInfoUtils("sendMail.properties");

	/**
	 * 发送新密码到邮箱 收件人邮箱
	 * 
	 * @param receiveMailAccount
	 *            新密码
	 * @param userrandompwd
	 * 
	 * @throws Exception
	 */

	public static void send(String userrandompwd) throws Exception {
		// 获取配置文件发件人收件人 邮箱的 SMTP 服务器地址

		String myEmailAccount = properties.getValue("sendmial");
		String myEmailSMTPHost = properties.getValue("EmailSMTPHost");
		String myEmailPassword = properties.getValue("EmailPassword");
		String smtpPort = properties.getValue("smtpPort");
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP
																// 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

		// 3. 创建一封邮件
		MimeMessage message = createMimeMessage(session, myEmailAccount, userrandompwd);

		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();

		// 5: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
		transport.connect(myEmailAccount, myEmailPassword);

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人,
		// 抄送人, 密送人
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();
	}

	/**
	 * 创建邮件
	 * 
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @param userrandompwd
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMimeMessage(Session session, String sendMail, String userrandompwd)
			throws Exception {

		String fromname = properties.getValue("sendmial");
		String mailtile = properties.getValue("mailtile");
		String receiveMail = properties.getValue("receiveMail");
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人
		message.setFrom(new InternetAddress(sendMail, fromname, "UTF-8"));

		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

		// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
		message.setSubject(mailtile, "UTF-8");

		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
		message.setContent(userrandompwd, "text/html;charset=UTF-8");

		// 6. 设置发件时间
		message.setSentDate(new Date());

		// 7. 保存设置
		message.saveChanges();

		return message;
	}
public static void main(String[] args) throws Exception {
	String content = "姓名：" + "test" + ", 邮箱：" + "123" + ", 内容：" + "内容";
	send(content);
}
}
