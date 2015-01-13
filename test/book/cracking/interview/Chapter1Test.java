package book.cracking.interview;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class Chapter1Test {
	Chapter1 chapter1 = new Chapter1();
	@Test
	public void testUniquecheck() {
		//fail("Not yet implemented"); // TODO
		String str = "abcdefgahi";
		assertThat(chapter1.uniquecheck(str), is(false));
	}

}
