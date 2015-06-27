package apps;

import java.io.IOException;

import apps.BaseClient;

public class ReturningApp extends BaseClient {

	@Override
	public int port() { return 2700 ; }
	public static void main(String[] args) throws IOException { (new ReturningApp()).work(); }

}
