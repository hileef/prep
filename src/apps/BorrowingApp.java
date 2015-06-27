package apps;

import java.io.IOException;

import apps.BaseClient;

public class BorrowingApp extends BaseClient {

	@Override
	public int port() { return 2600 ; }
	public static void main(String[] args) throws IOException { (new BorrowingApp()).work(); }

}
