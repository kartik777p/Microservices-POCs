package com.nit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.nit.target.Calculator;

public class OperationsTest {

	private static Calculator calc=null;

	@BeforeAll
	//@BeforeClass
	public static void init() {
	 calc = new Calculator();
	}

	@org.junit.jupiter.api.Test
	public void add_Test() {
		// Calculator ops=new Calculator();
		System.out.println("OperationsTest.add_Test()");
		Integer actual = calc.add(10, 20);
		Integer expected = 30;
		assertEquals(expected, actual);
	}

	@org.junit.jupiter.api.Test
	public void mul_Test() {
		// Calculator ops=new Calculator();
		System.out.println("OperationsTest.mul_Test()");
		Integer actual = calc.mul(10, 20);
		Integer expected = 200;
		assertEquals(expected, actual);
	}
	
	@org.junit.jupiter.api.Test
	public void sub_Test() {
		// Calculator ops=new Calculator();
		System.out.println("OperationsTest.sub_Test()");
		Integer actual=calc.sub(20,10);
		Integer expected=10;
		assertEquals(expected,actual);
	}
	
	//@Ignore //to skip
	@org.junit.jupiter.api.Test
	public void div_Test_01() {
		// Calculator ops=new Calculator();
		System.out.println("OperationsTest.div_Test_01()");
		Integer actual = calc.div(10, 2);
		Integer expected = 5;
		assertEquals(expected, actual);
	}
	
	//@Test(expected = ArithmeticException.class) //from  org.junit.Test;
	//@org.junit.jupiter.api.Test
	public void div_Test_02() {
		// Calculator ops=new Calculator();
		System.out.println("OperationsTest.div_Test_02()");
		Integer actual = calc.div(10, 0);
	}
	
	@AfterAll
	//@AfterClass
	public static void destroy() {
		calc=null;
	}
}
