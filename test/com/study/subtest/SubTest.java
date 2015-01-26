package com.study.subtest;

import com.study.MinCount;

public class SubTest extends MinCount{
	
	public SubTest(String[] str){
		super.getCountedString(str);
	}
	
	public SubTest(){
	
	}
	
	public static void main(String[] args){
		
		SubTest subtest = new SubTest();
		String[] str = new String[3];
		System.out.println(subtest.getStringByDESC(str));
		System.out.println(subtest.getCountedString(str));
//		System.out.println(subtest.);
	}
}
