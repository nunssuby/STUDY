package com.study;

public class Count40 {
	
	Integer intvalue = new Integer(3);
	Integer intvalues = new Integer(3);

	public static void main(String[] args){
		int x = checkSame(3, 3);
		System.out.println(x);
	}
	static int checkSame(int a, int b){
		return (a & b);
	}
}
