package jchaselab3;

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
		System.out.println("You can't open that!");
	}
	
	public void use() {
		System.out.println("You can't use that!");
	}

}
 