package documents;

import java.util.Timer;
import java.util.TimerTask;

import core.Document;
import core.Subscriber;
import core.UnavailableException;

public abstract class ADocument implements Document {
	
	private int number;
	private String title;
	
	private Status status;
	private Subscriber subscriber;
	
	private Timer timer;
	private TimerTask giveBackTimerTask;
	
	public ADocument(int number, String title) {
		this.number = number; this.title = title;
		this.timer = new Timer(); this.status = Status.AVAILABLE;
	}

	private void startGiveBackTimer(int time) {
		this.giveBackTimerTask = new GiveBackTimerTask(this);
		this.timer.schedule(this.giveBackTimerTask, time);	
	}
	
	private void stopGiveBackTimer() {
		if(this.giveBackTimerTask != null) this.giveBackTimerTask.cancel();
	}
	
	private void failIfBookedByOtherOrBorrowed(Subscriber s) throws UnavailableException {
		if(isBooked() && this.subscriber != s)
			throw new UnavailableException("Someone else has booked this document.");
		else if(isBorrowed())
			throw new UnavailableException("ERROR : this document hasn't been returned yet.");
	}
	
	@Override
	public String toString() { return title + " (" + status() + ")"; }
	
	@Override
	public int number() { return number; }
	
	@Override
	public boolean isAvailable() { return status == Status.AVAILABLE; }
	
	@Override
	public boolean isBorrowed() { return status == Status.BORROWED; }
	
	@Override
	public boolean isBooked() { return status == Status.BOOKED; }
	
	@Override
	public void book(Subscriber s) throws UnavailableException {
		failIfBookedByOtherOrBorrowed(s);
		this.subscriber = s; startGiveBackTimer(60000);
		this.status = Status.BOOKED;
	}

	@Override
	public void borrow(Subscriber s) throws UnavailableException {
		failIfBookedByOtherOrBorrowed(s);
		this.subscriber = s; stopGiveBackTimer();
		this.status = Status.BORROWED;
	}

	@Override
	public void giveBack() {
		this.subscriber = null; stopGiveBackTimer();
		this.status = Status.AVAILABLE;
	}
	
	public String status() {
		switch(status) {
		case AVAILABLE: return "Available";
		case BOOKED: return "Booked";
		case BORROWED: return "Borrowed";
		default: return "ERROR";
		}
	}

}
