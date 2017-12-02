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
		//for row 0, path only possible path
		for (int i = 0; i < x; i++){
            matrix[i][0] = 1;
		}
		
		for (int j = 0; j < y; j++){
			matrix[0][j] = 1;
		}
		
		for(int a = 1; a < x; a++){
			for(int b = 1; b < y; b++){
				matrix[a][b] = matrix[a-1][b] + matrix[a][b-1];
			}
		}
		
		System.out.print(matrix[x-1][y-1]);
	}

}
