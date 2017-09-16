package practice1;
import java.util.Scanner;

public class ModifySeqOfNums {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" "); //create array of integers
		for(int i = 0; i < input.length; i++){
			//loop through and check if the number is greater than its index
			if(Integer.parseInt(input[i]) >= i){
				System.out.print(input[i]);
			} else {
				System.out.print("0");
			}
			//add space except for last item
			if (i != input.length-1){
				System.out.print(" ");
			}
		}
		
		
		scan.close();

	}

}
