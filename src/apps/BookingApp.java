package apps;

import java.io.IOException;

import apps.BaseClient;

public class BookingApp extends BaseClient {

	@Override
	public int port() { return 2500 ; }
	public static void main(String[] args) throws IOException { (new BookingApp()).work(); }

}
