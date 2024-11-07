package jchaselab3;

public class Key extends Item {

	public Key(String n, String desc) {
		super(n, desc);
	}
	
	@Override
	public void use() {
		Room closet = Game.currentRoom.getExit('e');
		if (closet.getName().equals("Storage Closet")) {
			if (closet.isLocked == true) { 
				Game.currentRoom.getExit('e').setLocked(false);
				Game.print("You unlocked the door! Wonder where it goes...");
			}
			else {
				Game.print("You already used this key.");
			}
		}
		else {
			Game.print("You cannot use that here silly.");
		}
			
	}
}
