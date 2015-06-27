package documents;

import java.util.TimerTask;

import core.Document;

public class GiveBackTimerTask extends TimerTask {

	private Document docToGiveBack;
	
	public GiveBackTimerTask(Document d) {
		this.docToGiveBack = d; 
	}
	@Override
	public void run() {
		this.docToGiveBack.giveBack();		
	}

}
