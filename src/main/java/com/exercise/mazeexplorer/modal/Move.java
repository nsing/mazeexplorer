package com.exercise.mazeexplorer.modal;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents moves.
 *
 */
public enum Move {
	
	DROP, LEFT, FRWD, RIGHT, QUIT;

	private static final Map<Integer, Move> intToMoveMap = new HashMap<Integer, Move>();
	
	static {
	    for (Move move : Move.values()) {
	        intToMoveMap.put(move.ordinal(), move);
	    }
	}

	public static Move fromInt(int i) {
	    return intToMoveMap.get(i);
	}
	

}
