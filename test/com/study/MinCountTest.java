package com.study;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MinCountTest {
	
	MinCount minCount = new MinCount();

	@Test
	public void CheckMinStrtest() {
		//fail("Not yet implemented"); // TODO
		
		String str = "탐앤탐";
		
		assertThat(minCount.checkMinStr(str), is("앤"));
		str = "Q. 40억개의 정수가 하나의 파일에 들어있다고 가정하고, 숫자는 랜덤하게 40억개가 들어있다. 파일안에 포함되어 있지 않은 숫자 하나를 찾는 알고리즘은 어떻게 구하나요?";
		assertThat(minCount.checkMinStr(str), is("Q"));
	}
	
	@Test
	public void getSortedString(){
//		String[] str = {"새로운","세계를","위하여","달리자",};
		Map<String, Integer> map = new HashMap();
		map.put("새로운", 1);
		map.put("세계를", 2);
		map.put("위하여", 3);
		map.put("달리자", 15);
		assertThat(minCount.getSortedString(map).size(), is(4));
		System.out.println(minCount.getSortedString(map));
	}
	
	@Test
	public void getStringByDESC(){
		String[] str = {"새로운","세계를","위하여","달리자","달리자","달리자","달리자","새로운"};
		System.out.println(minCount.getStringByDESC(str));
		assertThat(minCount.getStringByDESC(str).size(), is(4));
	}

}
