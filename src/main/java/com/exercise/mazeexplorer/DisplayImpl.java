package com.exercise.mazeexplorer;

/**
 * Display implementation to write messages on command prompt.
 * 
 */
public class DisplayImpl implements Display {

	@Override
	public void write(String msg) {
		System.out.print(msg);
		
	}

	@Override
	public void writeNewLine(String msg) {
		System.out.println(msg);
		
	}
}
