package clientApps;

import java.io.IOException;

public class BorrowApp extends ClientApp {

	@Override
	public int port() { return 2500 ; }
	public static void main(String[] args) throws IOException { (new BookApp()).work(); }

}
