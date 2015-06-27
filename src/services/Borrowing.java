package services;

import java.io.IOException;

import core.Service;
import core.Store;
import core.Transmission;
import core.UnavailableException;

public class Borrowing extends Service {

	public Borrowing(Store store, Transmission transmission) { super(store, transmission); }

	@Override
	public void run() {
		
		try {
			
			while(true) {
				
				transmission().send("This is the Borrowing Service");
				transmission().send(store().listBookedDocuments());
				transmission().send(store().listAvailableDocuments());
				
				transmission().send("Please enter the document number (-2 for quit) : ");
				int document = intFrom(transmission().receive(), -1);
				if(document == -2) break;
				
				transmission().send("Please enter your subscriber number (-2 for quit) : ");
				int subscriber = intFrom(transmission().receive(), -1);
				
				try {
					store().borrowDocument(subscriber, document);
					transmission().send("Document " + document + " has been successfully borrowed.");
				} catch (UnavailableException e) { transmission().send(e.getMessage()); }
			}
			
			transmission().close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
