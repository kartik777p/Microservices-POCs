package com.nit.target;

import java.util.Base64;
import java.util.Base64.Encoder;

public class EncoderDecoderUtils {

	public String encode(String txt) {
		Encoder encoder = Base64.getEncoder();
		String encodeToString = encoder.encodeToString(txt.getBytes());
		return encodeToString;
	}
	
	public String decode(String encodedString) {
		/*Decoder decoder = Base64.getDecoder();
		byte[] decodeToString = decoder.decode(encodedString);*/
		byte[] decodeToString = Base64.getDecoder().decode(encodedString);
		String decodedStr=new String(decodeToString);
		return decodedStr;
	}
}
