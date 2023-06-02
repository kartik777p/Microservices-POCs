package com.nit.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.nit.target.EncoderDecoderUtils;

public class EncoderDecoderTest {

	private static EncoderDecoderUtils utils = null;

	@BeforeAll
	public static void init() {
		utils = new EncoderDecoderUtils();
	}
	
	@Test
	public void testEncodeString() {
		String encodeVal = utils.encode("NareshIt");
		System.out.println("Encoded Value :- "+encodeVal);
		assertNotNull(encodeVal);
	}
	
	@Test
	public void testDecodedTxt() {
		String decodeVal = utils.decode("TmFyZXNoSXQ=");
		System.out.println("Decoded Value :- "+decodeVal);
		assertNotNull(decodeVal);
	}
	
	@AfterAll
	public static void destroy() {
		utils=null;
	}
}
