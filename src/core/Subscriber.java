package core;

public class Subscriber {
	
	private int number;
	private String name;
	private int age;

	public Subscriber(int number, String name, int age) {
		this.number = number;
		this.name = name;
		this.age = age;
	}
	
	public int number() { return number; }
	public int age() { return age; }
	public String name() { return name; }
	
}
