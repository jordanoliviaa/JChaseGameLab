package jchaselab3;

public class Key extends Item {

	public Key(String n, String desc) {
		super(n, desc);
		}
	
	@Override
	public void use() {
		Room closet = Game.currentRoom.getExit('n');
	}
}
