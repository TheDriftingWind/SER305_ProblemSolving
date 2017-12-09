package practice9;

import java.util.Scanner;

public class BoomersLetterScramble {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		int s = scan.nextInt();
		
		for(int i = 0; i <= s; i++){
			String[] command = scan.nextLine().split(" ");
			switch(command[0]){
				case "swap":
					message = swap(message, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
					break;
				case "rotate":
					message = rotate(message, Integer.parseInt(command[1]));
					break;
				case "reverse":
					message = reverse(message, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
					break;
				case "move":
					message = move(message, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
					break;
			}
		}
		scan.close();
		
		System.out.print(message);
		
	}
	
	private static String swap(String s, int i, int j){
		//make temp to store i, set i = j, set j = temp
		char[] string = s.toCharArray();
		char temp = string[i];
		string[i] = string[j];
		string[j] = temp;
		return new String(string);
	}
	
	private static String rotate(String s, int k){
		String newString = s;
		//rotate left or right by 1 for k amount of times
		if(k > 0){
			for(int i = 0; i < k; i++){
				newString = rotateLeft(newString);
			}
		}
		else if(k < 0){
			for(int i = 0; i < Math.abs(k); i++){
				newString = rotateRight(newString);
			}
		}

		return newString ;
	}
	
	private static String rotateLeft(String s){
		//rotates left by 1
		char temp;
		int size = s.length();
		char[] arr = s.toCharArray();
        temp = arr[0];
        for (int i = 0; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[size-1] = temp;
		return new String(arr);
		
	}

	private static String rotateRight(String s){
		//rotates right by 1
		char temp;
		int size = s.length();
		char[] arr = s.toCharArray();
        temp = arr[size-1];
        for (int i = size-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
		return new String(arr);
		
	}
	
	private static String reverse(String s, int i, int j){
		char[] newSubString = new char[j-i+1];
		char[] subString = s.substring(i, j+1).toCharArray();
		//take substring and reverse it
		for(int x = subString.length-1; x >= 0; x--){
			newSubString[x] = subString[subString.length-1 - x];
		}
		//insert into old string to make new one
		char[] newString = s.toCharArray();
		for(int y = 0; y <= newSubString.length-1; y++){
			newString[i+y] =  newSubString[y];
		}
		return new String(newString);
	}
	
	private static String move(String s, int i, int j){
		char[] string = s.toCharArray();
		//swap with character to the left
		if(j-i > 0){
			for(int x = 0; x < (j-i); x++){
				char temp = string[i+x+1]; 
				string[i+x+1] = string[i+x];
				string[i+x] = temp;
			}
		//swap with character to the right
		}else if(j-i < 0){
			for(int x = 0; x < (i-j); x++){
				char temp = string[i-x-1]; 
				string[i-x+-1] = string[i-x];
				string[i-x] = temp;
			}
		}
		return new String(string);
	}

}

/*
 * Time Complexity: O(n*(k*s)) where n is the number of instructions, k is the longest rotation, and s is the length of the message string
 * 
 * The most potentially time consuming part of this program is the rotation method. In the worst case, the program will do nothing
 * but rotations. The amount of time a rotation takes is equal to the number of times it has to rotation times the amount of time
 * it takes to make a single rotation(left or right by 1). The amount of time it takes to make a single rotation(left or right) is
 * equal to the length of the string as the method makes 1 iteration through the string to make the rotation. Thus, the time complexity
 * of the rotate method is O(k*s). So, in the worst case, the most amount of time it would take to run this program is equal to the number
 * of instructions there are(n) times the amount of time it takes to perform a rotation(k*s)
 * Thus, O(n*(k*s)) 
 * 
 */

/*
 * Space Complexity: O(n) where n is the length of the message string
 * The portion of the program that takes up the most memory are the arrays used to store the message string or a substring of it.
 * Since methods use temporary variables, and always use a constant number of arrays to store a temporary string or substring of
 * the message, the most space used at any given time is proportional to the length of the message times a constant.
 * Any constant times the length of the message would yield a space complexity of O(n) where n is the length of the message string.
 */
