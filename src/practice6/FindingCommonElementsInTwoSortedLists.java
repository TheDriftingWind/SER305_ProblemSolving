package practice6;

import java.util.Scanner;

public class FindingCommonElementsInTwoSortedLists {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] list_m = scan.nextLine().split(" ");
		String[] list_n = scan.nextLine().split(" ");
		
		//start with the first character in list m
		for(int i = 0; i < list_m.length; i++){
			//check against characters from list n until you find a matching number or a larger number
			
			//if you find a matching number, add it to the list of matches
			if(list_m[i] == list_n[placeholder]){
				
			}
			//if you find a larger number, move to the next item in m
			else if(list_m[i] < list_n[placeholder]){
				
			}else{
			//else keep checking the next item in n	
			}
			
		}

	}

}
