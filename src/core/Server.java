package core;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	
	private ServerSocket servSocket;
	private Class<? extends Service> serviceType;
	private Store myStore;
	
	public Server(int port, Class<? extends Service> serviceType, Store myStore) {
		try { this.servSocket = new ServerSocket(port); }
		catch (Exception e) { e.printStackTrace(); }
		this.serviceType = serviceType;
		this.myStore = myStore;
	}

	@Override
	public void run() {
		
		System.out.println(serviceType.getName() +" SERVER now [active] on port " + servSocket.getLocalPort());
		while(true) {
				Socket clientSocket;
				try {
					clientSocket = servSocket.accept();
					Transmission t = new Transmission(clientSocket);
					serviceType.getConstructors()[0].newInstance(myStore,t);
					System.out.println("Client "+clientSocket.getInetAddress()+" connected on "+serviceType.getName()+" service");
				} catch (Exception e) { e.printStackTrace(); }		
		}		
	}

}
