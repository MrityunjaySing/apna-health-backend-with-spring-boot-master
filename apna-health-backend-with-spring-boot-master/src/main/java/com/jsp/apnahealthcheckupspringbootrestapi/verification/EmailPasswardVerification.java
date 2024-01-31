package com.jsp.apnahealthcheckupspringbootrestapi.verification;

import java.util.regex.Pattern;

/***
 * @author Manish kuamr
 * 
 * EmailPasswardVerification class is for how to verifyEmail and Passward
 */

public class EmailPasswardVerification {
   
	public static String verifyEmail(String email) {
		
		Pattern number = Pattern.compile("[0-9]");
		Pattern alphabet = Pattern.compile("[a-zA-Z]");
		Pattern special = Pattern.compile("[@.]");
		
		if((number.matcher(email).find()) && (alphabet.matcher(email).find()) && (special.matcher(email).find())) {
			return email;
		}
		else {
			System.out.println("Email verification is Wrong");
			return null;
		}
	}
	
public static String verifyPassward(String passward) {
		
		Pattern number = Pattern.compile("[0-9]");
		Pattern alphabet = Pattern.compile("[a-zA-Z]");
		Pattern special = Pattern.compile("[@.#$%^&*]");
		
	 if(passward.length()<=8) {	
		if((number.matcher(passward).find()) && (alphabet.matcher(passward).find()) && (special.matcher(passward).find())) {
			return passward;
		}
		else {
			return null;
		}
	  }
	 else {
		 return null;
	 }
	}
}
