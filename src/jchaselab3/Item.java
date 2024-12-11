package jchaselab3;

import java.io.Serializable;

public class Item {
	public String description;
	public String name;
	
	public Item(String n, String desc) {
		name = n;
		description = desc;
	}
	
	public String getDesc() {
		return description;
	}
	
	public String getName() {
		return name;
	}

	public void setDesc(String d) {
		description = d;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String toString() {
		return name + "";
	}
	
	public void open() {
		Game.print("You can't open that!");
	}
	
	public void use() {
		Game.print("You can't use that!");
	}

}
 