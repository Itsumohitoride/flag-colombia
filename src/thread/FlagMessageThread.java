package thread;

import model.FlagMessage;
import ui.FlagMessageUI;

public class FlagMessageThread extends Thread{
	
	private FlagMessage flagMessage;
	private FlagMessageUI flagMessageUI;
	private int height;
	private int width;
	private String position;
	private String color;
	private long sleep;
	
	public FlagMessageThread(FlagMessage flagMessage, FlagMessageUI flagMessageUI, int height, int width, String position, String color, long sleep) {
		this.flagMessage = flagMessage;
		this.flagMessageUI = flagMessageUI;
		this.height = height;
		this.width = width;
		this.position = position;
		this.color = color;
		this.sleep = sleep;
	}
	
	public void run() {
		
		flagMessageUI.positionInScreen(position);
		
		for(int j = 0; j<width; j++) {
			
			for(int i = 0; i<height; i++) {

				flagMessage.advance(color);
				flagMessageUI.printMessage();
			}
			
			try {
				sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(j<(width-1)) {
				for(int i = 0; i<height; i++) {
					flagMessage.up();
					flagMessageUI.printMessage();
				}
				
				flagMessage.right();
				flagMessageUI.printMessage();
				try {
					sleep(sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			FlagMessageThread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public FlagMessage getFlagMessage() {
		return flagMessage;
	}

	public void setFlagMessage(FlagMessage flagMessage) {
		this.flagMessage = flagMessage;
	}

	public FlagMessageUI getFlagMessageUI() {
		return flagMessageUI;
	}

	public void setFlagMessageUI(FlagMessageUI flagMessageUI) {
		this.flagMessageUI = flagMessageUI;
	}
}
