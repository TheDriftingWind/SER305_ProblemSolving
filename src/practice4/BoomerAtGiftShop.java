package practice4;

import java.util.Scanner;

public class BoomerAtGiftShop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numLines = scan.nextInt();
		
		for(int i = 0; i < numLines; i++){
			
			int numPairs = scan.nextInt();
			double cost = 0;
			
			for(int j = 0; j < numPairs; j++){
				int numItems = scan.nextInt();
				double unitPrice = scan.nextDouble();
				cost = cost + (numItems*unitPrice);
			}
			double budget = scan.nextDouble();
			
			System.out.println(compare(cost, budget));
		}
		
		scan.close();

	}
	
	public static String compare(double price, double budget){
		String result= "";
		
		if(Math.abs(price-budget) <= 0.000001 ){
			result = "BOOMER HAS THE EXACT AMOUNT HE NEEDS";
		}
		else if(price > budget){
			result = "BOOMER NEEDS MORE MONEY";
		}
		else if(price < budget){
			result = "BOOMER HAS MORE THAN ENOUGH";
		}
		
		return result;

	}

}
