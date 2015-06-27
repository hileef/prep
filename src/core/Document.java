package core;

public interface Document {
	
	public int number();
	public void book(Subscriber s) throws UnavailableException ;
	public void borrow(Subscriber s) throws UnavailableException ;
	public void giveBack() ;
	
	public String toString() ;
	public boolean isAvailable() ;
	public boolean isBorrowed() ;
	public boolean isBooked() ;
}
