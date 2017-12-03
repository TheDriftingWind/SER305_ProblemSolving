package practice9;

import java.util.Scanner;

public class BoomersLetterScramble {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		int s = scan.nextInt();
		
		for(int i = 0; i < s; i++){
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
			System.out.println(message);
		}
		
		System.out.println("final: " + message);
		
	}
	
	private static String swap(String s, int i, int j){
		char[] string = s.toCharArray();
		char temp = string[i];
		string[i] = string[j];
		string[j] = temp;
		return new String(string);
	}
	
	private static String rotate(String s, int k){
		char[] string = s.toCharArray();
		char[] newString = new char[string.length];
		for(int i = 0; i < string.length; i++){
			int insertAt = (i + string.length - k) % string.length;
			newString[insertAt] = string[i];
		}
		return new String(newString);
	}
	
	private static String reverse(String s, int i, int j){
		char[] string = s.toCharArray();
		char[] subString = new char[j-i];
		for(int a = 0; a < (j-i); a++){
			subString[a] = string[i+a];
		}
		for(int b = 0; b < subString.length; b++){
			string[subString.length-1 + b] = subString[subString.length-1 - b];
		}
		return new String(string);
	}
	
	private static String move(String s, int i, int j){
		char[] string = s.toCharArray();
		if(j-i > 0){
			for(int x = 0; x < (j-i); x++){
				char temp = string[i+x+1]; 
				string[i+x+1] = string[i+x];
				string[i+x] = temp;
			}
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
