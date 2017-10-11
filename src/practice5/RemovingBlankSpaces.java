package practice5;

import java.util.Scanner;

public class RemovingBlankSpaces {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numLine = scan.nextInt(); //number of lines
		scan.nextLine(); //clear the line
		
		//for each line...
		for(int i = 0; i < numLine; i++){
			String sentence = scan.nextLine(); // read in the sentence
			StringBuilder sb = new StringBuilder(sentence); //make it a string builder to be able to delete specific characters
			
			boolean skipping_beginning = true; //skip the beginning spaces of a paragraph
			boolean looking_for_space = true;
			int pointer_p = 0; //incrementing pointer
			int pointer_c = 0; //checking pointer
			
			while(skipping_beginning){
				//until the first letter of the sentence is found, look for the letter
				if(pointer_p != ' '){
					//found a letter
					skipping_beginning = false;
				}else{
					pointer_p++;
				}
			}
			//now the pointer_p should be pointing at the first letter of the sentence
			
			//now look for the next space
			while(looking_for_space && pointer_p < sentence.length()){
				if(sb.charAt(pointer_p) == ' ' && sb.charAt(pointer_p+1) != ' '){
					//if you found only 1 space... leave it alone
					pointer_p++;
				}
				else if(sb.charAt(pointer_p) == ' ' && sb.charAt(pointer_p+1) == ' '){
					//if you found multiple spaces...set the checking pointer to pointer_p's location
					pointer_c = pointer_p;
					while(sb.charAt(pointer_c+1) == ' '){
						//until the checking pointer is at the last space...
						pointer_c++;
					}
					//take the difference to find the number of spaces you need to delete
					for(int x = 0; x < (pointer_c - pointer_p); x++){
						sb.deleteCharAt(pointer_p);
					}
					sentence = sb.toString();
				} else {
					//you don't find a space...
					pointer_p++;
				}
			}
			
			System.out.println(sb.toString());
		}
		
		scan.close();

	}

}
