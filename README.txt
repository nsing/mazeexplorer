I. Assumptions:
	1. Exploration consists of moving explorer in a maze.
	2. Exploration depends on explorer and maze.
	3. Explorer depends on maze.
	4. Explorer position consists of its location (x,y) and direction (i.e. north/south/east/west) in the maze.
	5. The direction of explorer after drop operation is EAST.
	
II. In terms of responsibilities the solution can be divided into following parts:
	A. EXPLORATION: This represents overall all maze exploration responsibilities (application control).
	B. MAZE: This represents maze specific responsibilities.
	C. EXPLORER: This represents explorer specific responsibilities.

III. Based on above following is the package structure (mazeexplorer/src/main/java):
	A. com.exercise.mazeexplorer: Maze exploration interfaces / classes:
		1. Exploration.java: Maze exploration interface.
		2. ExplorationImpl.java: Maze exploration implementation class.
		3. ExplorationFactory.java: Maze exploration factory to get maze exploration implementation instance. 
		4. Source.java: Interface for getting maze exploration moves (instructions).
		5. SourceImpl.java: Implementation of Source interface. 
		6. Display.java: Interface to display maze exploration output.
		7. DisplayImpl.java: Implementation of Display interface.
	
	B. com.exercise.mazeexplorer.explorer: Explorer interface / classes:
		1. Explorer.java: Explorer interface.
		2. ExplorerImpl.java: Explorer implementation class.
		3. ExplorerFactory.java: Explorer factory.
		
	C. com.exercise.mazeexplorer.maze: Maze interface / classes:
		1. Maze.java: Maze interface.
		2. MazeImpl.java: Maze implementation class.
		3. MazeLoader.java: Maze loader interface.
		4. MazeLoaderImpl.java: Maze loader implementation class.
	
	D. com.exercise.mazeexplorer.modal: Various enum and class for application:
		Direction.java: Enum representing direction of explorer in a maze (i.e. north, south, east and west).
		Location.java: Class representing location in a maze (i.e. in form of x and y values).
		Position.java: Class representing explorer position in maze (consists of Location as well as Direction).
		MazeElement.java: Enum representing maze element (i.e. empty space and wall)
		Move.java: Enum representing move in the exploration (i.e. drop, turn right, turn left, move forward and quit). 

IV. Solution is configurable with the help of following resources (/mazeexplorer/src/main/resources):
	A. loader.config: This is used by maze loader to know maze data file name (at present it is maze1.txt). 
	B. maze1.txt: This is maze data file used to construct Maze object by maze loader.
	C. messages.properties: This contains all the messages that are dislayed.
	
V. Solution has following JUnit tests (in folder /mazeexplorer/src/test/java).
   Tests cover 85.6% of the code (CodeCoverageReport.jpg) and also the expected acceptance criteria (code covering acceptance criteria has comments for clarity ):
	A. ExplorationTest.java (com.exercise.mazeexplorer): To test exploration. 
	B. ExplorerTest.java (com.exercise.mazeexplorer.explorer): To test explorer.
	C. MazeTest.java (com.exercise.mazeexplorer.maze): To test maze.

VI. Besides running on IDE application be executed in command prompt as follows:
	java -cp mazeexplorer-0.0.1-SNAPSHOT.jar com.exercise.mazeexplorer.ExplorationFactory 
	(mazeexplorer-0.0.1-SNAPSHOT.jar is there in target folder)
	(Application is developed using jdk1.8.0_45)
	
