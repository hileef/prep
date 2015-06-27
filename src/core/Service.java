package core;

import java.io.IOException;

public abstract class Service implements Runnable {

	private Store store;
	private Transmission transmission;

	public Service(Store store, Transmission t) {
		this.store = store;
		this.transmission = t;
		(new Thread(this)).start();
	}

	protected Store store() { return store; }
	
	private int intFrom(String s, int opt) {
		try { return Integer.parseInt(s); }
		catch(NumberFormatException e) { return opt; }
	}

	@Override
	public void run() {
		
		try {
			
			transmission.send(greeting() + "\n" + "Please enter your subscriber number : ");
			int subscriber = intFrom(transmission.receive(), -1);
			transmission.send("Please enter the document number : ");
			int document = intFrom(transmission.receive(), -1);
				
			try { action(subscriber, document); transmission.send(success()); }
			catch (UnavailableException e) { transmission.send(e.getMessage()); }
			
			transmission.close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	public abstract void action(Integer subscriber, Integer document)
			throws UnavailableException;
	
	public abstract String greeting();
	public abstract String success();

}
