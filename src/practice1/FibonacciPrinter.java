package practice1;
import java.util.Scanner;

public class FibonacciPrinter {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
			switch(input){
				case 0:
					//if the input is 0 simply break
					break;
				
				case 1:
					//if the input is 1 simply print 0
					System.out.print("0");
					break;
					
				 default:
					 //if the input is greater than 1, start is 0 1 and add more from the sequence
					 String result = "0 1 ";
					 //initiate the start of the sequence
					 int[] last2ints = new int[2];
					 last2ints[0] = 0;
					 last2ints[1] = 1;
					 
					 for(int j = 2; j < input; j++){
						 //of the sum of the previous 2 numbers
						 int nextSum = (last2ints[0]+last2ints[1]);
						 result += (nextSum);
						 //Update the last 2 numbers
						 last2ints[0] = last2ints[1];
						 last2ints[1] = nextSum;
						 
						 //include space except for last number inserted
						 if(j != input-1){
							 result += " ";
						 }
					 }
					 System.out.print(result);
					break;
			}
		
		scan.close();
	}
	
}
