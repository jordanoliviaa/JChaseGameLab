package jchaselab3;

//builds the game world
//creates room objects and connects them together

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room lobbyOne = new Room("You are in the first floor lobby.");
		Room lobbyTwo = new Room("You are in the second floor lobby.");
		Room studyRoom = new Room ("You are in the study room.");
		Room chemLab = new Room ("You are in the Chemistry lab.");
		Room engineering = new Room ("You are in the Engineering suite!");
		Room robotics = new Room ("You are in the robotics lab.");
		Room storageCloset = new Room ("You are in the storage closet.");
		Item spoon = new Item ("spoon", "A rusty spoon. Gross.");
		Item key = new Item ("key", "This is a red key. Don't know what it goes to.");
		Item trash = new Item ("container", "This is someone's old take out. Feels heavy.");
		Item fork = new Item("fork", "This is a plastic fork.");
		Item shoe = new Item ("shoe", "This is a shoe. How did someone lose just one?");
		Combination combo = new Combination("combination", "This is the combination to a safe.");
		Safe safe = new Safe ("safe", "This is a safe. Very sturdy.");
		
		lobbyOne.addExit(lobbyTwo, 'u');
		lobbyOne.addObject(spoon);
		lobbyOne.addObject(fork);
		lobbyOne.addObject(shoe);
		lobbyOne.addObject(combo);
		
		lobbyOne.addExit(studyRoom, 'e');
		lobbyOne.addExit(engineering, 'n');

		lobbyTwo.addExit(lobbyOne, 'd');
		lobbyTwo.addExit(chemLab, 'w');
		lobbyTwo.addExit(robotics, 's');

		studyRoom.addExit(lobbyOne, 'w');
		studyRoom.addObject(trash);
		studyRoom.addObject(safe);

		engineering.addExit(lobbyOne, 's');

		chemLab.addExit(lobbyTwo, 'e');

		robotics.addExit(lobbyTwo, 'n');
		robotics.addExit(storageCloset, 'e');

		storageCloset.addExit(robotics, 'w');
		storageCloset.addObject(key);
		storageCloset.addObject(combo);

		return lobbyOne;  //starting room
	}
}