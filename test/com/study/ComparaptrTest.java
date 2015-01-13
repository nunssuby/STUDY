package com.study;


import static org.junit.Assert.*;

import org.junit.Test;

public class ComparaptrTest {

	@Test
	public void isSame() {
		assertTrue(Comparator.isSame(0,0));
		assertTrue(Comparator.isSame(1,1));
	}
}
