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
	
	public Transmission(Socket clientSocket) throws IOException
	{	
		this.clientSocket = clientSocket;
		this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		this.out = new PrintWriter(clientSocket.getOutputStream(),true);
	}	
	public void sendToClient(String s)
	{
		out.println(s);
	}
	public String recvFromClient() throws IOException
	{
		return in.readLine();
	}
	public void closeConnection() throws IOException
	{
		out.println("Connection closed from server");
		clientSocket.close();
		in.close();
		out.close();
	}
	public boolean clientStillAlive()
	{
		return clientSocket.isConnected();
	}
}
