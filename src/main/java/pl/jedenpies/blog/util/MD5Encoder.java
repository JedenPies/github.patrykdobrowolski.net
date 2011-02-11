package pl.jedenpies.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {

	public static String encode(String text) {
		
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(text.getBytes(), 0, text.length());
			String result = String.valueOf(m.digest());
			return result;
		} catch (NoSuchAlgorithmException e) {
			// Never happens
			return text;
		}
	}
}
