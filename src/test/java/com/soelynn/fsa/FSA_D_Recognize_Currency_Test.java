package com.soelynn.fsa;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FSA_D_Recognize_Currency_Test {

	private static FSA<String> AUTOMATA;
	private static TransitionTable<String> TRANSITION_TABLE;
	
	@BeforeClass
	public static void initialize() throws Throwable {
		TRANSITION_TABLE = new TransitionTable<String>();
		
		// From State 0 to State 1
		TRANSITION_TABLE.addEntry("twenty", 0, 1);
		TRANSITION_TABLE.addEntry("thirty", 0, 1);
		TRANSITION_TABLE.addEntry("forty", 0, 1);
		TRANSITION_TABLE.addEntry("fifty", 0, 1);
		TRANSITION_TABLE.addEntry("sixty", 0, 1);
		TRANSITION_TABLE.addEntry("seventy", 0, 1);
		TRANSITION_TABLE.addEntry("eighty", 0, 1);
		TRANSITION_TABLE.addEntry("ninety", 0, 1);
		
		// From State 0 to State 2
		TRANSITION_TABLE.addEntry("one", 0, 2);
		TRANSITION_TABLE.addEntry("two", 0, 2);
		TRANSITION_TABLE.addEntry("three", 0, 2);
		TRANSITION_TABLE.addEntry("four", 0, 2);
		TRANSITION_TABLE.addEntry("five", 0, 2);
		TRANSITION_TABLE.addEntry("six", 0, 2);
		TRANSITION_TABLE.addEntry("seven", 0, 2);
		TRANSITION_TABLE.addEntry("eight", 0, 2);
		TRANSITION_TABLE.addEntry("nine", 0, 2);
		TRANSITION_TABLE.addEntry("ten", 0, 2);
		TRANSITION_TABLE.addEntry("twenty", 0, 2);
		TRANSITION_TABLE.addEntry("thirty", 0, 2);
		TRANSITION_TABLE.addEntry("forty", 0, 2);
		TRANSITION_TABLE.addEntry("fifty", 0, 2);
		TRANSITION_TABLE.addEntry("sixty", 0, 2);
		TRANSITION_TABLE.addEntry("seventy", 0, 2);
		TRANSITION_TABLE.addEntry("eighty", 0, 2);
		TRANSITION_TABLE.addEntry("ninety", 0, 2);
		TRANSITION_TABLE.addEntry("eleven", 0, 2);
		TRANSITION_TABLE.addEntry("twelve", 0, 2);
		TRANSITION_TABLE.addEntry("thirteen", 0, 2);
		TRANSITION_TABLE.addEntry("fourteen", 0, 2);
		TRANSITION_TABLE.addEntry("fifteen", 0, 2);
		TRANSITION_TABLE.addEntry("sixteen", 0, 2);
		TRANSITION_TABLE.addEntry("seventeen", 0, 2);
		TRANSITION_TABLE.addEntry("eighteen", 0, 2);
		TRANSITION_TABLE.addEntry("nineteen", 0, 2);
		
		// From State 2 to State 3 - Since State 3 is one of the leaf node. It will be set as END_STATE.
		TRANSITION_TABLE.addEntry("cents", 2, FSA.END_STATE);
		
		// From State 2 to State 4 - State 4 is both end node and forward node. So, it will be set as MIXED_STATE.
		TRANSITION_TABLE.addEntry("dollars", 2, 4);
		TRANSITION_TABLE.addEntry("dollars", 2, FSA.END_STATE);
		
		// From State 4 to State 5
		TRANSITION_TABLE.addEntry("twenty", 4, 5);
		TRANSITION_TABLE.addEntry("thirty", 4, 5);
		TRANSITION_TABLE.addEntry("forty", 4, 5);
		TRANSITION_TABLE.addEntry("fifty", 4, 5);
		TRANSITION_TABLE.addEntry("sixty", 4, 5);
		TRANSITION_TABLE.addEntry("seventy", 4, 5);
		TRANSITION_TABLE.addEntry("eighty", 4, 5);
		TRANSITION_TABLE.addEntry("ninety", 4, 5);
		
		// From State 4 to State 6
		TRANSITION_TABLE.addEntry("one", 4, 6);
		TRANSITION_TABLE.addEntry("two", 4, 6);
		TRANSITION_TABLE.addEntry("three", 4, 6);
		TRANSITION_TABLE.addEntry("four", 4, 6);
		TRANSITION_TABLE.addEntry("five", 4, 6);
		TRANSITION_TABLE.addEntry("six", 4, 6);
		TRANSITION_TABLE.addEntry("seven", 4, 6);
		TRANSITION_TABLE.addEntry("eight", 4, 6);
		TRANSITION_TABLE.addEntry("nine", 4, 6);
		TRANSITION_TABLE.addEntry("ten", 4, 6);
		TRANSITION_TABLE.addEntry("twenty", 4, 6);
		TRANSITION_TABLE.addEntry("thirty", 4, 6);
		TRANSITION_TABLE.addEntry("forty", 4, 6);
		TRANSITION_TABLE.addEntry("fifty", 4, 6);
		TRANSITION_TABLE.addEntry("sixty", 4, 6);
		TRANSITION_TABLE.addEntry("seventy", 4, 6);
		TRANSITION_TABLE.addEntry("eighty", 4, 6);
		TRANSITION_TABLE.addEntry("ninety", 4, 6);
		TRANSITION_TABLE.addEntry("eleven", 4, 6);
		TRANSITION_TABLE.addEntry("twelve", 4, 6);
		TRANSITION_TABLE.addEntry("thirteen", 4, 6);
		TRANSITION_TABLE.addEntry("fourteen", 4, 6);
		TRANSITION_TABLE.addEntry("fifteen", 4, 6);
		TRANSITION_TABLE.addEntry("sixteen", 4, 6);
		TRANSITION_TABLE.addEntry("seventeen", 4, 6);
		TRANSITION_TABLE.addEntry("eighteen", 4, 6);
		TRANSITION_TABLE.addEntry("nineteen", 4, 6);
		
		// From State 5 to State 6
		TRANSITION_TABLE.addEntry("one", 5, 6);
		TRANSITION_TABLE.addEntry("two", 5, 6);
		TRANSITION_TABLE.addEntry("three", 5, 6);
		TRANSITION_TABLE.addEntry("four", 5, 6);
		TRANSITION_TABLE.addEntry("five", 5, 6);
		TRANSITION_TABLE.addEntry("six", 5, 6);
		TRANSITION_TABLE.addEntry("seven", 5, 6);
		TRANSITION_TABLE.addEntry("eight", 5, 6);
		TRANSITION_TABLE.addEntry("nine", 5, 6);
		
		// From State 6 to State 7 - Since State 7 is one of the leaf node. It will be set as END_STATE.
		TRANSITION_TABLE.addEntry("cents", 6, FSA.END_STATE);
		
		AUTOMATA = new FSA<String>(TRANSITION_TABLE);
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
