package com.exercise.mazeexplorer;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.exercise.mazeexplorer.modal.Move;

/**
 * Source implementation to get move from command prompt.
 * 
 */
public class SourceImpl implements Source {
	
	/** Scanner */
	Scanner scanner;
	
	/**
	 * Constructor.
	 * 
	 */
	public SourceImpl() {
		scanner = new Scanner(System.in);
	}

	/**
	 * Get move
	 * 
	 * @return move
	 */
	public Move getMove() {
		Move move = null;
		try {
			move = Move.fromInt(scanner.nextInt());
		} catch (InputMismatchException ime) {
			//Do nothing because null input will indicate that input is not correct.
		}
		return move;
	}
	
	/**
	 * Close source.
	 * 
	 */
	public void close() {
		scanner.close();
	}

}
