package practice9;

import java.util.Scanner;

public class ReachingBottomRightCellOfATable {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int matrix[][] = new int[x][y];
		//special case
		if(x == 1 || y == 1){
			//System.out.print("1");
		}
		//populate matrix with the number of paths to reach the cell
		//for row 0 and column 0, path only 1 possible path
		for (int i = 0; i < x; i++){
            		matrix[i][0] = 1;
		}
		
		for (int j = 0; j < y; j++){
			matrix[0][j] = 1;
		}
		
		//calculate the cell of the matrix based cell above and to the left of the current cell
		for(int a = 1; a < x; a++){
			for(int b = 1; b < y; b++){
				/*the number of paths there are to check to that cell of a table is equal to the sum of the
				 * number of times there are to get to the cell above and to the left of it
				 */
				matrix[a][b] = matrix[a-1][b] + matrix[a][b-1];
			}
		}
		
		System.out.print(matrix[x-1][y-1]);
	}

}

/*
 * Time Complexity: O(n*m) where n is width of the table and m is the height of the table
 * 
 * The most time consuming portion of the algorithm is the part that creates the matrix of values that
 * represent the number of paths there are to get to the bottom right cell of a table of a certain size.
 * The number of times the algorithm iterates through the matrix(2-dimensional array) depends on the size of
 * the matrix itself.
 * The algorithm only goes makes calculations and insertions into each cell of the matrix only once.
 * The algorithm inserts the first row and column of the matrix and iterates through the remainder of the matrix
 * once. For each cell is always makes a constant number of checks(2 checks: 1 for the cell above and 1 for the cell to the left).
 * Thus, the time the algorithm takes to run is proportional the size of the matrix which is dependant on how many rows and columns there are.
 * Thus, the algorithm is in O(n*m)
 */

/*
 * Space Complexity: O(n*m) where n is the width of the table and m is the height of the table
 * 
 * The portion of the algorithm that uses the most amount of the is the matrix used to store the values that
 * represent the number of paths there are to get to the bottom right cell of a table of a certain size.
 * The size of this matrix depends on the size of the table as they are parallel. Since the matrix is representing
 * the table, the amount of space that this algorithm uses is proportional to the number of rows of the table(m) times
 * the number of columns(n).
 * Thus, O(n*m)
 */
