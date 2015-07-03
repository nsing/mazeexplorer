package com.exercise.mazeexplorer;

import com.exercise.mazeexplorer.maze.MazeLoaderImpl;

/**
 * Exploration factory.
 * 
 */
public class ExplorationFactory {

	/**
	 * Return exploration.
	 * 
	 * @return exploration
	 */
	public static Exploration getExploration() {
		return new ExplorationImpl(new MazeLoaderImpl(), new SourceImpl(),
				new DisplayImpl());
	}
	
	/**
	 * Return exploration for a move source.
	 * 
	 * @param source move source
	 * @return exploration
	 */
	public static Exploration getExploration(Source source) {
		return new ExplorationImpl(new MazeLoaderImpl(), source,
				new DisplayImpl());
	}

	/**
	 * Main method.
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Exploration exploration = getExploration();
		if (exploration.init()) {
			exploration.explore();
		}
	}

}
