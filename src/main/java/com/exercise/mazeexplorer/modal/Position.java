package com.exercise.mazeexplorer.modal;

/**
 * Position representation.
 * 
 */
public class Position {
	
	/** Location */
	private Location location;
	
	/** Direction */
	private Direction direction;
	
	/**
	 * Constructor.
	 * 
	 * @param location location
	 * @param direction direction
	 */
	public Position(Location location, Direction direction) {
		this.location = location;
		this.direction = direction;
	}
	
	/**
	 * Return location.
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Return direction.
	 * 
	 * @return direction
	 */
	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "Position [location=" + location + ", direction="
				+ direction + "]";
	}

}
