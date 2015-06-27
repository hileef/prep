package core;

import java.util.TimerTask;

public class GiveBackTimerTask extends TimerTask {

	private Document docToGiveBack;
	
	public GiveBackTimerTask(Document d) {
		this.docToGiveBack = d; 
	}
	@Override
	public void run() {
		this.docToGiveBack.giveBack(null);		
	}

}
