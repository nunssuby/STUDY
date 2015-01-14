package com.study;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Count40Test {
	Count40 count40 = new Count40();
	@Test
	public void testNoFileNum() {
		try {
			assertThat(count40.noFileNum(), is(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
