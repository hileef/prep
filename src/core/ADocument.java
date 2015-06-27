package core;

public abstract class ADocument implements Document {
	
	private int number;
	private boolean booked;
	private boolean available;
	private Subscriber subscriber;
	
	public ADocument(int number) {
		this.number = number;
		this.available = true;
		this.booked = false;
		this.subscriber = null;
	}
	
	private void checkAvailability() throws UnavailableException { 
		if(!available) throw new UnavailableException("Document unavaible");
	}
	
	private void checkBooking(Subscriber s) throws UnavailableException{ 
		if(booked)
		{
			if(subscriber != s)
			{
				throw new UnavailableException("Document already booked");
			}
		}
	}
	
	@Override
	public int number() { return number; }

	@Override
	public void book(Subscriber s) throws UnavailableException{
		checkAvailability();
		checkBooking(s);
		this.subscriber = s;
		this.booked = true;
		// handle timer
	}

	@Override
	public void borrow(Subscriber s) throws UnavailableException{
		checkAvailability();
		checkBooking(s);
		this.subscriber = s;
		this.available = true;
		// handle timer
	}

	@Override
	public void giveBack(Subscriber s) {
		this.available = true;
		this.booked = false;
		this.subscriber = null;
	}

}
