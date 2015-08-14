package com.soelynn.fsa;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FSA_D_Recognize_Sheep_Test {

	private static FSA<String> AUTOMATA;
	private static TransitionTable<String> TRANSITION_TABLE;
	
	@BeforeClass
	public static void initialize() throws Throwable {
		TRANSITION_TABLE = new TransitionTable<String>();
		TRANSITION_TABLE.addEntry("b", 0, 1);
		TRANSITION_TABLE.addEntry("a", 1, 1);
		TRANSITION_TABLE.addEntry("!", 1, FSA.END_STATE);
		
		AUTOMATA = new FSA<String>(TRANSITION_TABLE);
	}
	
	@Test
	public void testD_Recognize_positive_test_1() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("b", "a", "!");
		
		Assert.assertTrue("D Recognize result is expected to be true.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_positive_test_2() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("b", "a", "a", "a", "!");
		
		Assert.assertTrue("D Recognize result is expected to be true.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_negative_test_1() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("b", "a", "a");
		
		Assert.assertFalse("D Recognize result is expected to be false.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_negative_test_2() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("a");
		
		Assert.assertFalse("D Recognize result is expected to be false.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_negative_test_3() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize();
		
		Assert.assertFalse("D Recognize result is expected to be false.", isAccepted);
	}
	
	@Test
	public void testD_Recognize_negative_test_4() throws Throwable {
		
		boolean isAccepted = AUTOMATA.d_recognize("b", "a", "!", "a");
		
		Assert.assertFalse("D Recognize result is expected to be false.", isAccepted);
	}

}
