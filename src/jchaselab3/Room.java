package jchaselab3;

import java.util.HashMap;

//defines what a room object is in the game
// object variables: description(str), east, west, north, south, up, and down
// 4 methods will be made in this class: constructor, addExit(direction, Room), 

public class Room {
	private String name;
	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	public boolean isLocked;
	HashMap<String, Item> roomContent = new HashMap<String, Item>();
	
	
	public Room(String n, String desc) {
		name = n;
		description = desc;
	}
	
	public Room getExit(char move) {
		if (move == 'e') {
			return east;
		}
		else if (move == 'w') {
			return west;
		}
		else if (move == 'n') {
			return north;
		}
		else if (move == 's') {
			return south;
		}
		else if (move =='u') {
			return up;
		}
		else if (move == 'd') {
			return down;
		}
		else {
			return null;
		}
	}
	
	public void addExit(Room r, char c) { 
		if (c == 'e') {
			east = r;
		}
		else if (c == 'w') {
			west = r;
		}
		else if (c == 'n') {
			north = r;
		}
		else if (c == 's') {
			south = r;
		}
		else if (c == 'u') {
			up = r;
		}
		else if (c == 'd') {
			down = r;
		}
	}
	
	public void addObject(Item i) {
		roomContent.put(i.getName(), i);
	}
	
	public Item getObject(String n) {
		return roomContent.get(n);
	}
	
	public void removeObject(String n) {
		roomContent.remove(n);
	}
	
	public void setLocked(boolean lock) {
		isLocked = lock;
	}
	
	public boolean getLocked() {
		return isLocked;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String toString() {
		return name + "\n" + description + "";
	}

	
}