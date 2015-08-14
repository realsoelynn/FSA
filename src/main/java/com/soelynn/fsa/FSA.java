package com.soelynn.fsa;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FSA<T> {

	private static Logger LOGGER = Logger.getLogger(FSA.class.getName());
	
	private static int START_STATE = 0;
	public static int END_STATE = -1;
	
	private TransitionTable<T> transitionTable;
	
	public FSA(TransitionTable<T> transitionTable) throws Throwable {
		this.transitionTable = transitionTable;
		
		if(transitionTable == null) {
			throw new Throwable("Please set the transition table for the finite state automata");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean d_recognize(T... tape) {
		return d_recognize(0, START_STATE, tape);
	}
	
	@SuppressWarnings("unchecked")
	private boolean d_recognize(int startIndex, int currentState, T... tape) {
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
