package practice4;

import java.util.Scanner;

public class ReplacingRightmostZeroesWithOnes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		if(input == 0){
			System.out.println(0);
		}else{
			input = ((input)|(input-1));
			
			System.out.println(input);	
		}
		
		scan.close();
		
	}

}
