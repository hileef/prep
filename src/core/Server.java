package core;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	
	private ServerSocket servSocket;
	private Class<? extends Service> serviceType;
	private Store myStore;
	
	public Server(ServerSocket servSocket, Class<? extends Service> serviceType, Store myStore) {
		this.servSocket = servSocket;
		this.serviceType = serviceType;
		this.myStore = myStore;
	}

	@Override
	public void run() {
		
		while(true)
		{
				Socket clientSocket;
				try {
					
					clientSocket = servSocket.accept();
					Transmission t = new Transmission(clientSocket);
					serviceType.getConstructors()[0].newInstance(myStore,t);
					System.out.println("Client "+clientSocket.getInetAddress()+" connected on "+serviceType.getName()+" service");
					
				} catch (IOException e) {					
					e.printStackTrace();
				} catch (IllegalArgumentException e) {		
					e.printStackTrace();
				} catch (SecurityException e) {					
					e.printStackTrace();
				} catch (InstantiationException e) {					
					e.printStackTrace();
				} catch (IllegalAccessException e) {					
					e.printStackTrace();
				} catch (InvocationTargetException e) {					
					e.printStackTrace();
				}			
		}		
	}

}
