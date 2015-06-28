package documents;

import core.Subscriber;
import core.UnavailableException;

public class DVD extends ADocument {

	private int age;
	private boolean restricted;
	
	public DVD(int number, String title) { super(number, title); this.restricted = false; } 
	
	public DVD(int number, String title, int ageMin) {
		super(number, title); this.age = ageMin; this.restricted = true;
	}
	
	@Override
	protected void checkBorrowingAndBookingPreconditions(Subscriber s) throws UnavailableException {
		if(restricted && s.age() < age) throw new UnavailableException("Subscriber needs to be at least " + age + " years old.");
		super.checkBorrowingAndBookingPreconditions(s);
	}
	
	@Override
	public String toString() {
		return "DVD [" + super.toString() + "]";
	}

}
