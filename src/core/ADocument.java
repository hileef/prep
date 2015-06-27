package core;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ADocument implements Document {
	
	private int number;
	private boolean booked;
	private boolean available;
	private Subscriber subscriber;
	private Timer timer;
	private TimerTask giveBackTimerTask;
	
	public ADocument(int number) {
		this.number = number;
		this.available = true;
		this.booked = false;
		this.subscriber = null;
		this.timer = new Timer();
	}
	
	private void checkAvailability() throws UnavailableException { 
		if(!available) throw new UnavailableException("Document unavaible");
	}
	
	private void checkBooking(Subscriber s) throws UnavailableException{ 
		if(booked)
		{
			if(subscriber != s)
			{
				throw new UnavailableException("Document already booked");
			}
		}
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
		this.giveBackTimerTask.cancel();
	}
	
	@Override
	public void book(Subscriber s) throws UnavailableException{
		checkAvailability();
		checkBooking(s);
		this.subscriber = s;
		this.booked = true;
		startGiveBackTimer(6000);			
	}

	@Override
	public void borrow(Subscriber s) throws UnavailableException{
		checkAvailability();
		checkBooking(s);
		stopGiveBackTimer();
		this.subscriber = s;
		this.available = true;		
		startGiveBackTimer(60000);
	}

	@Override
	public void giveBack(Subscriber s) {
		
		this.available = true;
		this.booked = false;
		this.subscriber = null;
	}

}
