package practice4;

import java.util.Scanner;

public class BitwiseModPower1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		
		int mod = ~( (x&y) | (~x&~y) );
		System.out.println(mod);
		
		scan.close();
	}

}
