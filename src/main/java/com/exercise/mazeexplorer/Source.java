package com.exercise.mazeexplorer;

import com.exercise.mazeexplorer.modal.Move;

/**
 * Source to get move.
 * 
 */
public interface Source {

	/**
	 * Get move.
	 * 
	 * @return move
	 */
	Move getMove();
	
	/**
	 * Close move source.
	 * 
	 */
	void close();

}
