package practice2;
import java.util.Scanner;

public class DecimalToOctal {
	
	//1.define scanner
	//2.define result variable to store the digits as you put them in
	//3.take in input
	//4.declare base10Num and set it equal to input
	//5.take base10Num and divide it by 8 to get the quotient.
	//6.store the quotient in remainder variable
	//7.mod base10Num by 8, the result is the first digit to add to the beginning of the result
	//8.add the result of base10Num%8 to the result variable; insert it from the left
	//9.set base10Num to the remainder
	//repeat 4 - 9 until the base10Num is less than or equal to 0
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		int result = 0;
		int multiple = 1;
		int base10Num = scan.nextInt();
		int quotient = 0;
		
		while(base10Num > 0){
			quotient = base10Num / 8;
			result = result+((base10Num%8)*multiple);
			multiple = multiple * 10;
			base10Num = quotient;
			
			
		}
		System.out.println(result);
		
		
		scan.close();
	}

}
