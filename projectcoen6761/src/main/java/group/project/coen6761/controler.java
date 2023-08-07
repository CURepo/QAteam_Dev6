package group.project.coen6761;

import java.util.Scanner;

public class controler {
	public void run() {
		 Scanner scanner = new Scanner(System.in);
	        String choice = "";
	        boolean isStarted=false;
	        while (!choice.equalsIgnoreCase("Q")) {
	            System.out.println("********* Welcome to the Console Menu *********");
	            System.out.println("1. To initialize the room enter I followed by an integer:");
	            System.out.println("2. To Print the current position of the robot enter C:");
	            System.out.println("3. To pen up enter U:");
	            System.out.println("4. To pen down enter D:");
	            System.out.println("5. To Turn right enter R:");
	            System.out.println("6. To Turn left enter L:");
	            System.out.println("7. To move the robot forward enter M followed by an integer:");
	            System.out.println("8. To print the room enter P:");
	            System.out.println("9. To Stop the program enter Q:");
	            System.out.println("************************************************");
	            System.out.print("Enter your choice:");
	            choice = scanner.nextLine();
	            String number="";
	            choice=choice.trim().replaceAll("\\s", "").toLowerCase();
	            if(choice.contains("m")||choice.trim().replaceAll("\\s", "").toLowerCase().contains("i")) {
	            	number=App.getNumber(choice);
	            	choice=App.convertInput(choice);
	            }
	            try {
	            switch (choice) {
	                case "i":
	                	App.initiateTheRoom(number);
	                	isStarted=true;
	                    break;
	                case "c":
	                	if(isStarted)
	                	App.printThCurrentPositionOfRobot();
	                    break;
	                case "u":
	                	if(isStarted)
	                	App.robot.setPenUp();
	                    break;
	                case "d":
	                	if(isStarted)
	                	App.robot.setPenDown();
	                    break;
	                case "r":
	                	if(isStarted)
	                	App.robot.turnRight();
	                    break;
	                case "l":
	                	if(isStarted)
	                	App.robot.turnLeft();
	                    break;
	                case "m":
	                	if(isStarted)
	                	App.move(number);
	                    break;
	                case "p":
	                	
	                	if(isStarted)
	                	App.room.print();
	                    break;
	                case "q":
	                    System.out.println(" Exit the program....");
	                    break;    
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	            }catch(NumberFormatException e) {
	            	System.out.println("Invalid input format. Please provide a valid number.");
	            }
	            System.out.println(); // Add a line break for readability
	        }

	        scanner.close();
	}
}
