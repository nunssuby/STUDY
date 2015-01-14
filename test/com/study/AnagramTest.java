package com.study;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import namo.Problem02;

import org.junit.Test;

public class AnagramTest {
	
	@Test
	public void testCheckAnagram() {
		Anagram anagram = new Anagram();
		//fail("Not yet implemented"); // TODO
		String str1="abc";
		String str2="bca";
		//assertThat(anagram.checkAnagram(str1, str2), is(true));
		assertThat(anagram.checkAnagram(str1, str2), is(true));
		
		str1="aabc";
		str2="baca";
		assertThat(anagram.checkAnagram(str1, str2), is(true));
	}
	
	private void assertAnagram(boolean isTrue, String a, String b) {
		Anagram anagram = new Anagram();
		assertEquals(isTrue, anagram.checkAnagram(a, b));
	}

	@Test
	public void testSameAnagram() {
		assertAnagram(true, "a", "a");
		assertAnagram(true, "b", "b");
		assertAnagram(true, "ab", "ab");
		assertAnagram(true, "abc", "abc");
	}
	
	@Test
	public void testRotatedAnagram() {
		assertAnagram(true, "ab", "ba");
		assertAnagram(true, "bc", "cb");
		assertAnagram(true, "abc", "cab");
		assertAnagram(true, "bca", "abc");
		assertAnagram(true, "cab", "bca");
		assertAnagram(true, "aabc", "abca");
	}
	
	@Test
	public void testNotAnagramInDictionary() {
		assertAnagram(true, "words", "sword");
		assertAnagram(true, "finder", "friend");
	}
	
	@Test
	public void testNotAnagram() {
		assertAnagram(false, "ab", "bc");
		assertAnagram(false, "abc", "abd");
	}
	
	@Test//(expected=IllegalArgumentException.class)
	public void testIncludeUppercaseException() {
		assertAnagram(false, "abC", "bcD");
	}

}
