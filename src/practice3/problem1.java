package practice3;

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int partition = scan.nextInt();
		
		scan.nextLine(); //end the line
		
		String[] input = scan.nextLine().split(" ");

		//initialize pointer starting indexes
		int leftPointer = 0;
		int rightPointer = input.length-1;
		
		//while left and right pointers have not past each other...
		while(leftPointer < rightPointer){
			if( Integer.parseInt(input[rightPointer]) <= partition && Integer.parseInt(input[leftPointer]) > partition ){
				String c = input[rightPointer];
				input[rightPointer] = input[leftPointer];
				input[leftPointer] = c;
				rightPointer--;
				//swap(input[rightPointer], input[leftPointer]);	
			}
			leftPointer++;
			
		}
		
		for(int i = 0; i < input.length; i++){
			
			System.out.print(input[i] + " ");
			
		}
		
		scan.close();

	}
	
//	public static void swap(String a, String b){
//		String c = a;
//		a = b;
//		b = c;
//	}

}
