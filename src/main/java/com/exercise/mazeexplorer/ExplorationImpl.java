package com.exercise.mazeexplorer;

import java.util.ResourceBundle;

import com.exercise.mazeexplorer.explorer.Explorer;
import com.exercise.mazeexplorer.explorer.ExplorerFactory;
import com.exercise.mazeexplorer.maze.Maze;
import com.exercise.mazeexplorer.maze.MazeLoader;
import com.exercise.mazeexplorer.modal.Move;

/**
 * Maze exploration implementation.
 *
 */
public class ExplorationImpl implements Exploration {

	/** Move source */
	private Source input;
	
	/** Output destination */
	private Display output;
	
	/** Maze */
	private Maze maze;
	
	/** Explorer */
	private Explorer explorer;
	
	/** Maze loader */
	private MazeLoader mazeLoader;
	
	/** Messages */
	private ResourceBundle messages;

	/**
	 * Constructor.
	 * 
	 * @param mazeLoader
	 *            maze loader
	 * @param input
	 *            input source
	 * @param output
	 *            output destination
	 */
	public ExplorationImpl(MazeLoader mazeLoader, Source input,
			Display output) {
		this.mazeLoader = mazeLoader;
		this.input = input;
		this.output = output;
		this.messages = ResourceBundle.getBundle("messages");
	}

	@Override
	public boolean init() {
		boolean result = false;
		output.writeNewLine(text("WELCOME"));
		if (mazeLoader.init()) {
			maze = mazeLoader.load();
			if (null != maze) {
				explorer = ExplorerFactory.getExplorer(maze);
				result = true;
			} else {
				output.writeNewLine(text("NO_MAZE"));
			}
		} else {
			output.writeNewLine(text("NO_MAZE_LOADER"));
		}
		return result;
	}

	@Override
	public boolean explore() {
		if (null != maze) {
			while (true) {
				if (!explorerCycle()) {
					break;
				}
			}
			input.close();
			return true;
		} else {
			output.write(text("NO_EXPLORATION"));
			return false;
		}

	}

	/**
	 * Explorer cycle.
	 * 
	 * @return flag indicating whether to continue or not
	 */
	private boolean explorerCycle() {
		displayOptions();
		Move move = input.getMove();
		Result result = null;
		boolean validMove = isValidMove(move);
		if (validMove) {
			result = doAction(move);
		} else {
			result = new Result(text("INVALID"), true);
		}
		output.writeNewLine(result.getMsg());
		if (result.isCarryOn()) {
			if (null != move && validMove) {
				displayState();
			}
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Inner class to represent result.
	 *
	 */
	private class Result {
		String message;
		boolean carryOn;

		Result(String message, boolean carryOn) {
			this.message = message;
			this.carryOn = carryOn;
		}

		String getMsg() {
			return message;
		}

		boolean isCarryOn() {
			return carryOn;
		}

	}

	/**
	 * Do action for the move.
	 * 
	 * @param move move
	 * @return action result
	 */
	private Result doAction(Move move) {
		Result result = null;
		switch (move) {
		case DROP:
			result = explorer.drop() ? new Result(text("DROP"), true)
					: new Result(text("NO_DROP"), true);
			break;
		case RIGHT:
			result = explorer.turnRight() ? new Result(text("RIGHT"), true)
					: new Result(text("NO_RIGHT"), true);
			break;
		case FRWD:
			result = explorer.moveForward() ? getMoveForwardResult()
					: new Result(text("NO_FORWARD"), true);
			break;
		case LEFT:
			result = explorer.turnLeft() ? new Result(text("LEFT"), true)
					: new Result(text("NO_LEFT"), true);
			break;
		case QUIT:
			result = new Result(text("QUIT"), false);
			break;
		default:
			result = new Result(text("INVALID"), true);
		}
		return result;
	}

	/**
	 * Get move forward result.
	 * 
	 * @return move forward result
	 */
	private Result getMoveForwardResult() {
		StringBuilder strb = new StringBuilder();
		if (maze.getExit().equals(explorer.getCurrPosition().getLocation())) {
			strb.append(text("EXIT") + "\n" + text("PATH"));
			strb.append(explorer.getTravelPath());
			strb.append("\n" + text("SUCCESS"));
			return new Result(strb.toString(), false);
		} else {
			return new Result(text("FORWARD"), true);
		}
	}

	/**
	 * Display options.
	 * 
	 */
	private void displayOptions() {
		if (null == explorer.getCurrPosition()) {
			output.write(text("DROP_MENU"));
		} else {
			output.write(text("MENU"));
		}
	}

	/**
	 * Get maze state with explorer representation.
	 * 
	 * @return maze state with explorer representation string
	 */
	private String getMazeStateWithExplorer() {
		return maze.getState(explorer.getCurrPosition().getLocation(), text("EXPLORER_SYMBOL")
				.charAt(0));
	}

	/**
	 * Get explorer state.
	 * 
	 * @return explorer state string
	 */
	private String getExplorerState() {
		return explorer.getState();
	}

	/**
	 * Indicates whether a move is valid or not.
	 * 
	 * @param move move
	 * @return flag indicating whether move is valid or not
	 */
	private boolean isValidMove(Move move) {
		return (null != move && ((null == explorer.getCurrPosition() && move == Move.DROP) || (null != explorer
				.getCurrPosition() && move != Move.DROP)));
	}

	/**
	 * Display exploration state (maze state with explorer, explorer state and possible locaitons).
	 * 
	 */
	private void displayState() {
		output.writeNewLine(getMazeStateWithExplorer() + "\n" + getExplorerState()+"\n"+getPossibleLocations());

	}
	
	/**
	 * Get possible locations.
	 * 
	 * @return possible location string
	 */
	private String getPossibleLocations() {
		return text("POSSIBLE")+explorer.getAllPossiblePositions();
	}

	/**
	 * Return text corresponding to the key from properties file.
	 * 
	 * @param key key
	 * @return text corresponding to the key from properties file
	 */
	private String text(String key) {
		return messages.getString(key);
	}

}
