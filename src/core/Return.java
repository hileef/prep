package core;

public class Return extends Service {

	public Return(Store store, Transmission transmission) { super(store, transmission); }

	@Override
	public void action(Integer subscriber, Integer document) throws UnavailableException {
		store().returnDocument(subscriber, document);
	}

	@Override
	public String greeting() {
		return "Welcome to the Returning Service ! Please enter your subscriber number,"
				+ " enter, then the document number, then enter.";
	}

	@Override
	public String success() {
		return "Your have successfully returned this document. :)";
	}

}
