package core;

import java.net.ServerSocket;

public abstract class Service implements Runnable {

	public Service(Store store, ServerSocket servSocket) {
		this.myStore = store;
		this.servSocket = servSocket;
	}
	
	@Override
	public abstract void run();
	public Store getMyStore() {
		return myStore;
	}
	public ServerSocket getServSocket() {
		return servSocket;
	}
	private Store myStore;
	private ServerSocket servSocket;

}
