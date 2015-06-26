package core;

public class Booking extends Service {

	public Booking(Store store, Transmission t) {
		super(store, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		System.out.println("Booking Service start");
		
		// get numero d'abonne from transmission
		int s = 3000;
		
		
	}

}
