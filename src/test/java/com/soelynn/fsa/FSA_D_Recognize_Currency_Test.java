package com.soelynn.fsa;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FSA_D_Recognize_Currency_Test {

	private static FSA AUTOMATA;
	
	@BeforeClass
	public static void initialize() throws Throwable {
		AUTOMATA = new FSA("src/test/resources/currency_fsa_transition_table.csv");
	}
	
	@Test
	public void testD_Recognize_positive_test_1() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("six", "dollars", "twenty", "one", "cents");
		
		Assert.assertTrue("D Recognize result is expected to be true.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_positive_test_2() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("six", "dollars");
		
		Assert.assertTrue("D Recognize result is expected to be true.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_positive_test_3() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("six", "cents");
		
		Assert.assertTrue("D Recognize result is expected to be true.", isAccepted);
	}
}
