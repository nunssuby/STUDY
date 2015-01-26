package com.study;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListOfList {
	public static void main(String[] args) {
		List<Object> list2 = new ArrayList<Object>();
		list2.add(2);
		list2.add(1);
		
		List<Object> list3 = new ArrayList<Object>();
		list3.add(10);
		list3.add(1);
		
		List<Object> list = new ArrayList<Object>();
		list.add(3);
		list.add(list2);
		list.add(4);
		list.add(list3);
		
//		List<Integer> flattenList = sortList(list,null);
		List flattenList = sortList(list);
		System.out.println("original: " + list);
		System.out.println("flatten: " + flattenList);
	}
	
	public static List sortList(List l, TreeSet<Integer> tSet){
		if(tSet == null)
			tSet = new TreeSet<Integer>();
		
		for (int i=0; i<l.size();i++){
			if(l.get(i) instanceof List){
				sortList((List)l.get(i),tSet);
			} else {
				tSet.add(Integer.parseInt(l.get(i).toString()));
				
			}
		}
		Object[] test = tSet.toArray();
		return new ArrayList<Integer>(tSet);
	}
	
	public static List sortList(List l){
		
		
		for (int i=0; i<l.size();i++){
			if(l.get(i) instanceof List){
				List innerList = (List)l.get(i);
				l.remove(i);
				l.addAll(sortList(innerList));
			} 
		}
		Collections.sort(l);
		return l;
		
	}
}
