package practice2;
import java.util.Scanner;

public class DecimalToNumInArbitraryBase {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		int result = 0;
		int multiple = 1;
		int base10Num = scan.nextInt();
		int base = scan.nextInt();
		int quotient = 0;
		
		
		
		while(base10Num > 0){
			quotient = base10Num / base;
			result = result+((base10Num%base)*multiple);
			multiple = multiple * 10;
			base10Num = quotient;
			
			
		}
		System.out.println(result);
		
		
		scan.close();
	}
}
