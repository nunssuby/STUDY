package com.study;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinCountTest {
	
	MinCount minCount = new MinCount();

	@Test
	public void CheckMinStrtest() {
		//fail("Not yet implemented"); // TODO
		
		String str = "Ž��Ž";
		
		assertThat(minCount.checkMinStr(str), is("��"));
		str = "Q. 40�ﰳ�� ������ �ϳ��� ���Ͽ� ����ִٰ� �����ϰ�, ���ڴ� �����ϰ� 40�ﰳ�� ����ִ�. ���Ͼȿ� ���ԵǾ� ���� ���� ���� �ϳ��� ã�� �˰����� ��� ���ϳ���?";
		assertThat(minCount.checkMinStr(str), is("Q"));
	}

}
