package core;

public interface Document {
	public int number();
	public void book(Subscriber s) throws UnavailableException ;
	public void borrow(Subscriber s) throws UnavailableException ;
	public void giveBack(Subscriber s) ;
}
