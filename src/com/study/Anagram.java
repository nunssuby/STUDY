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
//		�׷��� ���� C�� ���ϰ� ���� �򰥸��� ��������
//		�׸��� JAVA���� ��������� �ʱ�ȭ�� ��������� ���ص� ���� 
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
//			������ �����ص� ����� �˰���? �迭�� �Ʒ� ������ ���� ���ϸ� 
			if(Arrays.equals(str1Set, str2Set)) return true;
		}
		
		return false;
	}
}
