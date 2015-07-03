package com.exercise.mazeexplorer.maze;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.exercise.mazeexplorer.modal.Location;

/**
 * Maze loader implementation.
 *
 */
public class MazeLoaderImpl implements MazeLoader {

	/** Configuration (for maze file) */
	private Properties config;

	@Override
	public boolean init() {
		try {
			Properties config = new Properties();
			config.load(getClass().getClassLoader().getResourceAsStream(
					"loader.config"));
			this.config = config;
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Maze load() {
		Maze maze = null;

		if (null != config) {
			String mazeFile = config.getProperty("FILE");
			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream(mazeFile);
			if(null != inputStream) {
				List<String> rows = new ArrayList<>();
				Scanner sc = new Scanner(inputStream);
				while (sc.hasNextLine()) {
					String row = sc.nextLine();
					rows.add(row);
				}
				sc.close();
				char[][] mazeMatrix = new char[rows.size()][rows.get(0).length()];
				Location start = null;
				Location exit = null;
				int walls = 0;
				int emptySpaces = 0;
				for (int i = 0; i < rows.size(); i++) {
					for (int j = 0; j < rows.get(i).length(); j++) {
						mazeMatrix[i][j] = rows.get(i).charAt(j);
	
						if (mazeMatrix[i][j] == ' ') {
							emptySpaces++;
						} else {
							walls++;
							if (mazeMatrix[i][j] == 'S') {
								start = new Location(i, j);
							}
							if (mazeMatrix[i][j] == 'F') {
								exit = new Location(i, j);
							}
						}
					}
				}
				maze = new MazeImpl(mazeMatrix, walls, emptySpaces, start, exit);
			}
		}
		return maze;
	}

}
