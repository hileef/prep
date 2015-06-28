package apps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public abstract class BaseClient {
	
	public abstract int port();
	
	public void work() throws IOException {
		String srv = "";
		Socket s = new Socket("127.0.0.1", port());
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		while(true) {
			while(!(srv = in.readLine()).equals("#-REQUEST") && !srv.equals("#-CLOSE"))
				System.out.println("Server # " + srv);
			if(srv.equals("#-CLOSE")) break;
			out.println(sc.nextLine());
		}
		s.close();
		sc.close();
		in.close();
		out.close();
	}
	

}
