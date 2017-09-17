package practice3;

import java.util.Scanner;

public class ShiftingArrayElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		int shift = scan.nextInt();
		int[] storage = new int[input.length];
		
		//run through element of the array of inputs
		for(int i = 0; i < input.length; i++){
			//the index to insert the current element in the input is at (currentIndex + length of the array - shift) modulus 5
			int insertAt = (i + input.length - shift) % input.length;
			//insert the element
			storage[insertAt] = Integer.parseInt(input[i]);
		}
		
		//print out the results
		for(int i = 0; i < storage.length; i++){
			System.out.print(storage[i] + " ");
		}
		
		
		
		//
		
		
		scan.close();
	}

}
