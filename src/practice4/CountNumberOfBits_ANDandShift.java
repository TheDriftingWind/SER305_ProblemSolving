package practice4;

import java.util.Scanner;

public class CountNumberOfBits_ANDandShift {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		int count = 0;
		while(input != 0){
			count = count + (input&1);
			input = input>>>1;
		}
		
		System.out.println(count);
		
		scan.close();

	}

}
