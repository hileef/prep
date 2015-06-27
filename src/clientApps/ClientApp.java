package clientApps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public abstract class ClientApp {
	
	public abstract int port();
	
	public void work() throws IOException {
		Socket s = new Socket("127.0.0.1", port());
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Server # " + in.readLine());
			while(in.ready()) System.out.println("Server # " + in.readLine());
			out.println(sc.nextLine());
			if(s.isClosed()) break;
			//System.out.println(s.isConnected());
		}
		s.close();
		sc.close();
		in.close();
		out.close();
	}
	

}
