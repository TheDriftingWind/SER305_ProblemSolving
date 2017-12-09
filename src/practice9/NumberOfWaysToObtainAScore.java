package practice9;

import java.util.Scanner;

public class NumberOfWaysToObtainAScore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		String[] scores = scan.nextLine().split(" ");
		
		
		int[] matrix = new int[num+1];
		//initialize, the number of ways to make change of 0 is 1
		matrix[0] = 1;
		
		//Calculate the number of ways to make each number up to the desired number
		for(int i = 0; i < scores.length; i++){
			for(int j = Integer.parseInt(scores[i]); j<= num; j++){
				/*the value of a cell in the matrix is equal to the number of 
				 *ways to reach score j plus number of ways to reach score j-another score
				 */
				matrix[j] += matrix[j-Integer.parseInt(scores[i])];
			}
		}
		System.out.println(matrix[num]);
	}

}

/*
 * Time Complexity: O(m*n) where m is the number of scores and n is the value of the target score
 * 
 * The algorithm contains a nested loop that is the most time consuming portion of the algorithm.
 * In the worst case, the inner loop needs to run n times(the value of the target score).
 * This is because the amount of times the inner loop runs is equal to the difference between
 * the target score and the smallest score. In the worst case, the smallest score is 1 making the
 * loop run n times(the value of the target score)
 * The number of times the outer loop runs is equal to the number of scores there are, defined as m.
 * Thus, the number of times the algorithm runs in the worst case is the number of times the inner loop runs(n)
 * times the number of times the outer loop runs(m). Thus O(m*n)
 * 
 */

/*
 * Space Complexity: O(n+m) where n is the number of scores there are and m is the value of the target number
 * 
 * The most memory demanding portion of the algorithm are the arrays that the algorithm uses to store the scores and
 * the values representing how many ways there are to make up a certain score.
 * The size of the scores array(use to store the different scores) is equal to the number of scores entered(n)
 * The size of the array used to store the number of ways to make a certain score is proportional to the value of the target number(m)
 * Thus, the space complexity is O(n+m)
 * 
 */