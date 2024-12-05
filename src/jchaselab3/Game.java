package jchaselab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//contains the main method
//tells the world to create game world
//navigates through the game to print rooms

public class Game {

	public static Room currentRoom= World.buildWorld();
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();

	public static HashMap<String, String> rooms = new HashMap<String, String>();
	
	public static GUI ui = new GUI();
	
	public static void main(String[] args) {
		Game.roomsBuild();
		Game.print(currentRoom);
		Game.print(currentRoom.getDesc());
	}

	public static void runGame() {
		Scanner input = new Scanner(System.in);
		
		String command; //player's command
		do {
			System.out.println();
			Game.roomsBuild();
			System.out.println(currentRoom);
			System.out.println(currentRoom.getDesc());
			System.out.print("What do you want to do?: ");
			command = input.nextLine();
			String[] words = command.split(" ");

			
			switch(words[0]) {
			case "save" :
				Game.saveGame("GameTest");
				break;
				
			case "load" :
				Game.loadGame("GameTest");
				break;
				
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
					System.out.println("\nThere is no door here, just wall.");
				}
				else {
					if (nextRoom.isLocked == false) {
					currentRoom = nextRoom;
					System.out.println();
					}
					else {
						System.out.println("\nYou silly goose, this door is locked. find a key and try again.");
					}
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
		ui.text.append(obj.toString()+"\n");
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
	
	public static void processCommand(String command) {

			String[] words = command.split(" ");
			Game.print(words[0]);
			
			switch(words[0]) {
			case "save" :
				Game.saveGame("GameTest");
				break;
				
			case "load" :
				Game.loadGame("GameTest");
				break;
				
			case "use" :
				Game.print("\nYou are trying to use the " + words[1] + ".");
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
						Game.print("This object is not here.");
					}
					
				}
				else {
					Item s = currentRoom.getObject(words[1]);
					if (s == null) {
						Game.print("This object is not here.");
					}
					else {
						Item object = currentRoom.getObject(words[1]);
						object.use();
						}					
					}
				break;
			
			case "open":
				Game.print("\nYou are trying to open the " + words[1] + ".");
				
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
						Game.print("This object is not here.");
					}
					
				}
				else {
					Item s = currentRoom.getObject(words[1]);
					if (s == null) {
						Game.print("This object is not here.");
					}
					else {
						Item object = currentRoom.getObject(words[1]);
						object.open();
						}					
					}
				break;
				
				
			case "look":
				Game.print("\nYou are trying to look at the " + words[1] + ".");
				if (currentRoom.getObject(words[1])==null) {
					if (inventory.size() > 0) {
						for (int c=0; c<inventory.size(); c++) {
							Item s = inventory.get(c);
							if ((s.getName()).equals(words[1])) {
								Game.print("Description of the "+words[1]+": "+s.getDesc());
							}
						}
					}
					else {
						Game.print("This object is not here.");
					}
					
				}
				else {
					Item s = currentRoom.getObject(words[1]);
					if (s == null) {
						Game.print("This object is not here.");
					}
					else {
						Game.print("Description of the "+words[1]+": "+s.getDesc());
						}					
					}
				break;
			case "take":
				Game.print("\nYou are trying to take the "+words[1]+".");
				Item i = currentRoom.getObject(words[1]);
				if (i == null){
					Game.print("There is no " + words[1] + " to take.");
				}
				else {
					inventory.add(i);
					currentRoom.removeObject(words[1]);
					Game.print("\nYou took the " + i.getName()+".");
				}
				break;
			case "i":
				if (inventory.size()>0){
					Game.print("\nYour inventory");
					for (int c=0; c<inventory.size();c++) {
						Item s = inventory.get(c);
						Game.print(s);
					}
				}
				else {
					Game.print("Your inventory is empty.");
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
					Game.print("\nThere is no door here, just wall.");
				}
				else {
					if (nextRoom.isLocked == false) {
					currentRoom = nextRoom;
					Game.print("");
					}
					else {
						Game.print("\nYou silly goose, this door is locked. find a key and try again.");
					}
				}
				break;
			case "x":
				Game.print("Thanks for walking through my game!");
				break;
			default:
				Game.print("I don't know what that means.");
			}
		
	}
	
	public static void roomsBuild() {
		try {
			Scanner input = new Scanner(new File("rooms"));
			while(input.hasNextLine()){
				String name = new String (input.nextLine());
				String descript = new String (input.nextLine());
				rooms.put(name, descript);
				input.nextLine();
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("This file doesn't exist.");
		}
	}
	
	public static void saveGame(String saved) {
		File f = new File(saved);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(inventory);
			stream.writeObject(currentRoom);
			stream.writeObject(rooms);
			stream.close();
		}catch (FileNotFoundException e) {
			System.out.println("File "+saved+" not found.");
		}catch (IOException ex) {
			System.out.println("That sucks.");
		}
	}
	
	public static void loadGame(String saved) {
		File f = new File(saved);
		try {
			FileInputStream fos = new FileInputStream(saved);
			ObjectInputStream stream = new ObjectInputStream(fos);
			inventory = (ArrayList) stream.readObject();
			currentRoom = (Room) stream.readObject();
			rooms = (HashMap) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File "+saved+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("That's rough.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Not an object.");
		}
	}
}
