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

}
 