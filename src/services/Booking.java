package services;

import java.io.IOException;

import core.Service;
import core.Store;
import core.Transmission;
import core.UnavailableException;

public class Booking extends Service {

	public Booking(Store store, Transmission t) { super(store, t); }

	@Override
	public void run() {
		
		try {
			
			transmission().send("Welcome to the Booking Service !");
			transmission().send(store().listAvailableDocuments());
			
			transmission().send("Please enter the document number : ");
			int document = intFrom(transmission().receive(), -1);
			
			
			transmission().send("Please enter your subscriber number : ");
			int subscriber = intFrom(transmission().receive(), -1);
				
			try {
				store().bookDocument(subscriber, document);
				transmission().send("Your document has been successfully booked.");
			} catch (UnavailableException e) { transmission().send(e.getMessage()); }
			
			transmission().close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
