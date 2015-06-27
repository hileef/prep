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
	public void sendToClient(String s) throws IOException
	{
		if(clientStillAlive())
			out.println(s);
		else
			closeConnection();
	}
	public String recvFromClient() throws IOException 
	{
		if(clientStillAlive())
			return in.readLine();
		else
		{
			closeConnection();
			return null;
		}
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
