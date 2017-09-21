package practice4;

import java.util.Scanner;

public class CountingNumberOfBits_DeletingRightMostOne {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		int count = 0;
		
		while(input != 0){
			input = input&(input-1);
			count++;
		}
		
		System.out.println(count);
		
		scan.close();

	}

}
