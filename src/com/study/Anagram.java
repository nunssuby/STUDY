package com.study;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Anagram {
	/*       
	public LinkedHashSet checkAnagram(String[] str){
		List<Set> list = new ArrayList<Set>();
		Set itsHashSet = new HashSet();
		                                                      
		
		itsHashSet.add(arg0)
		
		return itsHashSet;
	}
	*/
//	public boolean checkAnagram(String str1, String str2){
//	
//		return false;
//	}
	
	boolean checkAnagram(String str1, String str2){
//		그렇게 오래 C를 안하고도 아직 헷갈리냐 머저리야
//		그리고 JAVA에서 멤버변수는 초기화를 명시적으로 안해도 해줌 
//		int str1Set[256];
//		int str2Set[256];
		int[] str1Set = new int[256];
		int[] str2Set = new int[256];
		if(str1.length() == str2.length()){
			for(int i=0; i<str1.length();i++)
				str1Set[str1.charAt(i)]++;
			
			for(int i=0; i<str2.length();i++)
				str2Set[str2.charAt(i)]++;
			
//			if(str1Set==str2Set) return true;
//			위에는 말안해도 어떤비굔지 알것지? 배열은 아래 문법을 통해 비교하면 
			if(Arrays.equals(str1Set, str2Set)) return true;
		}
		
		return false;
	}
	
}
