package jpa.jpashop.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MemberUtil {

	public static String getHashSHA256(String pwd) {
		String hexPwd = null;
		// 비밀번호 암호화를 위해 MessageDigest를 사용.
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		// 해시 초기화.
		md.reset();
		
		/*
		 * utf8 character set으로 해싱에 사용할 값을 바이트코드로 변환하여 
		 * 해싱 인스턴스에 업데이트.
		 */
		try {
			md.update(pwd.getBytes("utf8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/* 64라운드 형식으로 format, 256은 보통 41~64라운드형식으로 
		 * formating 한다. 
		 */
		hexPwd = String.format("%064x", new BigInteger(1, md.digest()));
		
		return hexPwd;
	}
}
