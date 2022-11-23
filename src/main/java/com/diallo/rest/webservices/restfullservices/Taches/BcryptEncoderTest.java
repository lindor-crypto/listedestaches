package com.diallo.rest.webservices.restfullservices.Taches;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("Cheikh88@");
		
		
		for (int i = 0; i <=10; i++) {
			System.out.println(encode);
		}
		// TODO Auto-generated method stub

	}

}
