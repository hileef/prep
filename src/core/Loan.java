package core;

public class Loan extends Service {

	public Loan(Store store, Transmission transmission) { super(store, transmission); }

	@Override
	public void action(Integer subscriber, Integer document) throws UnavailableException {
		store().loanDocument(subscriber, document);
	}

}
