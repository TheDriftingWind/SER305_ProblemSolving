package practice5;

import java.util.Scanner;

public class KeywordSearch_CaseInsensitive {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//get the keyword
		String keyword = scan.nextLine();
		keyword = keyword + " "; //add empty space to make sure the check is for a word, not just part of a word
		//Get the sentence
		String sentence = scan.nextLine();
		//use pointers to search through the sentence
		int pointer_i = 0; //incrementing pointer
		int pointer_c = 0; //word check pointers
		int num_keyword = 0;//number of times the keyword occurs
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
					//if the letters match...
					if( Character.toUpperCase(keyword.charAt(letter_index)) == Character.toUpperCase(sentence.charAt(pointer_c)) ){
						//increment 1 to letters matched
						chars_matched++;
						if(chars_matched == keyword.length()){
							//if all the letters match, increment the number found and break the inner while loop
							num_keyword++;
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
		System.out.println(num_keyword);
		scan.close();
	}

}
