package practice6;

import java.util.Scanner;

public class AnotherSortingApproach {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int range = scan.nextInt();
		scan.nextLine();
		String[] integers = scan.nextLine().split(" ");
		scan.close();
		//Create an array c with k integers, each initialized to 0
		int[] c = new int[range];
		//Create an array out of size n to store the output
		int[] out = new int[integers.length];
		/*
		 * Iterate through the input values (i.e., go over all n input values) and count the number of times each
		 * value i between 0 and k occurs; store the count for each value i at c[i]
		 */
		for(int i = 0; i < integers.length; i++){
			c[Integer.parseInt(integers[i])] += 1;
		}
		//Update c, so that c[i] now represents the number of values in the input smaller than or equal to i
		for(int j = 1; j < c.length; j++){
			c[j] = c[j] + c[j-1];
		}
		/* Iterate through the input values backwards (from last to the first) and place each input value at a
		 * position (index) in the out array based on how many values are less than or equal to that value
		 */
		for(int k = integers.length-1; k >= 0; k--){
			int input_val = Integer.parseInt(integers[k]);
			out[ (c[input_val]-1) ] = input_val;
			c[ Integer.parseInt(integers[k]) ]--;
		}
		
		//Print out the output
		String result = "";
		for(int z = 0; z < out.length; z++){
			result = result + " " + out[z];
		}
		result = result.substring(1);
		System.out.print(result);
	}

}
