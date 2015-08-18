package com.soelynn.fsa.internal;

import java.util.ArrayList;
import java.util.HashMap;

public class TransitionTable {
	
	private HashMap<TransitionTableKey<String>, ArrayList<Integer>> table;
	
	public TransitionTable() {
		table = new HashMap<TransitionTableKey<String>, ArrayList<Integer>>(); 
	}
	
	public void addEntry(String value, int originState, int nextState) {
		TransitionTableKey<String> key = new TransitionTableKey<String>(originState, value);
		ArrayList<Integer> nextStates = table.get(key);
		
		if(nextStates == null) {
			nextStates = new ArrayList<Integer>();
		}
		
		nextStates.add(nextState);
		table.put(key, nextStates);
	}
	
	public ArrayList<Integer> getNextState(Integer state, String value) {
		TransitionTableKey<String> key = new TransitionTableKey<String>(state, value);
		return table.get(key);
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}

}