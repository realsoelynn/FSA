package com.soelynn.fsa;

import java.util.ArrayList;

import com.soelynn.fsa.internal.TransitionTable;
import com.soelynn.fsa.internal.TransitionTableHelper;

public class FSA {

	private static int START_STATE = 0;
	public static int END_STATE = -1;
	
	private TransitionTable transitionTable;
	
	public FSA(String transitionTableFileURL) throws Throwable {
		this(TransitionTableHelper.loadFromCSV(transitionTableFileURL));
	}
	
	public FSA(TransitionTable transitionTable) throws Throwable {
		this.transitionTable = transitionTable;
		
		if(transitionTable == null) {
			throw new Throwable("Please set the transition table for the finite state automata");
		}
		
	}
	
	public boolean d_recognize(String... tape) {
		
		String[] new_tape;
		
		// Smart-feature to switch between the input wherether single character or word level input
		if(tape.length == 1) {
			new_tape = tape[0].split("(?!^)");
		} 
		else {
			new_tape = tape;
		}
		
		return d_recognize(0, START_STATE, new_tape);
	}
	
	private boolean d_recognize(int startIndex, int currentState, String... tape) {
		boolean accept = false;
			
		for(int index = startIndex; index < tape.length; index++) {
			ArrayList<Integer> nextStates = transitionTable.getNextState(currentState, tape[index]);
						
			if(nextStates == null) {
				break;
			}
			
			for(int nextState: nextStates) {
				currentState = nextState;
				
				if((index == tape.length - 1) && currentState == END_STATE) {
					accept = true;
					break;
				}
				
				boolean is_accepted = d_recognize(index + 1, currentState, tape);
					
				if(is_accepted) {
					accept = true;
					break;
				}
			}
			
			if(accept) {
				break;
			}
		}
		
		return accept;
	}
	
}
