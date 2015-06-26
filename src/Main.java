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
		
		/*Démarrage des services*/
		new Thread(new Booking(myStore,servSock_1)).start();
		new Thread(new Loan(myStore,servSock_2)).start();
		new Thread(new Return(myStore,servSock_3)).start();
		
	}
}