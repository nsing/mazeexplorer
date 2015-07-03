package com.exercise.mazeexplorer.maze;

import com.exercise.mazeexplorer.modal.Direction;
import com.exercise.mazeexplorer.modal.MazeElement;
import com.exercise.mazeexplorer.modal.Location;

/**
 * MazeImpl interface.
 *
 */
public interface Maze {
	
	/**
	 * Get number of walls.
	 * 
	 * @return number of walls
	 */
	int getWalls();
	
	/**
	 * Get number of empty spaces.
	 * 
	 * @return number of empty spaces
	 */
	int getEmptySpaces();
	
	/**
	 * Get maze element at a given location.
	 * 
	 * @param location location
	 * @return maze element
	 */
	MazeElement getElement(Location location);
	
	/**
	 * Get start location.
	 * 
	 * @return start location
	 */
	Location getStart();
	
	/**
	 * Get exit location.
	 * 
	 * @return exit location
	 */
	Location getExit();
	
	/**
	 * Get next location.
	 * 
	 * @param location location
	 * @param direction direction
	 * @return next location
	 */
	Location getNextLocation(Location location, Direction direction);
	
	/**
	 * Get state string.
	 * 
	 * @return state string
	 */
	String getState();
	
	/**
	 * Get state string displaying explorer with a given display symbol.
	 * 
	 * @param explorerLocation explorer location
	 * @param displaySymbol display symbol for explorer
	 * @return state string
	 */
	String getState(Location explorerLocation, char displaySymbol);

}
