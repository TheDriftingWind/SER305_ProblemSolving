package fizzBuzz;

public class FizzBuzz {

	public static void main(String[] args) {
		 
		for(int i = 1; i <= 100; i++){
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
