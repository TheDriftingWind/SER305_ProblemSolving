package practice4;

import java.util.Scanner;

public class ReplacingRightmostZeroesWithOnes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		if(input == 0){
			System.out.println(0);
		}else{
			//subtract 1 to change the right most 1 to 0 and all 0s to right of that to 1
			//bitwise OR to keep the 1 from input and add the new 1s from (input-1)
			input = ((input)|(input-1));
			
			System.out.println(input);	
		}
		
		scan.close();
		
	}

}
