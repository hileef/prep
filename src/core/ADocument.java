package core;

public abstract class ADocument implements Document {
	
	private int number;
	private boolean available;
	
	public ADocument(int number) {
		this.number = number;
		this.available = true;
	}
	
	private void checkAvailability() throws UnavailableException { 
		if(!available) throw new UnavailableException("Document is currently unavailable");
	}
	
	@Override
	public int number() { return number; }

	@Override
	public void book(Subscriber s) throws UnavailableException {
		checkAvailability();
		this.available = false;
		// handle timer
	}

	@Override
	public void borrow(Subscriber s) throws UnavailableException {
		checkAvailability();
		this.available = false;
		// handle timer
	}

	@Override
	public void giveBack(Subscriber s) {
		this.available = true;
	}

}
