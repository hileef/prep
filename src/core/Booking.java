package core;

import java.net.ServerSocket;

public class Booking extends Service {


	public Booking(Store store, ServerSocket servSocket) {
		super(store, servSocket);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Booking Service start");
		
	}

}
