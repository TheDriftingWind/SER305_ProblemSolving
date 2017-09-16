package fizzBuzz;
import java.util.Scanner;
//test
public class FizzBuzzSeveralInts {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int in_NumberOfInts = scan.nextInt(); 
		
		for(int i = 0; i < in_NumberOfInts; i++){
			int next = scan.nextInt();
			FizzBuzzMethod(next);
		}
		
		scan.close();
		
	}
	
	public static void FizzBuzzMethod(int Max){
		for(int i = 1; i <= Max; i++){
			if( (i%3 == 0) || (i%5 == 0)){
				String result = "";
				if (i%3 == 0){
					result += "Fizz";
				}
				if (i%5 == 0){
					result += "Buzz";
				}
				System.out.println(result);
			}else{
				System.out.println(i);;
			}
		}
	}
	
}
