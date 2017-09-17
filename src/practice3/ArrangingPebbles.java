package practice3;

import java.util.Arrays;
import java.util.Scanner;

public class ArrangingPebbles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		
		String map = "wgr";
		int letter = 0;
		//int pointer = 1;
		
		//start at the first element
		for(int i = 0; i < input.length; i++){
			//if the current element doesn't match the letter we want...
			if (input[i] != String.valueOf(map.charAt(letter))){
				//find where the index where the letter occurs last...
				int replace = Arrays.asList(input).lastIndexOf( String.valueOf(map.charAt(letter)) );
				
				//if it occurs at or before the index, there's no more of the letter that needs to be sorted...
				if(replace <= i){
					//move on to the next letter.
					letter++;
				}else{
					//if there are more occurrences, find it and swap the current element with the needed letter
					input[replace] = input[i];
					input[i] = String.valueOf(map.charAt(letter));
				}
				
			}
		}
		
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i] + " ");
		}
		
		scan.close();

	}

}