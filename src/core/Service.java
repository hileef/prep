package core;

public abstract class Service implements Runnable {

	private Store myStore;
	private Transmission transmission;
	
	public Service(Store store, Transmission t) {
		this.myStore = store;
		this.transmission = t;
		(new Thread(this)).start();
	}
	
	@Override
	public abstract void run();
	
	public Transmission transmission() {
		return transmission;
	}
	
	public Store store() {
		return myStore;
	}
	
	

}
