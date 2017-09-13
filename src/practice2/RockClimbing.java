package practice2;
import java.util.Scanner;

public class RockClimbing {
	
	/*
	 * 1. initialize currentHeight as 0
	 * 2. read the next input to get how many lines to expect
	 * 3. read the next line and get the nextTrip
	 * 4. split nextTrip by its spaces to get each individual climb
	 * 6. read each climb as nextClimb
	 * 5. if the nextClimb is negative and greater than the currentHeight...
	 * 		set currentHeight to 0
	 * 6. if the nextClimb is negative and less than currentHeight
	 * 		add nextClimb(-) to currentHeight 
	 * 7. if the nextClimb is positive
	 * 		add nextClimb to Total
	 * 		add nextClimb to currentHeight
	 * 		
	 */
	
	public static void main(String[] args) {
		int currentHeight = 0;
		int Highest = 0;
		int Total = 0;
		int numInputs;
		
		Scanner scan = new Scanner(System.in);
		
		numInputs = scan.nextInt();
		//System.out.println("numI: " + numInputs);
		scan.nextLine();
		for(int i = 0; i < numInputs; i++){
			String[] array = scan.nextLine().split(" ");
			
			for(int j = 0; j < array.length; j++){
				
				//System.out.println("currentHeight: " + currentHeight);
				//System.out.println("Index("+j+")" + array[j]);
				
				if(Integer.parseInt(array[j]) < 0 && Math.abs(Integer.parseInt(array[j])) >= currentHeight){
					currentHeight = 0;
				}
				else if(Integer.parseInt(array[j]) < 0 && Math.abs(Integer.parseInt(array[j])) < currentHeight){
					currentHeight = currentHeight + Integer.parseInt(array[j]);
				}
				else if(Integer.parseInt(array[j]) >= 0 ){
					Total = Total + Integer.parseInt(array[j]);
					currentHeight = currentHeight + Integer.parseInt(array[j]);
				}
				
				if( currentHeight > Highest){
					Highest = currentHeight;
				}
			}
			
			System.out.println(Highest + " " + currentHeight + " " + Total);
			Highest = 0;
			Total = 0;
			currentHeight = 0;
		}
		
		
		scan.close();
	
	}

}
