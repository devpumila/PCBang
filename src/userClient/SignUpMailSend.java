package userClient;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SignUpMailSend {
	public SignUpMailSend() {
	}

	public String NaverMailSend(String userEmail) {
		Properties props;
		@SuppressWarnings("unused")
		String host = "smtp@naver.com";
		String user = "dcsfbi3@naver.com";// 
		String password = "!ghkddlswjd7786"; // 
		String checkNum = null;

		props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable ", "true");
		props.put("mail.smtp.ssl.trust", "smtp.naver.com");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);

			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user, "XXPC방"));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress("" + userEmail + ""));

			message.setSubject("인증번호");

			checkNum = checkNum();
			message.setText("XXPC방 인증번호 : " + checkNum);

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(checkNum);
		return checkNum;
	}// mailSend()

	public String checkNum() {
		String checkNum = "";
		for (int i = 0; i < 5; i++) {
			checkNum += Integer.toString((int) (Math.random() * 10));
		}

		return checkNum;
	}
}
