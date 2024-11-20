package jchaselab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("rooms"));
			while(input.hasNextLine()){
				String line = input.nextLine();
				if (line.equals("#")) {
				}
				else {
				String descript = input.nextLine();
				Game.rooms.put(line, descript);
				System.out.println(Game.rooms.get(line));
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("This file doesn't exist.");
		}
	}
}
