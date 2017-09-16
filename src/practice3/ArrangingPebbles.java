package practice3;

import java.util.Scanner;

public class ArrangingPebbles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine().replaceAll("\\s","");
		System.out.println(input);
		String map = "wgr";
		int letter = 0;
		int pointerX = 0;
		int pointerY = 1;
		//start at the beginning of the array
		//if the character is == the letter we want, advance pointer X by one...
		//else look for the letter we need by advancing k until we find it and swap
		//when k reaches the end of the array, change the 
		
		// use this method on a string form of the input map.indexOf(ch, fromIndex)
		
		scan.close();

	}

}
