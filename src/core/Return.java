package core;

import java.net.ServerSocket;

public class Return extends Service {

	public Return(Store store, ServerSocket servSocket) {
		super(store, servSocket);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Return service start");
	}

}
