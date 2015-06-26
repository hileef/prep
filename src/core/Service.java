package core;

public abstract class Service implements Runnable {

	private Store store;
	private Transmission transmission;
	
	public Service(Store store, Transmission t) {
		this.store = store;
		this.transmission = t;
		(new Thread(this)).start();
	}
	
	protected Store store() { return store; }
	
	@Override
	public void run() {
		while(true) {
			
			// receive subscriber number
			// receive document number
			int s = 0;
			int d = 0;
			
			try { action(s, d); break; } catch (UnavailableException e) {
				// push error; try again
			}
		}
		
		// successfully did action
	}
	
	public abstract void action(Integer subscriber, Integer document) throws UnavailableException ;
	
	
	
	
	

}
