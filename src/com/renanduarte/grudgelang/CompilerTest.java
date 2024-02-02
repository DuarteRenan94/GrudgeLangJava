package com.renanduarte.grudgelang;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CompilerTest {

	@Test
	void test() {
		String grudge = "aaaaaaaaaaaaAaaaAaaaaaAAaaAAaAAAAaaaAAA";
		int[] assertion = { 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Compiler c = new Compiler();
		try {
			c.compile(grudge);
			assertArrayEquals(assertion, c.showMemory());
		} catch (CompilerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
