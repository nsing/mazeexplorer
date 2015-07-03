package com.exercise.mazeexplorer.explorer;

import java.util.List;

import com.exercise.mazeexplorer.modal.Position;

/**
 * Explorer interface.
 *
 */
public interface Explorer {
	
	/**
	 * Get current location of explorer in the maze.
	 * 
	 * @return current location of explorer in the maze
	 */
	Position getCurrPosition();
	
	/**
	 * Drop explorer at the starting point in the maze.
	 * (Default direction is EAST.)
 	 *
 	 * @return flag indicating success or failure
 	 */
	boolean drop();
	
	/**
	 * Turn explorer left.
	 * 
	 * @return flag indicating success or failure
	 */
	boolean turnLeft();
	
	/**
	 * Turn explorer right.
	 * 
	 * @return flag indicating success or failure
	 */
	boolean turnRight();
	
	/**
	 * Move explorer forward.
	 * 
	 * @return flag indicating success or failure
	 */
	boolean moveForward();
	
	/**
	 * Returns travelled path (consisting of positions) string.
	 * 
	 * @return travel path
	 */
	String getTravelPath();
	
	/**
	 * Return state string.
	 * 
	 * @return state string
	 */
	String getState();
	
	/**
	 * Return all possible positions from explorer's current position.
	 * 
	 * @return list of possible positions from explorer's current position
	 */
	List<Position> getAllPossiblePositions();

}