VII. Full application execution trace from the command prompt (also displays all the visited positions on completion):
Welcome to maze explorer.
Press 0 and enter key to drop the explorer :0
Explorer dropped.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X X#        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=3], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=4], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS#       X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=4], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=5], direction=EAST], Position [location=Location [y=3, x=3], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS #      X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=5], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=6], direction=EAST], Position [location=Location [y=3, x=4], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS  #     X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=6], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=7], direction=EAST], Position [location=Location [y=3, x=5], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS   #    X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=7], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=8], direction=EAST], Position [location=Location [y=3, x=6], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS    #   X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=8], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=9], direction=EAST], Position [location=Location [y=3, x=7], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS     #  X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=9], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=10], direction=EAST], Position [location=Location [y=3, x=8], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS      # X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=10], direction=EAST]
Next possible positions: [Position [location=Location [y=3, x=11], direction=EAST], Position [location=Location [y=3, x=9], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS       #X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=11], direction=EAST]
Next possible positions: [Position [location=Location [y=4, x=11], direction=SOUTH], Position [location=Location [y=3, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):3
Explorer turned right.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS       #X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=11], direction=SOUTH]
Next possible positions: [Position [location=Location [y=4, x=11], direction=SOUTH], Position [location=Location [y=3, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX#X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=4, x=11], direction=SOUTH]
Next possible positions: [Position [location=Location [y=5, x=11], direction=SOUTH], Position [location=Location [y=3, x=11], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX#X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=5, x=11], direction=SOUTH]
Next possible positions: [Position [location=Location [y=6, x=11], direction=SOUTH], Position [location=Location [y=4, x=11], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX     #X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=11], direction=SOUTH]
Next possible positions: [Position [location=Location [y=7, x=11], direction=SOUTH], Position [location=Location [y=5, x=11], direction=NORTH], Position [location=Location [y=6, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):3
Explorer turned right.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX     #X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=11], direction=WEST]
Next possible positions: [Position [location=Location [y=7, x=11], direction=SOUTH], Position [location=Location [y=5, x=11], direction=NORTH], Position [location=Location [y=6, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX    # X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=10], direction=WEST]
Next possible positions: [Position [location=Location [y=6, x=11], direction=EAST], Position [location=Location [y=6, x=9], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX   #  X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=9], direction=WEST]
Next possible positions: [Position [location=Location [y=6, x=10], direction=EAST], Position [location=Location [y=6, x=8], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX  #   X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=8], direction=WEST]
Next possible positions: [Position [location=Location [y=6, x=9], direction=EAST], Position [location=Location [y=6, x=7], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX #    X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=7], direction=WEST]
Next possible positions: [Position [location=Location [y=6, x=8], direction=EAST], Position [location=Location [y=6, x=6], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX#     X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=6], direction=WEST]
Next possible positions: [Position [location=Location [y=7, x=6], direction=SOUTH], Position [location=Location [y=6, x=7], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX#     X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=6], direction=SOUTH]
Next possible positions: [Position [location=Location [y=7, x=6], direction=SOUTH], Position [location=Location [y=6, x=7], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX#XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=7, x=6], direction=SOUTH]
Next possible positions: [Position [location=Location [y=8, x=6], direction=SOUTH], Position [location=Location [y=6, x=6], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX#XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=8, x=6], direction=SOUTH]
Next possible positions: [Position [location=Location [y=9, x=6], direction=SOUTH], Position [location=Location [y=7, x=6], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X   #XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=6], direction=SOUTH]
Next possible positions: [Position [location=Location [y=8, x=6], direction=NORTH], Position [location=Location [y=9, x=5], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):3
Explorer turned right.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X   #XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=6], direction=WEST]
Next possible positions: [Position [location=Location [y=8, x=6], direction=NORTH], Position [location=Location [y=9, x=5], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X  # XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=5], direction=WEST]
Next possible positions: [Position [location=Location [y=9, x=6], direction=EAST], Position [location=Location [y=9, x=4], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X #  XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=4], direction=WEST]
Next possible positions: [Position [location=Location [y=9, x=5], direction=EAST], Position [location=Location [y=9, x=3], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X#   XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=3], direction=WEST]
Next possible positions: [Position [location=Location [y=10, x=3], direction=SOUTH], Position [location=Location [y=9, x=4], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X#   XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=3], direction=SOUTH]
Next possible positions: [Position [location=Location [y=10, x=3], direction=SOUTH], Position [location=Location [y=9, x=4], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X#XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=10, x=3], direction=SOUTH]
Next possible positions: [Position [location=Location [y=11, x=3], direction=SOUTH], Position [location=Location [y=9, x=3], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X#XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=11, x=3], direction=SOUTH]
Next possible positions: [Position [location=Location [y=12, x=3], direction=SOUTH], Position [location=Location [y=10, x=3], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X#        X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=3], direction=SOUTH]
Next possible positions: [Position [location=Location [y=11, x=3], direction=NORTH], Position [location=Location [y=12, x=4], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X#        X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=3], direction=EAST]
Next possible positions: [Position [location=Location [y=11, x=3], direction=NORTH], Position [location=Location [y=12, x=4], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X #       X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=4], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=5], direction=EAST], Position [location=Location [y=12, x=3], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X  #      X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=5], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=6], direction=EAST], Position [location=Location [y=12, x=4], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X   #     X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=6], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=7], direction=EAST], Position [location=Location [y=12, x=5], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X    #    X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=7], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=8], direction=EAST], Position [location=Location [y=12, x=6], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X     #   X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=8], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=9], direction=EAST], Position [location=Location [y=12, x=7], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X      #  X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=9], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=10], direction=EAST], Position [location=Location [y=12, x=8], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X       # X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=10], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=11], direction=EAST], Position [location=Location [y=12, x=9], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X        #X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=11], direction=EAST]
Next possible positions: [Position [location=Location [y=13, x=11], direction=SOUTH], Position [location=Location [y=12, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):3
Explorer turned right.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X        #X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=11], direction=SOUTH]
Next possible positions: [Position [location=Location [y=13, x=11], direction=SOUTH], Position [location=Location [y=12, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX#  X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=13, x=11], direction=SOUTH]
Next possible positions: [Position [location=Location [y=12, x=11], direction=NORTH], Position [location=Location [y=13, x=12], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX#  X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=13, x=11], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=11], direction=NORTH], Position [location=Location [y=13, x=12], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX # X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=13, x=12], direction=EAST]
Next possible positions: [Position [location=Location [y=13, x=13], direction=EAST], Position [location=Location [y=13, x=11], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX  #X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=13, x=13], direction=EAST]
Next possible positions: [Position [location=Location [y=12, x=13], direction=NORTH], Position [location=Location [y=13, x=12], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX  #X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=13, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=12, x=13], direction=NORTH], Position [location=Location [y=13, x=12], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X#X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=13, x=13], direction=SOUTH], Position [location=Location [y=11, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX#X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=11, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=12, x=13], direction=SOUTH], Position [location=Location [y=10, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX#X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=10, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=11, x=13], direction=SOUTH], Position [location=Location [y=9, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX#X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=10, x=13], direction=SOUTH], Position [location=Location [y=8, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X#X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=8, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=9, x=13], direction=SOUTH], Position [location=Location [y=7, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X#X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=7, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=8, x=13], direction=SOUTH], Position [location=Location [y=6, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X#X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=7, x=13], direction=SOUTH], Position [location=Location [y=5, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X#X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=5, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=6, x=13], direction=SOUTH], Position [location=Location [y=4, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X#X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=4, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=5, x=13], direction=SOUTH], Position [location=Location [y=3, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X#X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=4, x=13], direction=SOUTH], Position [location=Location [y=2, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX#X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=2, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=3, x=13], direction=SOUTH], Position [location=Location [y=1, x=13], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X            #X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=13], direction=NORTH]
Next possible positions: [Position [location=Location [y=2, x=13], direction=SOUTH], Position [location=Location [y=1, x=12], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X            #X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=13], direction=WEST]
Next possible positions: [Position [location=Location [y=2, x=13], direction=SOUTH], Position [location=Location [y=1, x=12], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X           # X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=12], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=13], direction=EAST], Position [location=Location [y=1, x=11], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X          #  X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=11], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=12], direction=EAST], Position [location=Location [y=1, x=10], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X         #   X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=10], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=11], direction=EAST], Position [location=Location [y=1, x=9], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X        #    X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=9], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=10], direction=EAST], Position [location=Location [y=1, x=8], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X       #     X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=8], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=9], direction=EAST], Position [location=Location [y=1, x=7], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X      #      X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=7], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=8], direction=EAST], Position [location=Location [y=1, x=6], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X     #       X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=6], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=7], direction=EAST], Position [location=Location [y=1, x=5], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X    #        X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=5], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=6], direction=EAST], Position [location=Location [y=1, x=4], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X   #         X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=4], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=5], direction=EAST], Position [location=Location [y=1, x=3], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X  #          X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=3], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=4], direction=EAST], Position [location=Location [y=1, x=2], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X #           X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=2], direction=WEST]
Next possible positions: [Position [location=Location [y=1, x=3], direction=EAST], Position [location=Location [y=1, x=1], direction=WEST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X#            X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=1], direction=WEST]
Next possible positions: [Position [location=Location [y=2, x=1], direction=SOUTH], Position [location=Location [y=1, x=2], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):1
Explorer turned left.
[Maze: 
XXXXXXXXXXXXXXX
X#            X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=1, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=2, x=1], direction=SOUTH], Position [location=Location [y=1, x=2], direction=EAST]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X#XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=2, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=3, x=1], direction=SOUTH], Position [location=Location [y=1, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X#XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=3, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=4, x=1], direction=SOUTH], Position [location=Location [y=2, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X#XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=4, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=5, x=1], direction=SOUTH], Position [location=Location [y=3, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X#XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=5, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=6, x=1], direction=SOUTH], Position [location=Location [y=4, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X#XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=6, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=7, x=1], direction=SOUTH], Position [location=Location [y=5, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X#XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=7, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=8, x=1], direction=SOUTH], Position [location=Location [y=6, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X#XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=8, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=9, x=1], direction=SOUTH], Position [location=Location [y=7, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X#X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=9, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=10, x=1], direction=SOUTH], Position [location=Location [y=8, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X#X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=10, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=11, x=1], direction=SOUTH], Position [location=Location [y=9, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X#X XXXXXXXXX X
X X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=11, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=12, x=1], direction=SOUTH], Position [location=Location [y=10, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X#X         X X
X XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=12, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=13, x=1], direction=SOUTH], Position [location=Location [y=11, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Explorer moved forward.
[Maze: 
XXXXXXXXXXXXXXX
X             X
X XXXXXXXXXXX X
X XS        X X
X XXXXXXXXX X X
X XXXXXXXXX X X
X XXXX      X X
X XXXX XXXX X X
X XXXX XXXX X X
X X    XXXXXX X
X X XXXXXXXXX X
X X XXXXXXXXX X
X X         X X
X#XXXXXXXXX   X
XFXXXXXXXXXXXXX
Start: Location [y=3, x=3], Exit: Location [y=14, x=1]]
Explorer Position [location=Location [y=13, x=1], direction=SOUTH]
Next possible positions: [Position [location=Location [y=14, x=1], direction=SOUTH], Position [location=Location [y=12, x=1], direction=NORTH]]
Enter option and press enter key (turn left=>1, turn right=>3, move forward=>2, quit=>4):2
Reached the exit of maze.
Travel path:[Position [location=Location [y=3, x=3], direction=EAST], Position [location=Location [y=3, x=4], direction=EAST], Position [location=Location [y=3, x=5], direction=EAST], Position [location=Location [y=3, x=6], direction=EAST], Position [location=Location [y=3, x=7], direction=EAST], Position [location=Location [y=3, x=8], direction=EAST], Position [location=Location [y=3, x=9], direction=EAST], Position [location=Location [y=3, x=10], direction=EAST], Position [location=Location [y=3, x=11], direction=EAST], Position [location=Location [y=4, x=11], direction=SOUTH], Position [location=Location [y=5, x=11], direction=SOUTH], Position [location=Location [y=6, x=11], direction=SOUTH], Position [location=Location [y=6, x=10], direction=WEST], Position [location=Location [y=6, x=9], direction=WEST], Position [location=Location [y=6, x=8], direction=WEST], Position [location=Location [y=6, x=7], direction=WEST], Position [location=Location [y=6, x=6], direction=WEST], Position [location=Location [y=7, x=6], direction=SOUTH], Position [location=Location [y=8, x=6], direction=SOUTH], Position [location=Location [y=9, x=6], direction=SOUTH], Position [location=Location [y=9, x=5], direction=WEST], Position [location=Location [y=9, x=4], direction=WEST], Position [location=Location [y=9, x=3], direction=WEST], Position [location=Location [y=10, x=3], direction=SOUTH], Position [location=Location [y=11, x=3], direction=SOUTH], Position [location=Location [y=12, x=3], direction=SOUTH], Position [location=Location [y=12, x=4], direction=EAST], Position [location=Location [y=12, x=5], direction=EAST], Position [location=Location [y=12, x=6], direction=EAST], Position [location=Location [y=12, x=7], direction=EAST], Position [location=Location [y=12, x=8], direction=EAST], Position [location=Location [y=12, x=9], direction=EAST], Position [location=Location [y=12, x=10], direction=EAST], Position [location=Location [y=12, x=11], direction=EAST], Position [location=Location [y=13, x=11], direction=SOUTH], Position [location=Location [y=13, x=12], direction=EAST], Position [location=Location [y=13, x=13], direction=EAST], Position [location=Location [y=12, x=13], direction=NORTH], Position [location=Location [y=11, x=13], direction=NORTH], Position [location=Location [y=10, x=13], direction=NORTH], Position [location=Location [y=9, x=13], direction=NORTH], Position [location=Location [y=8, x=13], direction=NORTH], Position [location=Location [y=7, x=13], direction=NORTH], Position [location=Location [y=6, x=13], direction=NORTH], Position [location=Location [y=5, x=13], direction=NORTH], Position [location=Location [y=4, x=13], direction=NORTH], Position [location=Location [y=3, x=13], direction=NORTH], Position [location=Location [y=2, x=13], direction=NORTH], Position [location=Location [y=1, x=13], direction=NORTH], Position [location=Location [y=1, x=12], direction=WEST], Position [location=Location [y=1, x=11], direction=WEST], Position [location=Location [y=1, x=10], direction=WEST], Position [location=Location [y=1, x=9], direction=WEST], Position [location=Location [y=1, x=8], direction=WEST], Position [location=Location [y=1, x=7], direction=WEST], Position [location=Location [y=1, x=6], direction=WEST], Position [location=Location [y=1, x=5], direction=WEST], Position [location=Location [y=1, x=4], direction=WEST], Position [location=Location [y=1, x=3], direction=WEST], Position [location=Location [y=1, x=2], direction=WEST], Position [location=Location [y=1, x=1], direction=WEST], Position [location=Location [y=2, x=1], direction=SOUTH], Position [location=Location [y=3, x=1], direction=SOUTH], Position [location=Location [y=4, x=1], direction=SOUTH], Position [location=Location [y=5, x=1], direction=SOUTH], Position [location=Location [y=6, x=1], direction=SOUTH], Position [location=Location [y=7, x=1], direction=SOUTH], Position [location=Location [y=8, x=1], direction=SOUTH], Position [location=Location [y=9, x=1], direction=SOUTH], Position [location=Location [y=10, x=1], direction=SOUTH], Position [location=Location [y=11, x=1], direction=SOUTH], Position [location=Location [y=12, x=1], direction=SOUTH], Position [location=Location [y=13, x=1], direction=SOUTH], Position [location=Location [y=14, x=1], direction=SOUTH]]
Exploration successful.
