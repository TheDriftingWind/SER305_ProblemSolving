package practice9;

import java.util.Scanner;

public class NumberOfWaysToObtainAScore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		String[] scores = scan.nextLine().split(" ");
		
		
		int[] matrix = new int[num+1];
		matrix[0] = 1;
		
		for(int i = 0; i < scores.length; i++){
			for(int j = Integer.parseInt(scores[i]); j<= num; j++){
				matrix[j] += matrix[j-Integer.parseInt(scores[i])];
			}
		}
		System.out.println(matrix[num]);
	}

}
