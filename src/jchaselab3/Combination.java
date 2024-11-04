package jchaselab3;

public class Combination extends Item{

	public Combination(String n, String desc) {
		super(n, desc);
	}
	
	@Override
	public void use() {
		Game.print("If you find a safe, try opening it!");
	}
}
