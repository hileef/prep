package core;

public abstract class Service implements Runnable {

	public Service(Store store) {
		this.myStore = store;
	}
	
	@Override
	public abstract void run();
	public Store getMyStore() {
		return myStore;
	}
	private Store myStore;
	

}
