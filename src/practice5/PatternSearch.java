package practice5;

import java.util.Scanner;

public class PatternSearch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String keyword = scan.nextLine();
		
		String sentence = scan.nextLine();
		
		String ConcatString = keyword + "$" + sentence; // Concatenate the keyword and the sentence into one string divided by $ symbol
		int count_of_found = 0;		
		int Z_values[] = getZArray(ConcatString); //run the method to get the array of Z values
		
		for(int x = 0; x < Z_values.length; x++){
			/*
			 * Run through the array...
			 * The spot where the value at that index is equal to the length of the pattern is where
			 * the match begins.
			 */
			if(Z_values[x] == keyword.length()){
				System.out.println(x- (keyword.length()+1) );
				count_of_found++;
			}
		}
		if (count_of_found == 0){
			System.out.println("*** The given pattern was not found.***");
		}
	}
	
	/*
	 * This method gets the "Z" values that correspond to the characters in the string
	 */
	private static int[] getZArray(String input_string) {
		int Z_vals[] = new int[input_string.length()]; //array to store the Z values. Length is known(= sentence length)
		int pointer_i = 0; //incrementing pointer
		int pointer_c = 0; //checking pointer
		
		//go through each character of the string - start at 1 so you don't compare the first character to itself
		for(int i = 1; i < input_string.length(); i++){
			if(i > pointer_c ){
				pointer_c = i;
				pointer_i = pointer_c;
				//compare characters
				while(pointer_c < input_string.length() && input_string.charAt(pointer_c) == input_string.charAt(pointer_c - pointer_i)){
					//if the characters match, check to see if the next characters match
					pointer_c++;
				}
				//once they don't match, record the number of characters that did match
				Z_vals[i] = pointer_c - pointer_i;
				pointer_c--; 
			} 
		}
		return Z_vals;
	}

}
