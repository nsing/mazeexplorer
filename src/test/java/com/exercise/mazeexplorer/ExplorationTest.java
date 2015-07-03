package com.exercise.mazeexplorer;

import org.junit.Test;

import com.exercise.mazeexplorer.modal.Move;

import junit.framework.TestCase;

/**
 * ExplorationTest.
 * This also includes USER STORY 2 ACCEPTANCE CRITERIA 3.
 */
public class ExplorationTest extends TestCase {
	
	@Test
	public void testExploration() {
		//Stub containing all the moves to explore maze defined in maze1.txt
		Source source = new Source() {
			
			Move[] instructions = {Move.DROP, 
					              Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD,
					              Move.RIGHT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, 
					              Move.RIGHT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, 
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, 
					              Move.RIGHT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, 
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, 
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD,
					              Move.RIGHT, 
					              Move.FRWD, 
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD,
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, 
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD,
					              Move.LEFT, 
					              Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD, Move.FRWD};
			private int count = 0;

			@Override
			public Move getMove() {
				return instructions[count++];
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
		};
		Exploration exploration = ExplorationFactory.getExploration(source);
		assertEquals(true, exploration.init());
		assertEquals(true, exploration.explore());
	}
	
}
