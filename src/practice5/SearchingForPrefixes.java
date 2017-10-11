package practice5;

import java.util.Scanner;

public class SearchingForPrefixes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//get the keyword
		String keyword = scan.nextLine();
		//Get the sentence
		String sentence = scan.nextLine();
		
		//use pointers to search through the sentence
		int pointer_i = 0; //incrementing pointer
		int pointer_c = 0; //word check pointers
		int found_prefixes = 0;
		boolean found_word = true;
				
		while (pointer_i < sentence.length()){
			//found a new word
			if (found_word == true){
				pointer_c = pointer_i;
				//start comparing letters
				int letter_index = 0;
				int chars_matched = 0;
				boolean check_finished = false;
				
				while(check_finished != true){
					//if the letters match...compare letters
					if( keyword.charAt(letter_index) == sentence.charAt(pointer_c) ){
						//increment 1 to letters matched
						chars_matched++;
						if(chars_matched == keyword.length()){
							//if all the letters match, get the rest of the word, print the word found and break the inner while loop
							while(sentence.charAt(pointer_c) != ' ' && sentence.charAt(pointer_c) != '.' && sentence.charAt(pointer_c) != ',' ){
								pointer_c++;
							}
							found_prefixes++;
							System.out.println(sentence.substring(pointer_i, pointer_c));
							found_word = false; //continue to search for more matches
							check_finished = true;//break this loop
						} else {
							//else keep checking
							letter_index++;
							pointer_c++;
						}
					}else{
						//if the letters don't match...
						check_finished = true; //break the loop
						found_word = false; // look for next word
					}
				}
				
			}else{ //looking for word
				if(sentence.charAt(pointer_i) == ' ' && sentence.charAt(pointer_i)+1 != ' '){
					found_word = true; //the next character will be the start of a word
					pointer_i++;
				}else{
					//keep looking for a word
					pointer_i++; //move on to the next spot
				}
			}
		}
		
		if(found_prefixes == 0){
			System.out.println("A word containing the given prefix was not found.");
		}
		scan.close();
		

	}

}
