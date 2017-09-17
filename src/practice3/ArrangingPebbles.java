package practice3;

import java.util.Arrays;
import java.util.Scanner;

public class ArrangingPebbles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		
		String map = "wgr";
		int letter = 0;
		
		//start at the first element
		for(int i = 0; i < input.length; i++){
			//if the current element doesn't match the letter we want...
			if (!input[i].equals(Character.toString(map.charAt(letter)))){
				//find where the index where the letter occurs last...
				int replace = Arrays.asList(input).lastIndexOf( String.valueOf(map.charAt(letter)) );
				
				//if it occurs at or before the index, there's no more of the letter that needs to be sorted...
				if(replace <= i && letter < 2){
					//move on to the next letter.
					letter++;
					i = i -1; //decrement the index so that you don't skip this element
				}else{
					//if there are more occurrences, find it and swap the current element with the needed letter
					input[replace] = input[i];
					input[i] = String.valueOf(map.charAt(letter));
				}
				
			}
		}
		//Print out the results
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i]);
			if(i < input.length-1){
			System.out.print(" ");
			}
		}
		
		scan.close();

	}

}
