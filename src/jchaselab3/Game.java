package jchaselab3;

import java.util.Scanner;
import java.util.ArrayList;

//contains the main method
//tells the world to create game world
//navigates through the game to print rooms

public class Game {

	static Room currentRoom= World.buildWorld();

	public static void main(String[] args) {
		runGame();
	}
	public static ArrayList<Item> inventory = new ArrayList<Item>();

	public static void runGame() {
		Scanner input = new Scanner(System.in);
		
		String command; //player's command
		do {
			System.out.println();
			System.out.println(currentRoom);
			System.out.print("What do you want to do?: ");
			command = input.nextLine();
			String[] words = command.split(" ");

			
			switch(words[0]) {
			case "use" :
				System.out.println("\nYou are trying to use the " + words[1] + ".");
				if (currentRoom.getObject(words[1])==null) {
					if (inventory.size() > 0) {
						for (int c=0; c<inventory.size(); c++) {
							Item s = inventory.get(c);
							if ((s.getName()).equals(words[1])) {
								s.use();
							}
						}
					}
					else {
						System.out.println("This object is not here.");
					}
					
				}
				else {
					Item s = currentRoom.getObject(words[1]);
					if (s == null) {
						System.out.println("This object is not here.");
					}
					else {
						Item object = currentRoom.getObject(words[1]);
						object.use();
						}					
					}
				break;
			
			case "open":
				System.out.println("\nYou are trying to open the " + words[1] + ".");
				
				if (currentRoom.getObject(words[1])==null) {
					if (inventory.size() > 0) {
						for (int c=0; c<inventory.size(); c++) {
							Item s = inventory.get(c);
							if ((s.getName()).equals(words[1])) {
								s.open();
							}
						}
					}
					else {
						System.out.println("This object is not here.");
					}
					
				}
				else {
					Item s = currentRoom.getObject(words[1]);
					if (s == null) {
						System.out.println("This object is not here.");
					}
					else {
						Item object = currentRoom.getObject(words[1]);
						object.open();
						}					
					}
				break;
				
				
			case "look":
				System.out.println("\nYou are trying to look at the " + words[1] + ".");
				if (currentRoom.getObject(words[1])==null) {
					if (inventory.size() > 0) {
						for (int c=0; c<inventory.size(); c++) {
							Item s = inventory.get(c);
							if ((s.getName()).equals(words[1])) {
								System.out.println("Description of the "+words[1]+": "+s.getDesc());
							}
						}
					}
					else {
						System.out.println("This object is not here.");
					}
					
				}
				else {
					Item s = currentRoom.getObject(words[1]);
					if (s == null) {
						System.out.println("This object is not here.");
					}
					else {
						System.out.println("Description of the "+words[1]+": "+s.getDesc());
						}					
					}
				break;
			case "take":
				System.out.println("\nYou are trying to take the "+words[1]+".");
				Item i = currentRoom.getObject(words[1]);
				if (i == null){
					System.out.println("There is no " + words[1] + " to take.");
				}
				else {
					inventory.add(i);
					currentRoom.removeObject(words[1]);
					System.out.println("\nYou took the " + i.getName()+".");
				}
				break;
			case "i":
				if (inventory.size()>0){
					System.out.println("\nYour inventory");
					for (int c=0; c<inventory.size();c++) {
						Item s = inventory.get(c);
						System.out.println(s);
					}
				}
				else {
					System.out.println("Your inventory is empty.");
				}
				break;
			case "n":
			case "w":
			case "e":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if (nextRoom == null) {
					System.out.println("There is no door here, just wall.");
				}
				else {
					currentRoom = nextRoom;
					System.out.println();
				}
				break;
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			default:
				System.out.println("I don't know what that means.");
			}
			
		}while(!command.equals("x"));
		
		input.close();
	}
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static Room getCurrent() {
		return currentRoom;
	}
	
	public Item getItem(String n) {
		if (inventory.size() > 0) {
			for (int c=0; c<inventory.size(); c++) {
				Item s = inventory.get(c);
				if ((s.getName()).equals(n)) {
					return s;
				}
			}
		}
	
		return null;
	}
}