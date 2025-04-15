package sn.intouch.gu.iabiri.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Utils {
	
	public static String formatLabel(Double stock) {
	      
		if (stock ==null)
			return "0";
		final NumberFormat nf = NumberFormat.getInstance();
	    nf.setMaximumFractionDigits(2);
	      
	    return nf.format(stock);
	}
	
	/**
	 * Test si un String est null ou vide
	 * @param s
	 * @return
	 */
	public static boolean isNullOrEmpty(String s){
		return s == null || s.isEmpty() ;
	}
	
	/**
	 * Crypte les mots de passe
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String getEncodedPassword(String key) throws NoSuchAlgorithmException {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		StringBuffer hashString = new StringBuffer();
		for ( int i = 0; i < hash.length; ++i ) {
			String hex = Integer.toHexString(hash[i]);
			if ( hex.length() == 1 ) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length()-1));
			} else {
				hashString.append(hex.substring(hex.length()-2));
			}
		}
		return hashString.toString();
	}
	
	public static void sendEmail(String destEmail, String subject, String body){
		final String username = "intotal2016@gmail.com";
		final String password = "total2016";
 
		Properties props = new Properties();
		
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
 
		try {
 
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("intotal2016@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destEmail));
			message.setSubject(subject);
			message.setText(body, "utf-8", "html");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	 private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    private static int charLength = chars.length();
	    public static String generateString(int length) {
	        StringBuilder  pass = new StringBuilder (charLength);
	        for (int x = 0; x < length; x++) {
	            int i = (int) (Math.random() * charLength);
	            pass.append(chars.charAt(i));
	        }
	        return pass.toString();
	    }
	    
	    public static String getSettingsProperty(String property) {
			InputStream settingsStream = Utils.class.getClassLoader().getResourceAsStream("settings.properties");

			Properties props = new Properties();
			try {
				props.load(settingsStream);
			} catch (IOException e) {
				return null;
			}
			return props.getProperty(property);
		}
	   
}
