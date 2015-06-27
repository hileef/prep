package core;

public class Loan extends Service {

	public Loan(Store store, Transmission transmission) { super(store, transmission); }

	@Override
	public void action(Integer subscriber, Integer document) throws UnavailableException {
		store().loanDocument(subscriber, document);
	}

	@Override
	public String greeting() {
		return "Welcome to the Loaning Service ! Please enter your subscriber number,"
				+ " enter, then the document number, then enter.";
	}

	@Override
	public String success() {
		return "Your have successfully borrowed this document. :)";
	}

}
