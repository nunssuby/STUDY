package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 전화 면접의 문자열 중 형태소문제에서 모티브,
 * 웹 문서에서 단어 카운팅 
 */
public class MinCount {
	
	//형태소 카운트
	public void checkMinCount(String str){
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		
		for (int i=0; i<str.length();i++){
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			else 
				map.put(str.charAt(i), 1);
		}
		
	}
	
	//카운트 하면서 list에 담아보려는 헛된 노력, 최소값은 동적으로 변하는데 저렇게 하면 안됨
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
	
	//여기서 부터 진짜 시작
	
	
	Map<String,Integer> countedMap;
	
	//String 결과만 list로 리턴
	public List getStringByDESC(String[] str){
		return getSortedString(getCountedString(str));
	}
	
	//n번까지 출력
	public void printSortedNCount(String[] str, int n){
		
		List<String> list = new ArrayList<String>();
		list = getSortedString(getCountedString(str));
		
		for (int i=0; i<n; i++){
			System.out.println(list.get(i)+" : "+ countedMap.get(list.get(i)));
		}
		
	}

	//counting된 map 획득,
	//재사용 위해 member변수로 기록(변명)
	private Map<String,Integer> getCountedString(String[] str){
		Map<String,Integer> resultMap = new HashMap(); 
				
		for (String s : str){
			if(resultMap.containsKey(s))
				resultMap.put(s, resultMap.get(s)+1);
			else resultMap.put(s, 1);
		}
		
		countedMap = new HashMap<String, Integer>();
		countedMap = resultMap;
		return resultMap;
	}
	
	//Comparator을 구현하여 sort 사용
	private List getSortedString(final Map<String,Integer> m){
		List<String> list = new ArrayList<String>(m.size());
		list.addAll(m.keySet());
		
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				
//				int result = 0;
//				int compare = m.get(s1).compareTo(m.get(s2));
//				
//				if(compare>0) result = -1;
//				else if (compare<0) result = 1;
				
//				return m.get(s1).compareTo(m.get(s2));
//				return result;
				
				
				//내림차순, 오름차순은 위처럼 if를 쓰는게 아니라 s1과 s2를 바꾸면 더 간담함
				//역시 생각이 짧았음
//				return m.get(s2).compareTo(m.get(s1));
				return m.get(s1).compareTo(m.get(s2));
			}
			
		});
		
		return list;
	}
		
		//Comparator을 구현하여 sort 사용
		private List getSortedStringByCompable(final Map<String,Integer> m){
			List<String> list = new ArrayList<String>(m.size());
			list.addAll(m.keySet());
			
//			Collections<Comparable>.sort(list);
		
		//아래를 사용하면 정렬이 뒤바뀜
//		Collections.reverse(list);
		
		return list;
	}
	

}
