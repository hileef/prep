package core;

import java.net.ServerSocket;

public class Loan extends Service {

	public Loan(Store store, ServerSocket servSocket) {
		super(store, servSocket);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Loan service start");
	}

}
