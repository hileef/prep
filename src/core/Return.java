package core;

public class Return extends Service {

	public Return(Store store, Transmission transmission) { super(store, transmission); }

	@Override
	public void action(Integer subscriber, Integer document) throws UnavailableException {
		store().returnDocument(subscriber, document);
	}

}
