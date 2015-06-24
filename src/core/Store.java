package core;

import java.util.Collection;
import java.util.HashMap;

public class Store {
	
	private HashMap<Integer, Subscriber> subscribers;
	private HashMap<Integer, Document> documents;
	
	public Store(Collection<Subscriber> ss, Collection<Document> ds) {
		this();
		for(Subscriber s : ss) addSubscriber(s);
		for(Document d : ds) addDocument(d);
	}
	
	public Store() {
		subscribers = new HashMap<Integer, Subscriber>();
		documents = new HashMap<Integer, Document>();
	}
	
	public void addSubscriber(Subscriber s) {
		subscribers.put(s.number(), s);
	}
	
	public void addDocument(Document d) {
		documents.put(d.number(), d);
	}

}
