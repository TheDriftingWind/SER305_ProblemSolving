package practice1;

public class VariableSwapA {
	
	public static void swap(MutableInt a, MutableInt b) {
		MutableInt c = new MutableInt(a.get());
		a.set(b.get());
		b.set(c.get());
		
	}
	
	public static void main(String[] args){
		MutableInt a = new MutableInt(5);
		MutableInt b = new MutableInt(7);
		swap(a,b);
		
		System.out.println(a.get() + " " + b.get());
	}

	
	
}
