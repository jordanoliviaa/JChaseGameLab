package jchaselab3;

//builds the game world
//creates room objects and connects them together

public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Room buildWorld() {
		Room lobbyOne = new Room("First Floor Lobby");
		Room lobbyTwo = new Room("Second Floor Lobby");
		Room studyRoom = new Room ("Study Room");
		Room chemLab = new Room ("Chemistry Lab");
		Room engineering = new Room ("Engineering");
		Room robotics = new Room ("Robotics Lab");
		Room storageCloset = new Room ("Storage Closet");
		Item spoon = new Item ("spoon", "A rusty spoon. Gross.");
		Box trash = new Box ("container", "This is someone's old take out. Feels heavy.");
		Item fork = new Item("fork", "This is a plastic fork.");
		Item shoe = new Item ("shoe", "This is a shoe. How did someone lose just one?");
		Combination combo = new Combination("combination", "This is the combination to a safe.");
		Safe safe = new Safe ("safe", "This is a safe. Very sturdy.");
		Note note = new Note ("note", "This is a note, what does it say?");
		Item drawing = new Item ("drawing", "This is a poorly drawn image of a diamond (maybe...)");

		lobbyOne.addExit(lobbyTwo, 'u');
		lobbyOne.addObject(spoon);
		lobbyOne.addObject(fork);
		lobbyOne.addObject(shoe);
		lobbyOne.addObject(drawing);
		
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
		chemLab.addObject(note);
		

		robotics.addExit(lobbyTwo, 'n');
		robotics.addExit(storageCloset, 'e');

		storageCloset.addExit(robotics, 'w');
		storageCloset.addObject(combo);
		storageCloset.setLocked(true);

		return lobbyOne;  //starting room
	}
}