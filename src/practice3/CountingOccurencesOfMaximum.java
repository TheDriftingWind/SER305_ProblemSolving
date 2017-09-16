package practice3;

import java.util.Scanner;

public class CountingOccurencesOfMaximum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] input = scan.nextLine().split(" ");
		int max = 0;
		int count = 0;
		
		for(int i = 0; i < input.length; i++){
			//if you find a new max, reset count to 1
			if( Integer.parseInt(input[i]) > max){
				max = Integer.parseInt(input[i]);
				count = 1;
			}
			//if you don't find a new max, count when you find another number equal to it
			else if( Integer.parseInt(input[i]) == max){
				count++;
			}
		}
		
		System.out.println(count);
		
		scan.close();
	}

}
