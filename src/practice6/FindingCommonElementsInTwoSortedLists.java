package practice6;

import java.util.ArrayList;
import java.util.Scanner;

public class FindingCommonElementsInTwoSortedLists {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] list_m = scan.nextLine().split(" ");
		String[] list_n = scan.nextLine().split(" ");
		int pointer_i = 0; //incrementing pointer for list m
		int pointer_c = 0; //checking pointer
		int last_num = Integer.parseInt(list_m[0]);
		ArrayList<Integer> matches = new ArrayList<Integer>();
		
		//start with the first character in list m
		while(pointer_i < list_m.length-1){
			//check against characters from list n until you find a matching number or a larger number
			
			//if you find a matching number, add it to the list of matches
			if(Integer.parseInt(list_m[pointer_i]) == Integer.parseInt(list_n[pointer_c])){
				matches.add(Integer.parseInt(list_m[pointer_i]));
				while(Integer.parseInt(list_m[pointer_i]) == last_num && pointer_i < list_m.length-1){
					pointer_i++; //find the next new number
				}
				last_num = Integer.parseInt(list_m[pointer_i]);
			}
			//if you find a larger number, move to the next item in m
			else if(Integer.parseInt(list_m[pointer_i]) < Integer.parseInt(list_n[pointer_c])){
				while(Integer.parseInt(list_m[pointer_i]) == last_num && pointer_i < list_m.length-1){
					pointer_i++; //find the next new number
				}
				last_num = Integer.parseInt(list_m[pointer_i]);
			}else{
			//else keep checking the next item in n
				pointer_c++;
			}
		}
		
		//You never move the pointers back, or double check. You only iterate through each list once
		for(int j = 0; j < matches.size(); j++){
			System.out.print(matches.get(j));
			if(j != matches.size()-1){
				System.out.print(" ");
			}
		}

	}

}
