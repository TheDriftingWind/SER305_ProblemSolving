package practice1;
import java.util.Scanner;

public class ReverseInt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String reversedString = "";
		//take the string and start at the last character
		//check if the last character is a 0, if so, ignore it 
		if(input.charAt(input.length()-1) != '0'){
			reversedString += input.charAt(input.length()-1);
		}
		//start at the next character from the end
		for (int i = input.length()-2; i >= 0; i--){
			//add each character from end to beginning
			reversedString = reversedString += input.charAt(i);
		}
		
		System.out.println(reversedString);
		
		scan.close();

	}

}
