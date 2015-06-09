package mcode.javainterview.designpattern;

public class SingletonClassExample {
	
	private static final SingletonClassExample INSTANCE = new SingletonClassExample();
	
	private SingletonClassExample() {
	}
	
	public static SingletonClassExample getInstance() {
		return INSTANCE;
	}
}
