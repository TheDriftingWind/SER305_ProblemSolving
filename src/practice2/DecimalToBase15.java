package practice2;
import java.util.Scanner;

/*
 * define scanner
 * define a string map (0-E)
 * define a result variable to store the digits
 * define a variable to storage the quotient
 * 
 * Get the next integer as base10Num
 * check if base10Num is 0, if so, simple add 0 to the result
 * 
 * if the base10Num is greater than 0, 
 * take base10Num and divide it by 15 to get the quotient.
 *	store the quotient in remainder variable
 *	mod base10Num by 15, the result is the first digit to add to the beginning of the result
 *	add the result of base10Num%15 to the result variable; insert it from the left
 *	set base10Num to the remainder
 *	repeat 4 - 9 until the base10Num is less than or equal to 0
 */
public class DecimalToBase15 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String map = "0123456789ABCDE";
		StringBuilder result = new StringBuilder();
		int base10Num = scan.nextInt();
		int quotient = 0;
		
		
		if(base10Num == 0){
			result.insert(0, 0);
		}
		while(base10Num > 0){
			quotient = base10Num / 15;
			result = result.insert(0,(map.charAt((base10Num%15))));
			base10Num = quotient;
			
			
		}
		
		System.out.println(result.toString());
		
		
		scan.close();
	}
}
