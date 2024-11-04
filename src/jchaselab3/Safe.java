package jchaselab3;

public class Safe extends Item {
	public Safe(String n, String desc) {
			super(n, desc);
	}
	
	@Override
	public void open() {
		boolean hasDiamond = false;
		for (Item i : Game.inventory) {
			if (i.getName().equals("combination")) {
				Item diamond = new Item ("diamond","This is a shiny diamond you found in the safe. hope nobody looks for it.");
				Game.print("Using the combonation, you open the safe and find a diamond. Naturally, you pocket the diamond.");
				Game.inventory.add(diamond);
				hasDiamond = true;
				break;
			}
		}
		if (hasDiamond == false)
			Game.print("Try finding the combination first!");
	}
}