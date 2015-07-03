package com.exercise.mazeexplorer.explorer;

import java.util.ArrayList;
import java.util.List;

import com.exercise.mazeexplorer.maze.Maze;
import com.exercise.mazeexplorer.modal.Direction;
import com.exercise.mazeexplorer.modal.Position;
import com.exercise.mazeexplorer.modal.Location;
import com.exercise.mazeexplorer.modal.MazeElement;

/**
 * Explorer implementation.
 * 
 */
public class ExplorerImpl implements Explorer{

	/** MazeImpl */
	private Maze maze;

	/** Current position maze */
	private Position currPosition;

	/** Travel path in the maze */
	private List<Position> travelPath;

	/**
	 * Constructor.
	 * 
	 * @param maze maze to be explored
	 */
	public ExplorerImpl(Maze maze) {
		this.maze = maze;
		this.travelPath = new ArrayList<Position>();
	}

	@Override
	public Position getCurrPosition() {
		return currPosition;
	}

	@Override
	public boolean drop() {
		currPosition = new Position(maze.getStart(), Direction.EAST);
		travelPath.add(currPosition);
		return true;
	}

	@Override
	public boolean turnLeft() {
		if(checkDrop()) {
			return turnLeft(true);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean turnRight() {
		if(checkDrop()) {
			return turnLeft(false);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean moveForward() {
		boolean result = false;
		if(checkDrop()) {
			Location nextLocation = maze.getNextLocation(currPosition.getLocation(),
					currPosition.getDirection());
			if (null != nextLocation) {
				currPosition  = new Position(nextLocation, currPosition.getDirection());
				travelPath.add(currPosition);
				result = true;
			}
		}
		return result;
	}

	@Override
	public String getState() {
		return "Explorer "+currPosition;
	}
	
	@Override
	public String getTravelPath() {
		return travelPath.toString();
	}
	
	@Override
	public List<Position> getAllPossiblePositions() {
		List<Position> positions = new ArrayList<>();
		
		Position position = new Position(new Location(currPosition.getLocation().getY()+1, currPosition.getLocation().getX()), Direction.SOUTH);
		if( MazeElement.SPACE == maze.getElement(position.getLocation())) {
			positions.add(position);
		}
		
		position = new Position(new Location(currPosition.getLocation().getY()-1, currPosition.getLocation().getX()), Direction.NORTH);
		if( MazeElement.SPACE == maze.getElement(position.getLocation())) {
			positions.add(position);
		}
		
		position = new Position(new Location(currPosition.getLocation().getY(), currPosition.getLocation().getX()+1), Direction.EAST);
		if( MazeElement.SPACE == maze.getElement(position.getLocation())) {
			positions.add(position);
		}
		
		position = new Position(new Location(currPosition.getLocation().getY(), currPosition.getLocation().getX()-1), Direction.WEST);
		if( MazeElement.SPACE == maze.getElement(position.getLocation())) {
			positions.add(position);
		}

		return positions;
	}
	

	/**
	 * ExplorerImpl drop check. If currentMazeLoction is null then it means no drop
	 * has occurred and IllegalStateException is thrown.
	 * 
	 * @param flag indicating whether drop can be done or not
	 */
	private boolean checkDrop() {
		if (null == currPosition) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Turns explorer left or right depending on value of isLeft parameter.
	 * 
	 * @param isLeft indicating whether to turn left or right
	 */
	private boolean turnLeft(boolean isLeft) {
		boolean result = true;
		Direction currDirection = currPosition.getDirection();
		switch (currDirection) {
		case EAST:
			currDirection = isLeft ? Direction.NORTH : Direction.SOUTH;
			break;
		case WEST:
			currDirection = isLeft ? Direction.SOUTH : Direction.NORTH;
			break;
		case NORTH:
			currDirection = isLeft ? Direction.WEST : Direction.EAST;
			break;
		case SOUTH:
			currDirection = isLeft ? Direction.EAST : Direction.WEST;
			break;
		default:
			result = false;
			break;
		}
		currPosition = new Position(currPosition.getLocation(), currDirection);
		return result;
	}

}
