package com.renanduarte.grudgelang;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CompilerTest {

	@Test
	void GDGTest() {
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

	@Test
	void BFGDGTest() {
		String bf = "++++++++++[>++++++++>+++++++++++>++++++++++>++++>+++>++++++++>++++++++++++>+++++++++++>++++++++++>+++++++++++>+++>+<<<<<<<<<<<<-]>-.>--.>---.>++++.>++.>---.>---.>.>.>+.>+++.>.";
		int[] assertion = { 0, 79, 108, 97, 44, 32, 77, 117, 110, 100, 111, 33, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		Compiler c = new Compiler();
		try {
			String grudge = c.convertFromBFCodeToGDG(bf);
			c.compile(grudge);
			assertArrayEquals(assertion, c.showMemory());
		} catch (CompilerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void GDGtoBFTest() {
		String grudge = "aaaaaaaaaaaaAaaaAaaaaaAAaaAAaAAAAaaaAAA";
		Compiler c = new Compiler();
		String bf = c.convertFromGDGCodeToBF(grudge);
		System.out.println(bf);
	}

}
