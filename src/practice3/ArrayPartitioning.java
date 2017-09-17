package practice3;

import java.util.Scanner;

public class ArrayPartitioning {

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
			//if the rightPointer is less than the partition and the leftPointer is greater than the partition...
			if( Integer.parseInt(input[rightPointer]) <= partition && Integer.parseInt(input[leftPointer]) > partition ){
				//swap them
				String c = input[rightPointer];
				input[rightPointer] = input[leftPointer];
				input[leftPointer] = c;
				//move the rightPointer back if you swap
				
			}
			//If the leftPointer is a number that is smaller or equal to the partition, it's in the right place - move on
			if(Integer.parseInt(input[leftPointer]) <= partition){
				leftPointer++;
			}
			//If the rightPointer finds a number that is large than the partition, it's in the right place - move on
			if(Integer.parseInt(input[rightPointer]) > partition){
				rightPointer--;
			}
				
		}
		//System.out.println("Partition: " + partition);
		
		for(int i = 0; i < input.length; i++){
			
			System.out.print(input[i] + " ");
			
		}
		
		scan.close();

	}


}
