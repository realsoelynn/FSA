package com.soelynn.fsa;

import java.util.Arrays;

public class App {

	public static void main(String[] args) throws Throwable {
		String transition_table_url = args[0];
		String[] string_to_check = Arrays.copyOfRange(args, 1, args.length);

		FSA fsa = new FSA(transition_table_url);
		System.out.println(fsa.d_recognize(string_to_check));
	}

}
