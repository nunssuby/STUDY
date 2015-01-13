package com.study;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {
	Anagram anagram = new Anagram();
	@Test
	public void testCheckAnagram() {
		//fail("Not yet implemented"); // TODO
		String str1="abc";
		String str2="bca";
		//assertThat(anagram.checkAnagram(str1, str2), is(true));
		assertThat(anagram.checkAnagram(str1, str2), is(true));
		
		str1="aabc";
		str2="baca";
		assertThat(anagram.checkAnagram(str1, str2), is(true));
	}

}
