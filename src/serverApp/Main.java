package serverApp;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import core.*;



public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Library Server Started");
		/*Initialisation du Store*/
		ArrayList<Document> docList = new ArrayList<Document>();
		ArrayList<Subscriber> subscriberList = new ArrayList<Subscriber>();
		docList.add(new Book(36, "Moulinex pour les nuls"));
		docList.add(new Book(42, "La rondelle, cette oeuvre d'art"));
		docList.add(new Book(54, "Comment faire croire que vous aller vous faire suicider ?"));
		docList.add(new Book(28, "Tricher pour les nuls"));
		docList.add(new Book(36, "Pump underwear"));
		docList.add(new DVD(52, "Vous etes un genie"));
		docList.add(new DVD(10, "La methode Koué"));
		docList.add(new DVD(20, "ATM 3"));
		docList.add(new DVD(30, "Pere françois et les petits enfants"));
		docList.add(new Book(50, "La bite de Cyril 2"));
		subscriberList.add(new Subscriber(50));
		subscriberList.add(new Subscriber(60));
		subscriberList.add(new Subscriber(70));
		subscriberList.add(new Subscriber(80));
		Store myStore = new Store(subscriberList,docList);
		
		/*Initialisation des sockets*/
		ServerSocket servSock_1 = new ServerSocket(2500);
		ServerSocket servSock_2 = new ServerSocket(2600);
		ServerSocket servSock_3 = new ServerSocket(2700);
		
 		/*Demarrage des serveurs*/
		new Thread(new Server(servSock_1,Booking.class, myStore)).start();
		new Thread(new Server(servSock_2, Loan.class, myStore)).start();
		new Thread(new Server(servSock_3, Return.class, myStore)).start();

		
	}
}
