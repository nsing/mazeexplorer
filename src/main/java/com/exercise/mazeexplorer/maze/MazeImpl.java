package com.exercise.mazeexplorer.maze;

import com.exercise.mazeexplorer.modal.Direction;
import com.exercise.mazeexplorer.modal.MazeElement;
import com.exercise.mazeexplorer.modal.Location;

/**
 * MazeImpl representation.
 *
 */
public class MazeImpl implements Maze {

	/** Maze matrix */
	private char[][] mazeMatrix;

	/** Start position */
	private Location start;

	/** Exit position */
	private Location exit;
	
	/** Number of walls */
	private int walls;
	
	/** Number of empty spaces */
	private int emptySpaces;
	
	/**
	 * Constructor.
	 * 
	 * @param mazeMatrix maze matrix
	 * @param walls walls
	 * @param emptySpaces empty spaces
	 * @param start start
	 * @param exit exit
	 */
	public MazeImpl(char[][] mazeMatrix, int walls, int emptySpaces, Location start, Location exit) {
		this.mazeMatrix = mazeMatrix;
		this.walls = walls;
		this.emptySpaces = emptySpaces;
		this.start = start;
		this.exit = exit;
	}
	
	/**
	 * Get walls.
	 * 
	 * @return walls
	 */
	public int getWalls() {
		return walls;
	}

	/**
	 * Get empty spaces.
	 * 
	 * @return empty spaces
	 */
	public int getEmptySpaces() {
		return emptySpaces;
	}

	/**
	 * Get element at a given location.
	 * 
	 * @return element
	 */
	public MazeElement getElement(Location location) {
		return getElement(location.getY(), location.getX());
	}

	/**
	 * Get start.
	 * 
	 * @return start location
	 */
	public Location getStart() {
		return start;
	}

	/**
	 * Get exit.
	 * 
	 * @return exit location
	 */
	public Location getExit() {
		return exit;
	}

	/**
	 * Get next location from a given location in a given direction.
	 * 
	 * @param fromLocation from location
	 * @param direction direction
	 */
	public Location getNextLocation(Location fromLocation, Direction direction) {
		Location newLocation = null;
		int nextX, nextY;
		switch (direction) {
		case EAST:
			nextY = fromLocation.getY();
			nextX = fromLocation.getX() + 1;
			if (!isWall(nextY, nextX)) {
				newLocation = new Location(nextY, nextX);
			}
			break;
		case WEST:
			nextY = fromLocation.getY();
			nextX = fromLocation.getX() - 1;
			if (!isWall(nextY, nextX)) {
				newLocation = new Location(nextY, nextX);
			}
			break;
		case NORTH:
			nextY = fromLocation.getY() - 1;
			nextX = fromLocation.getX();
			if (!isWall(nextY, nextX)) {
				newLocation = new Location(nextY, nextX);
			}
			break;
		case SOUTH:
			nextY = fromLocation.getY() + 1;
			nextX = fromLocation.getX();
			if (!isWall(nextY, nextX)) {
				newLocation = new Location(nextY, nextX);
			}
			break;
		default:
			break;
		}
		return newLocation;
	}
	
	/**
	 * Get maze state.
	 * 
	 * @return state string
	 */
	public String getState() {
		StringBuilder strb = new StringBuilder("[Maze: ");
		for(int i=0; i < mazeMatrix.length; i++) {
			strb.append("\n");
			for(int j=0; j < mazeMatrix[0].length; j++) {
				strb.append(mazeMatrix[i][j]);
			}
		}
		strb.append("\nStart: "+start+", "+"Exit: "+exit+"]");
		return strb.toString();
	}
	
	/**
	 * Get maze state with explorer representation.
	 * 
	 * @param location explorer location
	 * @param explorer symbol
	 * @return state string
	 */
	public String getState(Location location, char explorerSymbol) {
		StringBuilder strb = new StringBuilder("[Maze: ");
		for(int i=0; i < mazeMatrix.length; i++) {
			strb.append("\n");
			for(int j=0; j < mazeMatrix[0].length; j++) {
				if(location.getY() == i && location.getX() == j) {
					strb.append(explorerSymbol);
				}
				else {
					strb.append(mazeMatrix[i][j]);
				}
			}
		}
		strb.append("\nStart: "+start+", "+"Exit: "+exit+"]");
		return strb.toString();
	}
	
	/**
	 * Get element.
	 * 
	 * @param y y
	 * @param x x
	 * @return maze element
	 */
	public MazeElement getElement(int y, int x) {
		return 'X' == mazeMatrix[y][x]? MazeElement.WALL : MazeElement.SPACE;

	}
	
	/**
	 * Returns whether given y and x location is a wall or not.
	 * 
	 * @param y y
	 * @param x x
	 * @return flag indicating whether given position is a wall or not
	 */
	private boolean isWall(int y, int x) {
		return MazeElement.WALL == getElement(y, x);
	}

}
