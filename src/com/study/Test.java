package com.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class Test {

	public static void main(String[] args){
		Node node = new Node(3);
		
		node.appendToTail(4);
		node.next.appendToTail(5);
		node.next.next.appendToTail(8);
		
		node.appendToTail(9);
		
//		System.out.print(node.data);
		
		//char a ='��';
		//System.out.print(a);
		
		String str ="�Ѽ��̴��Ѽ��Ѽ����̴��̾�";
		
		Map<String, Integer> data = new HashMap<String, Integer>();
		
		//for(str.charAt(arrays) :str){
			
		//}
		
		for (int i=0; i<str.length(); i++){
			Character keys = str.charAt(i);
			String key = keys.toString();
			if(data.containsKey(key)){
				data.put(key, data.get(key)+1);
			} else {
				data.put(key, 1);
			}
			
		}
		
		Iterator iterator = data.keySet().iterator();
		// �ݺ��ڸ� �̿��ؼ� ���
		while (iterator.hasNext()) { 
			String key = (String)iterator.next(); // Ű ���
			System.out.println("key="+key+" / value="+data.get(key));  // ���
		}
		
		/*
		for (Iterator i = sortByValue(data).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            System.out.printf("key: %s, value: %s\n", key, data.get(key));
        }*/
		
		List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
			
		
	}
	/*
	public static List sortByValue(final Map m) {
        List keys = new ArrayList();
        keys.addAll(m.keySet());
        Collections.sort(keys, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = m.get(o1);
                Object v2 = m.get(o2);
                if (v1 == null) {
                    return (v2 == null) ? 0 : 1;
                }
                else if (v1 instanceof Comparable) {
                    return ((Comparable) v1).compareTo(v2);
                }
                else {
                    return 0;
                }
            }
        });
        return keys;
    }*/
}
