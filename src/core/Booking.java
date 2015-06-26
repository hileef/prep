package core;

public class Booking extends Service {

	public Booking(Store store, Transmission t) { super(store, t); }

	@Override
	public void action(Integer subscriber, Integer document) throws UnavailableException {
		store().bookDocument(subscriber, document);
	}

}
