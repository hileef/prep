package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Transmission {
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;

	public Transmission(Socket clientSocket) throws IOException {
		this.clientSocket = clientSocket;
		this.in = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));
		this.out = new PrintWriter(clientSocket.getOutputStream(), true);
	}

	public void send(String s) throws IOException {
		if (isActive()) out.println(s);
		else close();
	}

	public String receive() throws IOException {
		if (isActive()) { out.println("#-REQUEST"); return in.readLine(); }
		else close(); throw new IOException("Connection is closed...");
	}

	public void close() throws IOException {
		out.println("Connection closed from server");
		out.println("#-CLOSE");
		clientSocket.close(); in.close(); out.close();
	}
	
	public int getListeningPort() { return this.clientSocket.getPort(); }
	public boolean isActive() { return clientSocket.isConnected(); }
}
