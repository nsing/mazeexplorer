package com.exercise.mazeexplorer.maze;

import org.junit.Test;

import com.exercise.mazeexplorer.modal.Direction;
import com.exercise.mazeexplorer.modal.Location;
import com.exercise.mazeexplorer.modal.MazeElement;

import junit.framework.TestCase;

/**
 * Tests for Maze.
 * Tests also include USER STORY 1 ACCEPTANCE CRITERIA 1 TO 3.
 *
 */
public class MazeTest extends TestCase {

	private String mazeState = "[Maze: \n" + "XXXXXXXXXXXXXXX\n"
			+ "X             X\n" + "X XXXXXXXXXXX X\n" + "X XS        X X\n"
			+ "X XXXXXXXXX X X\n" + "X XXXXXXXXX X X\n" + "X XXXX      X X\n"
			+ "X XXXX XXXX X X\n" + "X XXXX XXXX X X\n" + "X X    XXXXXX X\n"
			+ "X X XXXXXXXXX X\n" + "X X XXXXXXXXX X\n" + "X X         X X\n"
			+ "X XXXXXXXXX   X\n" + "XFXXXXXXXXXXXXX\n"
			+ "Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]";
	
	private String mazeStateDec = "[Maze: \n" + "XXXXXXXXXXXXXXX\n"
			+ "X             X\n" + "X XXXXXXXXXXX X\n" + "X XS#       X X\n"
			+ "X XXXXXXXXX X X\n" + "X XXXXXXXXX X X\n" + "X XXXX      X X\n"
			+ "X XXXX XXXX X X\n" + "X XXXX XXXX X X\n" + "X X    XXXXXX X\n"
			+ "X X XXXXXXXXX X\n" + "X X XXXXXXXXX X\n" + "X X         X X\n"
			+ "X XXXXXXXXX   X\n" + "XFXXXXXXXXXXXXX\n"
			+ "Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]";

	@Test
	public void testMazeLoader() {
		MazeLoader loader = new MazeLoaderImpl();
		loader.init();
		Maze maze = loader.load();
		assertNotNull(maze);
		
		/*
		 * USER STORY 1 ACCEPTANCE CRITERIA 1
		 * A Maze (as defined in Maze1.txt consists of walls 'X', Empty spaces ' ', one and only one Start point 'S' and one and only one exit 'F'
		 */
		assertEquals(new Location(3, 3), maze.getStart());
		assertEquals(new Location(14, 1), maze.getExit());
		assertEquals(mazeState, maze.getState());
		
		/*
		 * USER STORY 1 ACCEPTANCE CRITERIA 2 
		 * After a maze has been created the number of walls and empty spaces should be available to me
		 */
		assertEquals(74, maze.getEmptySpaces());
		assertEquals(151, maze.getWalls());

		/* 
		 * USER STORY 1 ACCEPTANCE CRITERIA 3
		 * After a maze has been created I should be able to put in a co-ordinate and know what exists at that point 
		 */
		assertEquals(MazeElement.WALL, maze.getElement(new Location(0, 0)));

		assertEquals(mazeStateDec, maze.getState(new Location(3, 4), '#'));
		assertEquals(new Location(3, 4),
				maze.getNextLocation(new Location(3, 3), Direction.EAST));
		assertEquals(new Location(3, 3),
				maze.getNextLocation(new Location(3, 4), Direction.WEST));
		assertEquals(new Location(3, 11),
				maze.getNextLocation(new Location(4, 11), Direction.NORTH));
		assertEquals(new Location(5, 11),
				maze.getNextLocation(new Location(4, 11), Direction.SOUTH));
	}

}
