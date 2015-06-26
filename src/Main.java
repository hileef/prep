import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import core.*;



public class Main {
	public static void main(String[] args) throws IOException {
		/*Initialisation du Store*/
		ArrayList<Document> docList = new ArrayList<Document>();
		ArrayList<Subscriber>subscriberList = new ArrayList<Subscriber>();
		docList.add(new Book());
		docList.add(new DVD());
		Store myStore = new Store(subscriberList,docList);
		
		/*Initialisation des sockets*/
		ServerSocket servSock_1 = new ServerSocket(2500);
		ServerSocket servSock_2 = new ServerSocket(2600);
		ServerSocket servSock_3 = new ServerSocket(2700);
		
		/*Démarrage des serveurs*/
		new Thread(new Server(servSock_1,Booking.class, myStore)).start();
		new Thread(new Server(servSock_2, Loan.class, myStore)).start();
		new Thread(new Server(servSock_3, Return.class, myStore)).start();
		
	}
}
