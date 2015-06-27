package core;

public class Booking extends Service {

	public Booking(Store store, Transmission t) { super(store, t); }

	@Override
	public void action(Integer subscriber, Integer document) throws UnavailableException {
		store().bookDocument(subscriber, document);
	}

	@Override
	public String greeting() {
		return "Welcome to the Booking Service ! Please enter your subscriber number,"
				+ " enter, then the document number, then enter.";
	}

	@Override
	public String success() {
		return "Your document has been successfully booked. :)";
	}

}
