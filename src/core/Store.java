package core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

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
	
	private Document doc(Integer document) throws UnavailableException {
		Document d = documents.get(document);
		if (d == null) throw new UnavailableException("Inexistent document");
		else return d;
	}
	
	private Subscriber sub(Integer number) throws UnavailableException {
		Subscriber s = subscribers.get(number);
		if (s == null) throw new UnavailableException("Inexistent subscriber");
		else return s;
	}

	public void bookDocument(Integer subscriber, Integer document) throws UnavailableException {
		Document d = doc(document); synchronized (d) { d.book(sub(subscriber)); } 
	}
	
	public void borrowDocument(Integer subscriber, Integer document) throws UnavailableException {
		Document d = doc(document); synchronized (d) { d.borrow(sub(subscriber)); } 
	}
	
	public void returnDocument(Integer document) throws UnavailableException {
		Document d = doc(document); synchronized (d) { d.giveBack(); } 
	}
	
	public String translate(String title, Collection<Document> docs) {
		String docList = title + " : \n";
		for(Document d : docs)
			synchronized(d) { docList += "\t - " + d.number() + " - " + d.toString() + "\n"; }
		return docList;
	}
	
	@SuppressWarnings("unchecked")
	private Collection<Document> docs() {
		return ((HashMap<Integer, Document>) documents.clone()).values();
	}
	
	private Collection<Document> selectAvailable(Collection<Document> docs) {
		Iterator<Document> it = docs.iterator();
		while(it.hasNext()) { Document d = it.next(); if(d.isBooked() || d.isBorrowed()) it.remove(); }
		return docs;
	}
	
	private Collection<Document> selectBorrowed(Collection<Document> docs) {
		Iterator<Document> it = docs.iterator();
		while(it.hasNext()) { Document d = it.next(); if(d.isBooked() || d.isAvailable()) it.remove(); }
		return docs;
	}
	
	private Collection<Document> selectBooked(Collection<Document> docs) {
		Iterator<Document> it = docs.iterator();
		while(it.hasNext()) { Document d = it.next(); if(d.isAvailable() || d.isBorrowed()) it.remove(); }
		return docs;
	}
	
	public String listDocuments() {
		return translate("Documents list", docs());
	}
	
	public String listAvailableDocuments() {
		return translate("Available Documents", selectAvailable(docs()));
	}
	
	public String listBookedDocuments() {
		return translate("Booked Documents", selectBooked(docs()));
	}
	
	public String listBorrowedDocuments() {
		return translate("Borrowed Documents", selectBorrowed(docs()));
	}

}
