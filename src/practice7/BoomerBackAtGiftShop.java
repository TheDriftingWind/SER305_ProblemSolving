package practice7;

import java.util.Scanner;

public class BoomerBackAtGiftShop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numLine = scan.nextInt();
		
		for(int i = 0; i < numLine; i++){
			int numItems = scan.nextInt();
			//store parallel arrays for the items and their prices for checking
			float[] itemPrices = new float[numItems];
			int[] itemCount = new int[numItems];
			//populate arrays
			for(int j = 0; j < numItems; j++){
				itemCount[j] = scan.nextInt();
				itemPrices[j] = scan.nextFloat();
			}
			//find the lowest price
			float lowestPrice = itemPrices[0];
			int lowestPriceItem = 0;
			for(int k = 0; k < numItems; k++){
				if(itemPrices[k] < lowestPrice){
					lowestPrice = itemPrices[k];
					lowestPriceItem = k;
				}
			}
			//buy stuff
			float budget = scan.nextFloat();
			int numItemsBought = 0;
			while(budget > 0){
				//if you can buy the lowest price item... buy it
				if(budget >= itemPrices[lowestPriceItem] && itemCount[lowestPriceItem] > 0){
					budget -= itemPrices[lowestPriceItem];
					itemCount[lowestPriceItem] -= 1;
					numItemsBought += 1;
				}
				//if you can buy the lowest price item... but there's no more, find the next lowest price
				else if(budget >= itemPrices[lowestPriceItem] && itemCount[lowestPriceItem] == 0){
					itemPrices[lowestPriceItem] = -1; //set to -1 to not get this as the lowest price item - this way accounts for items the same price
					//set the lowestPrice to the first number that you find not equal to -1
					for(int x = 0; x < numItems; x++){
						if(itemPrices[x] != -1){
							lowestPrice = itemPrices[x];
							lowestPriceItem = x;
							break;
						}
						
					}
					
					//find/validate the next lowest price
					for(int k = 0; k < numItems; k++){
						//find a number not equal to -1(The price we already expended and discarded)
						if(itemPrices[k] != -1 && itemPrices[k] < lowestPrice){
							//
							lowestPrice = itemPrices[k];
							lowestPriceItem = k;
						}
					}
				}else{
					//else you can't buy the lowest price item... you can't buy anything else
					budget = 0;
				}
			}
			System.out.println(numItemsBought);
			
		}
		
		scan.close();

	}

}
/*
 * Time Complexity: O(n) where n is the number of individual items
 * The maximum number of iterations that the algorithm needs to run is when Boomer has enough
 * money to buy every single individual item available.
 */

/*
 * Space Complexity: O(n) where n is the number of different items
 * The algorithm uses 2 parallel arrays to store information about the item's price and stock.
 * This makes it O(2n) which is O(n).
 * In addition, a constant of integers variables are also used
 */

/*
 * Pseudo Code:
 * 1.)Find the prices and quantities for each of the items and your budget
 * 2.)Find the cheapest item
 * 3.)Until you run out of money or you can't buy anymore...
 * 		if you have enough money to buy the cheapest item, buy the cheapest item
 * 		if you have enough money to buy the cheapest item but it's out of stock,
 * 			find the next cheapest item
 * 		if you don't have enough money to buy the cheapest item that's not out of stock, you're done buying
 * 4.)Print the number of items you bought
 */