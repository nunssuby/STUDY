package com.study;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ListOfListTest {

	@Test
	public void testSortListListSetOfInteger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSortListList() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void mergeListTest(){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		list2.add(4);
		list2.add(5);
		
		list1.addAll(list2);
		
		System.out.println(list1);
		
	}

}
