package core;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ADocument implements Document {
	
	private int number;
	private boolean booked;
	private boolean available;
	private String title;
	
	private Subscriber subscriber;
	
	private Timer timer;
	private TimerTask giveBackTimerTask;
	
	public ADocument(int number, String title) {
		this.number = number;
		this.available = true;
		this.booked = false;
		this.subscriber = null;
		this.title = title;
		this.timer = new Timer();
	}
	
	@Override
	public String toString() { return title + " : " + status(); }
	
	public String status() {
		if(booked) return "booked";
		else if(available) return "available";
		else return "borrowed";
	}
	
	private void checkAvailability() throws UnavailableException { 
		if(!available) throw new UnavailableException("Document unavaible");
	}
	
	private void checkBooking(Subscriber s) throws UnavailableException{ 
		if(booked &&subscriber != s)
			throw new UnavailableException("Document already booked");
	}
	
	@Override
	public int number() { return number; }

	public void startGiveBackTimer(int time)
	{
		this.giveBackTimerTask = new GiveBackTimerTask(this);
		this.timer.schedule(this.giveBackTimerTask, time);	
	}
	
	public void stopGiveBackTimer()
	{
		if(this.giveBackTimerTask != null)
			this.giveBackTimerTask.cancel();
	}
	
	@Override
	public void book(Subscriber s) throws UnavailableException{
		checkAvailability();
		checkBooking(s);
		this.subscriber = s;
		this.booked = true;
		startGiveBackTimer(60000);			
	}

	@Override
	public void borrow(Subscriber s) throws UnavailableException{
		checkAvailability();
		checkBooking(s);
		stopGiveBackTimer();
		this.subscriber = s;
		this.available = true;		
	}

	@Override
	public void giveBack(Subscriber s) {
		stopGiveBackTimer();
		this.available = true;
		this.booked = false;
		this.subscriber = null;
	}

}
