package practice4;

import java.util.Scanner;

public class ComputingXModPowerOfTwo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		int mod = scan.nextInt();
		
		System.out.println(Integer.toBinaryString(input));
		System.out.println(Integer.toBinaryString(mod-1));
		
		/* Take the mod and subtract 1 to convert right most 1 to a 0 and all the 0's to 1's.
		 * bitwise AND (mod-1) to the input number.
		 * this reduces the input number to the mod number and only keeps the remainder(where 1 --> 1) 
		 * ONLY WORKS WHEN mod is a multiple of 2.
		 */
		input = (input & (mod-1));
		
		System.out.println(input);
		
		scan.close();

	}

}
