package com.soelynn.fsa.internal;

import java.util.Objects;

public class TransitionTableKey<T> {

	private Integer state;
	private T value;
	
	public TransitionTableKey(Integer state, T value) {
		this.state = state;
		this.value = value;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public int hashCode() {
		return Objects.hash(state.hashCode(), value.hashCode());
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		TransitionTableKey<T> tableKey = (TransitionTableKey<T>) obj;
		
		return (state != null) && (value != null) && 
				(tableKey.state != null) && (tableKey.value != null) && 
				(tableKey.state.equals(state) && (tableKey.value.equals(value)));
	}
	
	public String toString() {
		return String.format("(State %d, %s)", state, value);
	}
}
