package group.project.coen6761;

//import static org.junit.Assert.assertTrue;
import static group.project.coen6761.App.move;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import group.project.coen6761.Robot.Direction;
/*
 * Unit test for simple App.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

	private Room room;
	private Robot robot;

	private App app;


	private static final String LINE_SEPARATOR = System.getProperty("line.separator");




	@BeforeEach
	public void setUp() {
		// Create new instances before each test
		room = new Room(5); // Set the room size as needed
		robot = new Robot();
		app = new App();
	}



	@Test
	void testRobotTurningRight() {
		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.East, robot.direction);

		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.South, robot.direction);

		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.West, robot.direction);

		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.North, robot.direction);
	}

	@Test
	public void testRobotTurningLeft() {
		robot.turnLeft();
		Assertions.assertEquals(Robot.Direction.West, robot.direction);

		robot.turnLeft();
		Assertions.assertEquals(Robot.Direction.South, robot.direction);

		robot.turnLeft();
		Assertions.assertEquals(Robot.Direction.East, robot.direction);

		robot.turnLeft();
		Assertions.assertEquals(Robot.Direction.North, robot.direction);
	}

	@Test
	public void testRobotSettingPenUp() {
		robot.setPenUp();
		Assertions.assertFalse(robot.pen);
	}

	@Test
	public void testRobotSettingPenDown() {
		robot.setPenDown();
		Assertions.assertTrue(robot.pen);
	}

	@Test
	public void testRobotInitialPosition() {
		Assertions.assertEquals(0, robot.x);
		Assertions.assertEquals(0, robot.y);
	}

	@Test
	public void testRobotSettingPosition() {
		robot.setXY(3, 2);
		Assertions.assertEquals(3, robot.x);
		Assertions.assertEquals(2, robot.y);
	}

	@Test
	public void testRoomConstructor() {
		int expectedSize = 5;
		Assertions.assertEquals(expectedSize, room.room.length);
		Assertions.assertEquals(expectedSize, room.room[0].length);
	}

	@Test
	public void testRoomPrint() {
		// Set a pattern in the room
		room.room[1][2] = 1;
		room.room[3][4] = 1;

		String expectedOutput =
				"0 0 0 0 0 \n" +
						"0 0 1 0 0 \n" +
						"0 0 0 0 0 \n" +
						"0 0 0 0 1 \n" +
						"0 0 0 0 0 \n";

		Assertions.assertEquals(expectedOutput, getRoomPrintOutput());
	}

	@Test
	public void testRobotTurningRightAndLeft() {
		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.East, robot.direction);

		robot.turnLeft();
		Assertions.assertEquals(Robot.Direction.North, robot.direction);

		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.East, robot.direction);

		robot.turnLeft();
		Assertions.assertEquals(Robot.Direction.North, robot.direction);
	}

	@Test
	public void testRobotSettingPenUpAndDown() {
		robot.setPenUp();
		Assertions.assertFalse(robot.pen);

		robot.setPenDown();
		Assertions.assertTrue(robot.pen);

		robot.setPenUp();
		Assertions.assertFalse(robot.pen);
	}

	@Test
	public void testRoomConstructor_2() {
		Room room1 = new Room(5);
		Assertions.assertEquals(5, room1.room.length);
		Assertions.assertEquals(5, room1.room[0].length);

		Room room2 = new Room(3);
		Assertions.assertEquals(3, room2.room.length);
		Assertions.assertEquals(3, room2.room[0].length);
	}

	@Test
	public void testRoomPrint_2() {
		Room room = new Room(5);

		// Pattern 1: Empty room
		String expectedOutput1 = "0 0 0 0 0 \n" +
				"0 0 0 0 0 \n" +
				"0 0 0 0 0 \n" +
				"0 0 0 0 0 \n" +
				"0 0 0 0 0 \n";
		Assertions.assertEquals(expectedOutput1, getRoomPrintOutput(room));

		// Pattern 2: Set a few cells to 1
		room.room[1][2] = 1;
		room.room[3][4] = 1;
		String expectedOutput2 = "0 0 0 0 0 \n" +
				"0 0 1 0 0 \n" +
				"0 0 0 0 0 \n" +
				"0 0 0 0 1 \n" +
				"0 0 0 0 0 \n";
		Assertions.assertEquals(expectedOutput2, getRoomPrintOutput(room));
	}

	@Test
	public void testRobotSettingPenUpAndDownWithInitialDirection() {
		Assertions.assertFalse(robot.pen); // Initial pen state is up
		Assertions.assertEquals(Robot.Direction.North, robot.direction); // Initial direction is North

		robot.setPenDown();
		Assertions.assertTrue(robot.pen);

		robot.turnRight();
		Assertions.assertEquals(Robot.Direction.East, robot.direction);

		robot.setPenUp();
		Assertions.assertFalse(robot.pen);
	}

	@Test
	public void testRoomPrintEmptyRoom() {
		Room room = new Room(3); // Room size: 3x3

		String expectedOutput =
				"0 0 0 \n" +
						"0 0 0 \n" +
						"0 0 0 \n";
		Assertions.assertEquals(expectedOutput, getRoomPrintOutput(room));
	}

	@Test
	public void testRoomPrintNonEmptyRoom() {
		Room room = new Room(3); // Room size: 3x3
		room.room[1][1] = 1; // Set one cell to 1

		String expectedOutput =
				"0 0 0 \n" +
						"0 1 0 \n" +
						"0 0 0 \n";
		Assertions.assertEquals(expectedOutput, getRoomPrintOutput(room));
	}


	@Test
	public void testRoomPrintEmptyRoomWithPenUp() {
		Room room = new Room(4); // Room size: 4x4
		robot.setPenUp();

		String expectedOutput =
				"0 0 0 0 \n" +
						"0 0 0 0 \n" +
						"0 0 0 0 \n" +
						"0 0 0 0 \n";
		Assertions.assertEquals(expectedOutput, getRoomPrintOutput(room));
	}



	@Test
	public void testRoomPrintFullRoom_2() {
		// Arrange
		Room room = new Room(3);
		Robot robot = new Robot();
		robot.setXY(0, 0); // Robot's initial position: (0, 0)
		robot.setPenDown();
		App.robot = robot; // Set the robot object in the App class
		App.room = room;

		// Move the robot in a pattern to traverse all cells without moving beyond the room boundaries
		// Call the move method after initializing the robot object
		robot.direction = Robot.Direction.North;
		App.move("2");
		robot.direction = Robot.Direction.East;
		App.move("2");
		robot.direction = Robot.Direction.South;
		App.move("2");
		robot.direction = Robot.Direction.West;
		App.move("1");
		robot.direction = Robot.Direction.North;
		App.move("1");

		// Instead of using getRoomPrintOutput, let's use room.print() to get the output directly
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		room.print();
		String actualOutput = outputStream.toString();

		String expectedOutput =
				"1 1 1 \n" +
						"1 1 1 \n" +
						"1 1 1 \n";
		Assertions.assertEquals(expectedOutput, actualOutput);
	}

    // Buggy Test case
	@Test
	public void testRobotMoveEastBeyondRoomBounds() {
		room = new Room(5);
		robot.setXY(4, 2); // Robot's initial position: (4, 2), right boundary
		robot.setPenDown();
		robot.direction = Robot.Direction.East;

		// Call the move method after initializing the robot object
		App.robot = robot; // Set the robot object in the App class
		App.room = room;
		App.move("2"); // Move two steps east

		// The robot should move to the right boundary (5) and stop at (5, 2)
		Assertions.assertEquals(5, robot.x);
		Assertions.assertEquals(2, robot.y);
	}


	// Buggy Test case
	@Test
	public void testRobotMoveNorthBeyondRoomBounds() {
		room = new Room(5);
		robot.setXY(2, 5); // Robot's initial position: (2, 5), top boundary
		robot.setPenDown();
		robot.direction = Robot.Direction.North;

		// Call the move method after initializing the robot object
		App.robot = robot; // Set the robot object in the App class
		App.room = room;
		App.move("1");
		Assertions.assertEquals(2, robot.x); // Expected X position: 2 (no change)
		Assertions.assertEquals(5, robot.y); // Expected Y position: 5 (no change)
	}

	//Buggy Test case
	@Test
	public void testRobotMoveSouthBeyondRoomBounds() {
		room = new Room(5);
		robot.setXY(2, 0); // Robot's initial position: (2, 0), bottom boundary
		robot.setPenDown();
		robot.direction = Robot.Direction.South;

		// Call the move method after initializing the robot object
		App.robot = robot; // Set the robot object in the App class
		App.room = room;
		App.move("1");
		Assertions.assertEquals(2, robot.x); // Expected X position: 2 (no change)
		Assertions.assertEquals(0, robot.y); // Expected Y position: 0 (no change)
	}



	@Test
	public void testRobotMoveWestBeyondRoomBounds() {
		room = new Room(5);
		robot.setXY(0, 2); // Robot's initial position: (0, 2), left boundary
		robot.setPenDown();
		robot.direction = Robot.Direction.West;

		// Call the move method after initializing the robot object
		App.robot = robot; // Set the robot object in the App class
		App.room = room;
		App.move("1");
		System.out.println(robot.x);
		System.out.println(robot.y);
		Assertions.assertEquals(0, robot.x); // Expected X position: 0 (no change)
		Assertions.assertEquals(2, robot.y); // Expected Y position: 2 (no change)
	}

	@Test
	public void testRobotMoveWestWithPenUp() {
		room = new Room(5);
		robot.setXY(2, 2); // Robot's initial position: (2, 2)
		robot.setPenUp();
		robot.direction = Robot.Direction.West;

		// Call the move method after initializing the robot object
		App.robot = robot; // Set the robot object in the App class
		App.room = room;
		App.move("1"); // Move one step west

		// Verify the room remains unchanged (all cells should be 0)
		String expectedOutput =
				"0 0 0 0 0 \n" +
						"0 0 0 0 0 \n" +
						"0 0 0 0 0 \n" +
						"0 0 0 0 0 \n" +
						"0 0 0 0 0 \n";
		Assertions.assertEquals(expectedOutput, getRoomPrintOutput(room));
	}




	private String getRoomPrintOutput(Room room) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < room.room.length; i++) {
			for (int j = 0; j < room.room[i].length; j++) {
				sb.append(room.room[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private String getRoomPrintOutput() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < room.room.length; i++) {
			for (int j = 0; j < room.room[i].length; j++) {
				sb.append(room.room[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}


	// Data flow testcases for the developed scenario

	@Test
	public void testInitializationOfRoom() {
		// Input
		String choice = "i 5";

		// Act
		app.runCommand(choice);

		// Assert
		Assertions.assertNotNull(App.room);
		Assertions.assertEquals(5, App.room.room.length);
	}

	@Test
	public void testInitializationOfRoom_2() {
		String choice = "i 5";
		app.runCommand(choice);
		// Assertions and other checks
	}

	@Test
	public void testPrintCurrentPositionOfRobot() {
		String choice = "c";

		app.robot = new Robot();
		App.robot.setXY(2, 3);
		App.robot.setPenDown();
		App.robot.direction = Robot.Direction.North;

		String expectedOutput = "Position:2,3 - Pen:Down - Facing:North";
		Assertions.assertEquals(expectedOutput, app.runCommandAndGetOutput(choice));
	}

	@Test
	public void testPenUp() {
		String choice = "u";

		app.robot = new Robot();
		App.robot.setPenDown();
		app.runCommand(choice);
		Assertions.assertFalse(App.robot.pen);
	}

	@Test
	public void testPenDown() {
		String choice = "d";

		app.robot = new Robot();
		App.robot.setPenUp();
		app.runCommand(choice);
		Assertions.assertTrue(App.robot.pen);
	}

	@Test
	public void testTurnRight() {
		String choice = "r";

		app.robot = new Robot();
		App.robot.direction = Robot.Direction.North;
		app.runCommand(choice);
		Assertions.assertEquals(Robot.Direction.East, App.robot.direction);
	}

	@Test
	public void testTurnLeft() {
		String choice = "l";

		app.robot = new Robot();
		App.robot.direction = Robot.Direction.East;
		app.runCommand(choice);
		Assertions.assertEquals(Robot.Direction.North, App.robot.direction);
	}

	@Test
	public void testMoveEast() {

		String choice = "i 6";

		app.runCommand(choice);

		choice = "m 3";
		App.robot = new Robot();
		App.robot.setXY(2, 2);
		App.robot.direction = Robot.Direction.East;

		// Initialize the room with a size of 6 (or any desired size)


		app.runCommand(choice);

		Assertions.assertEquals(5, App.robot.x);
		Assertions.assertEquals(2, App.robot.y);
	}


	@Test
	public void testMoveWest() {
		String choice = "m 2";

		app.robot = new Robot();
		App.robot.setXY(3, 3);
		App.robot.direction = Robot.Direction.West;

		app.runCommand(choice);

		Assertions.assertEquals(1, App.robot.x);
		Assertions.assertEquals(3, App.robot.y);
	}

	@Test
	public void testMoveNorth() {

		String choice = "i 6";

		app.runCommand(choice);
		choice = "m 4";

		app.robot = new Robot();
		App.robot.setXY(1, 2);
		App.robot.direction = Robot.Direction.North;

		app.runCommand(choice);

		Assertions.assertEquals(1, App.robot.x);
		Assertions.assertEquals(6, App.robot.y);
	}

	@Test
	public void testMoveSouth() {
		String choice = "m 1";

		app.robot = new Robot();
		App.robot.setXY(4, 4);
		App.robot.direction = Robot.Direction.South;

		app.runCommand(choice);

		Assertions.assertEquals(4, App.robot.x);
		Assertions.assertEquals(3, App.robot.y);
	}

	@Test
	public void testPrintRoom() {
		String choice = "p";
		App.room = new Room(4);
		App.room.room[2][2] = 1;
		App.room.room[3][1] = 1;

		String expectedOutput =
				"0 0 0 0 " + LINE_SEPARATOR +
						"0 0 0 0 " + LINE_SEPARATOR +
						"0 0 1 0 " + LINE_SEPARATOR +
						"0 1 0 0";

		Assertions.assertEquals(expectedOutput, app.runCommandAndGetOutput(choice));
	}

	@Test
	public void testInvalidChoice() {
		String choice = "x";
		String expectedOutput = "Invalid choice. Please try again.";
		Assertions.assertEquals(expectedOutput, app.runCommandAndGetOutput(choice));
	}





}


