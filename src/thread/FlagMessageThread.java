package thread;

import model.FlagMessage;
import ui.FlagMessageUI;

public class FlagMessageThread extends Thread{

	private FlagMessage flagMessage;
	private FlagMessageUI flagMessageUI;
	private int height;
	private int width;
	private String positionY;
	private int positionX;
	private String color;
	private long sleep;

	public FlagMessageThread(FlagMessage flagMessage, FlagMessageUI flagMessageUI, int height, int width, int positionX, String positionY, String color, long sleep) {
		this.flagMessage = flagMessage;
		this.flagMessageUI = flagMessageUI;
		this.height = height;
		this.width = width;
		this.positionY = positionY;
		this.positionX = positionX;
		this.color = color;
		this.sleep = sleep;
	}

	public void run() {

		for(int j = 0; j<width; j++) {
			
			synchronized (flagMessageUI) {
				
				flagMessageUI.positionInScreen(positionX,positionY);
				
				for(int i = 0; i<height; i++) {
					
						flagMessage.advance(color);
						flagMessageUI.printMessage();
					try {
						FlagMessageThread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			positionX++;
		}
	}
}
