package com.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MinCount {
	
	public void checkMinCount(String str){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for (int i=0; i<str.length();i++){
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			else 
				map.put(str.charAt(i), 1);
		}
		
	}
	
	public String checkMinStr(String str){
		Map<String, Integer> data = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		for (int i=0; i<str.length(); i++){
			Character keys = str.charAt(i);
			String key = keys.toString();
			
			if(data.containsKey(key)){
				data.put(key, data.get(key)+1);
			} else {
				data.put(key, 1);
			}
			
			if(list.isEmpty()){
				list.add(key);
			}else{
				//System.out.println("list is "+ list.get(0));
				if(data.get(list.get(0))> data.get(key)){
					list.add(0,key);
				}else{
					
				}
					
			}
		}
		
		return list.get(0);
	}

	

}
