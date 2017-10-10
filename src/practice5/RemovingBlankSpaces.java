package practice5;

import java.util.Scanner;

public class RemovingBlankSpaces {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numLine = scan.nextInt(); //number of lines
		scan.nextLine(); //clear the line
		
		//for each line...
		for(int i = 0; i < numLine; i++){
			String sentence = scan.nextLine();
			StringBuilder sb = new StringBuilder(sentence);
			
			
		}
		
		
		
		scan.close();

	}

}
