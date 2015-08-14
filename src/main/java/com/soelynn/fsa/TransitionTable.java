package com.soelynn.fsa;

import java.util.ArrayList;
import java.util.HashMap;

import com.soelynn.fsa.internal.TransitionTableKey;

public class TransitionTable<T> {
	
	private HashMap<TransitionTableKey<T>, ArrayList<Integer>> table;
	
	public TransitionTable() {
		table = new HashMap<TransitionTableKey<T>, ArrayList<Integer>>(); 
	}
	
	public void addEntry(T value, int currentState, int nextState) {
		TransitionTableKey<T> key = new TransitionTableKey<T>(currentState, value);
		ArrayList<Integer> nextStates = table.get(key);
		
		if(nextStates == null) {
			nextStates = new ArrayList<Integer>();
		}
		
		nextStates.add(nextState);
		table.put(key, nextStates);
	}
	
	public ArrayList<Integer> getNextState(Integer state, T value) {
		TransitionTableKey<T> key = new TransitionTableKey<T>(state, value);
		return table.get(key);
	}

}