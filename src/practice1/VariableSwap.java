package practice1;

public class VariableSwap {

	static void main(String[] args){
		MutableInt a = new MutableInt(5);
		MutableInt b = new MutableInt(7);
		swap(a,b);
		System.out.println(a.get() + " " + b.get());
		
	}
	
	
	public static void swap(MutableInt a, MutableInt b){
		a.set(a.get()+b.get());
		b.set(a.get()-b.get());
		a.set(a.get()-b.get());
	}
}
