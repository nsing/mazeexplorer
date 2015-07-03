package com.exercise.mazeexplorer.explorer;

import com.exercise.mazeexplorer.maze.Maze;

/**
 * Explorer factory.
 * 
 */
public class ExplorerFactory {
	
	/**
	 * Return explorer.
	 * 
	 * @param maze maze
	 * @return explorer
	 */
	public static Explorer getExplorer(Maze maze) {
		return new ExplorerImpl(maze);
	}

}
