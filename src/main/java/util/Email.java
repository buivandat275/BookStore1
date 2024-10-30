package util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	//Email:bvdat.dhti15a11hn@sv.uneti.edu.vn
	//pass:coam wvsw eihv cxfd
	static String from = "bvdat.dhti15a11hn@sv.uneti.edu.vn";
	static final String pass= "coamwvsweihvcxfd";
	//final String to = "buivandat275@gmail.com";
	
	public static boolean sendEmail(String to,String tieuDe, String noiDung) {

			// properties:
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");// SMTP HOST
			props.put("mail.smtp.port", "587"); //TLS 587  SSL 465
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			// creeare Authenticator
			Authenticator auth = new Authenticator() {

				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(from, pass);
				}
			};
			
			// phieen lam viec
			Session session = Session.getInstance(props,auth);
			
			// Gui email
			
			
			//tao 1 tin nhan
			MimeMessage msg = new MimeMessage(session);
			try {
				msg.addHeader("Content-type", "text/HTML;charset = UTF-8");
				//ng nhan
				msg.setFrom(from);
				//nguoi nhan
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
				//tieu de mail
				msg.setSubject(tieuDe);
				//quy dinh ngay gui
				msg.setSentDate(new Date());
				//quy ddinh email nhan phan hoi
				//msg.setReplyTo(null);  khi nguoi ta phan hoi laij se duoc gui di dau, con mac dinh thi ko can
				
				// Noi dung
				msg.setContent(noiDung,"text/html;charset = UTF-8");
				
				// gui email
				Transport.send(msg);
				System.out.println("thanh conggg");
				return true;
				
				
				
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} 
	}
	
//	public static void main(String[] args) {
//		Email.sendEmail("buivandat275@gmail.com","Thu nghiem D-Mail" ,"Phần nội dung");
//		
//	}
	
	
}
