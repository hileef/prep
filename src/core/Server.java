package core;

import java.net.ServerSocket;

public class Server implements Runnable {
	public Server(ServerSocket servSocket, Class<? extends Service> serviceType, Store myStore) {
		this.servSocket = servSocket;
		this.serviceType = serviceType;
		this.myStore = myStore;
	}

	@Override
	public void run() {
		
		while(true)
		{
			//new Thread(serviceType.newInstance()).start();
		}		
	}
	private ServerSocket servSocket;
	private Class<? extends Service> serviceType;
	private Store myStore;

}
