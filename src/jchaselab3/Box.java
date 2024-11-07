package jchaselab3;

public class Box extends Item {
	
	public Box (String n, String desc) {
		super(n, desc);
	}
	
	@Override
	public void open() {
		Game.print("You open the old take out container (gross.) \namong the scraps you find a key. Against your better judgement, you take it.");
		Key redKey = new Key ("key", "This is a red key. Don't know what it goes to.");
		Game.inventory.add(redKey);
	}
}
