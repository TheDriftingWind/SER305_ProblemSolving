package practice1;

public class MutableInt {
	int mutable_int;
	
	public MutableInt(int i){
		mutable_int = i;
	}
	
	public void set(int new_int){
		mutable_int = new_int;
	}
	
	public int get(){
		return mutable_int;
	}
}
