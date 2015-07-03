package com.exercise.mazeexplorer;

/**
 * Exploration interface.
 *
 */
public interface Exploration {

	/**
	 * Initialise exploration.
	 * 
	 * @return flag indicating initialisation successful or not
	 */
	boolean init();
	
	/**
	 * Start exploration.
	 *
	 * @return flag indicating whether exploration couldn't be started or finished
	 */
	boolean explore();
	
}
