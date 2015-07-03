package com.exercise.mazeexplorer.modal;

/**
 * Location representation.
 *
 */
public class Location {

	/** Y position */
	private int y;

	/** X position */
	private int x;
	
	/** Constructor with Y and X **/
	public Location(int y, int x) {
		this.y = y;
		this.x = x;
	}

	/**
	 * Returns Y position.
	 * 
	 * @return Y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns X position.
	 * 
	 * @return X position
	 */
	public int getX() {
		return x;
	}

	/**
	 * To print location details.
	 * 
	 */
	@Override
	public String toString() {
		return "Location [y=" + y + ", x=" + x + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

}
