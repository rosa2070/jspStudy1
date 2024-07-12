package com.exam.mail;

//import java.net.Authenticator;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	private String fromEmail;
	private String fromPassword;
	
	public MyAuthenticator(String fromEmail, String fromPassword) {
		// TODO Auto-generated constructor stub
		this.fromEmail = fromEmail;
		this.fromPassword = fromPassword;
		
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		// TODO Auto-generated method stub
		return new PasswordAuthentication(fromEmail, fromPassword);
	}
	
}
