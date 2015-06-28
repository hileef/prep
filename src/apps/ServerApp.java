package apps;
import java.util.ArrayList;

import services.Booking;
import services.Borrowing;
import services.Returning;
import core.*;
import documents.Book;
import documents.DVD;

public class ServerApp {
	public static void main(String[] args) {
		System.out.println("Library Server Started");
		
		/*Initialisation du Store*/
		ArrayList<Document> dlist = new ArrayList<Document>();
		ArrayList<Subscriber> slist = new ArrayList<Subscriber>();
		
		dlist.add(new Book(40, "Moulinex pour les nuls"));
		dlist.add(new Book(42, "The C Programming language"));
		dlist.add(new Book(46, "La grêce va-t-elle couler ?"));
		dlist.add(new Book(48, "BretteSoft"));
		
		dlist.add(new DVD(11, "Vous etes un genie"));
		dlist.add(new DVD(22, "La methode Koué"));
		dlist.add(new DVD(55, "Magic Mike", 16));
		dlist.add(new DVD(66, "Kill Bill", 12));

		slist.add(new Subscriber(50,"Cyril",21));
		slist.add(new Subscriber(60,"Eliot",21));
		slist.add(new Subscriber(70,"Yassine",27));
		slist.add(new Subscriber(80,"Loic",28));
		slist.add(new Subscriber(30,"Sami",12));
		slist.add(new Subscriber(40,"Lena",16));
		
		Store myStore = new Store(slist,dlist);
		
 		/*Demarrage des serveurs*/
		new Thread(new Server(2500,Booking.class, myStore)).start();
		new Thread(new Server(2600, Borrowing.class, myStore)).start();
		new Thread(new Server(2700, Returning.class, myStore)).start();

		
	}
}
