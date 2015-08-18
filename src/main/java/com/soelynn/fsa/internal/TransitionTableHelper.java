package com.soelynn.fsa.internal;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class TransitionTableHelper {

	private static final int ORIGIN_STATE_INDEX = 0;
	private static final int NEXT_STATE_INDEX = 1;
	private static final int VALUE_INDEX = 2;
	
	public static TransitionTable loadFromCSV(String csvFileURL) throws IOException {
		TransitionTable transitionTable = new TransitionTable();
		CSVReader reader = new CSVReader(new FileReader(csvFileURL));
		String [] record;
		
		while ((record = reader.readNext()) != null) {
			int originState = Integer.parseInt(record[ORIGIN_STATE_INDEX]);
			int nextState =  Integer.parseInt(record[NEXT_STATE_INDEX]);
			String value = record[VALUE_INDEX];
			
			transitionTable.addEntry(value, originState, nextState);
		}
		
		reader.close();
		
		return transitionTable;
	}
	
}
