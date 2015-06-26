package core;

import java.util.Collection;
import java.util.HashMap;

public class Store {

	private HashMap<Integer, Subscriber> subscribers;
	private HashMap<Integer, Document> documents;

	public Store(Collection<Subscriber> ss, Collection<Document> ds) {
		this();
		for (Subscriber s : ss) subscribers.put(s.number(), s);
		for (Document d : ds) documents.put(d.number(), d);
	}

	public Store() {
		subscribers = new HashMap<Integer, Subscriber>();
		documents = new HashMap<Integer, Document>();
	}
	
	private Subscriber sub(Integer number) throws UnavailableException {
		Subscriber s = subscribers.get(number);
		if (s == null) throw new UnavailableException("Inexistent subscriber");
		else return s;
	}

	public void bookDocument(Integer subscriber, Integer document) throws UnavailableException {
		Document d = documents.get(document); synchronized (d) { d.book(sub(subscriber)); } 
	}
	
	public void loanDocument(Integer subscriber, Integer document) throws UnavailableException {
		Document d = documents.get(document); synchronized (d) { d.borrow(sub(subscriber)); } 
	}
	
	public void returnDocument(Integer subscriber, Integer document) throws UnavailableException {
		Document d = documents.get(document); synchronized (d) { d.giveBack(sub(subscriber)); } 
	}

}
