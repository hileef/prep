package core;

import java.util.Collection;
import java.util.HashMap;

public class Store {
	
	private HashMap<Integer, Subscriber> subscribers;
	private HashMap<Integer, Document> documents;
	
	public Store(Collection<Subscriber> ss, Collection<Document> ds) {
		this();
		for(Subscriber s : ss) subscribers.put(s.number(), s);
		for(Document d : ds) documents.put(d.number(), d);
	}
	
	public Store() {
		subscribers = new HashMap<Integer, Subscriber>();
		documents = new HashMap<Integer, Document>();
	}
	
	public void bookDocument(Integer subscriber, Integer document) {
		subscribers.get(subscriber);
	}

}
