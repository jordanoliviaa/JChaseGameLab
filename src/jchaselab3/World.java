package jchaselab3;

//builds the game world
//creates room objects and connects them together

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room lobbyOne = new Room("First Floor Lobby","You are in the first floor lobby. It's a little bit dusty.");
		Room lobbyTwo = new Room("Second Floor Lobby","You are in the second floor lobby. Why is the wall sticky?");
		Room studyRoom = new Room ("Study Room","You are in the study room, but now is not the time to study.");
		Room chemLab = new Room ("Chemistry Lab","You are in the Chemistry lab. It smells suspiciously clean...");
		Room engineering = new Room ("Engineering", "You are in the Engineering suite! You can feel the stress just by being in here.");
		Room robotics = new Room ("Robotics Lab","You are in the robotics lab. All of the machinery is nice, but wayyy too complicated.");
		Room storageCloset = new Room ("Storage Closet", "You are in the storage closet. They really need to organize in here.");
		Item spoon = new Item ("spoon", "A rusty spoon. Gross.");
		Key redKey = new Key ("key", "This is a red key. Don't know what it goes to.");
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
		storageCloset.addObject(redKey);
		storageCloset.addObject(combo);

		return lobbyOne;  //starting room
	}
}