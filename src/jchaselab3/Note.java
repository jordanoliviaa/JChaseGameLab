package jchaselab3;

public class Note extends Item{

	public Note (String n, String desc) {
		super (n, desc);
	}
	
	@Override
	public void use() {
		Game.print("The combonation for the safe is in the storage closet.");
	}
}
