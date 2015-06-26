package core;

public class Loan extends Service {

	public Loan(Store store, Transmission transmission) {
		super(store, transmission);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Loan service start");
	}

}
