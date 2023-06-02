package com.nit.target;

public class Calculator {
 
	public Integer add(Integer a, Integer b) {
		System.out.println("Oprations.add()");
		return a+b;
	}
	
	public Integer sub(Integer a, Integer b) {
		System.out.println("Oprations.sub()");
		return a-b;
	}
	
	public Integer mul(Integer a, Integer b) {
		System.out.println("Oprations.mul()");
		return a*b;
	}
	
	public Integer div(Integer a, Integer b) {
		System.out.println("Oprations.div()");
		return a/b;
	}
}
