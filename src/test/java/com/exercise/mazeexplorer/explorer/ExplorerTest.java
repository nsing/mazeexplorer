package com.exercise.mazeexplorer.explorer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.exercise.mazeexplorer.maze.Maze;
import com.exercise.mazeexplorer.maze.MazeLoader;
import com.exercise.mazeexplorer.maze.MazeLoaderImpl;
import com.exercise.mazeexplorer.modal.Direction;
import com.exercise.mazeexplorer.modal.Position;
import com.exercise.mazeexplorer.modal.Location;

import junit.framework.TestCase;

/**
 * Tests for Explorer.
 * This also includes USER STORY 2 ACCEPTANCE CRITERIA 1 TO 3.
 *
 */
public class ExplorerTest extends TestCase {
	
	@Test
	public void testExplorer() {
		MazeLoader loader = new MazeLoaderImpl();
		loader.init();
		Maze maze = loader.load();
		Explorer explorer = ExplorerFactory.getExplorer(maze);
		
		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 1
		 * Given a maze the explorer should be able to drop in to the Start point
		 * 
		 */
		explorer.drop();
		assertEquals(maze.getStart(), explorer.getCurrPosition().getLocation());

		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 2
		 * An explorer on a maze must be able to Understand all movement options from their given location
		 */
		List<Position> positions = new ArrayList<Position>();
		positions.add(new Position(new Location(3, 4), Direction.EAST));
		assertEquals(positions.toString(), explorer.getAllPossiblePositions().toString());
		
		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 2
		 * An explorer on a maze must be able to Move forward.
		 */
		assertEquals(true, explorer.moveForward());
		assertEquals(new Location(3, 4), explorer.getCurrPosition().getLocation());
		
		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 2
		 * An explorer on a maze must be able to Turn left
		 */
		explorer.turnLeft();
		assertEquals(Direction.NORTH, explorer.getCurrPosition().getDirection());
		
		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 2
		 * An explorer on a maze must be able to Understand what is in front of them
		 */
		assertEquals(false, explorer.moveForward());

		explorer.turnLeft();
		explorer.turnRight();
		
		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 2
		 * An explorer on a maze must be able to Turn right
		 */
		explorer.turnRight();
		assertEquals(Direction.EAST, explorer.getCurrPosition().getDirection());
		
		explorer.moveForward();
		assertEquals(new Location(3, 5), explorer.getCurrPosition().getLocation());
		assertEquals("Explorer Position [location=Location [y=3, x=5], direction=EAST]", explorer.getState());
		
		/*
		 * USER STORY 2 ACCEPTANCE CRITERIA 2
		 * An explorer on a maze must be able to Have a record of where they have been
		 * And
		 * ACCEPTANCE CRITERIA 3
		 * Once an explorer has exited a maze they must be able to state the route they took in an understandable fashion
		 */
		assertEquals("[Position [location=Location [y=3, x=3], direction=EAST], Position [location=Location [y=3, x=4], direction=EAST], Position [location=Location [y=3, x=5], direction=EAST]]", explorer.getTravelPath());
		
	}


}
