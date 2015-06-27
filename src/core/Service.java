package core;


public abstract class Service implements Runnable {

	private Store store;
	private Transmission transmission;

	public Service(Store store, Transmission t) {
		System.out.println("Service "+ this.getClass().getName() + 
				" started on Port "+t.getListeningPort());
		this.store = store;
		this.transmission = t;
		(new Thread(this)).start();
	}

	protected Store store() { return store; }
	protected Transmission transmission() { return transmission; }
	
	protected int intFrom(String s, int opt) {
		try { return Integer.parseInt(s); }
		catch(NumberFormatException e) { return opt; }
	}

	@Override
	public abstract void run() ;

}
