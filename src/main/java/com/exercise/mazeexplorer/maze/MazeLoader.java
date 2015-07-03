package com.exercise.mazeexplorer.maze;

/**
 * Maze loader.
 * 
 */
public interface MazeLoader {

	/**
	 * Initialise.
	 * 
	 * @return flag indicating initialisation success or failure
	 */
	boolean init();
	
	/**
	 * Load and return maze.
	 * 
	 * @return maze
	 */
	Maze load();

}
