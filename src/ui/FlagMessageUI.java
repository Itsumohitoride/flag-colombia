package ui;

import model.FlagMessage;

public class FlagMessageUI {
	
	public final static String CODE = "\u001b[";
	
	private FlagMessage flagMessage;
	
	public FlagMessageUI(FlagMessage flagmessage) {
		this.flagMessage = flagmessage;
	}
	
	public synchronized void printMessage() {
		
		System.out.print(flagMessage.getMessage());
	}
	
	public synchronized void positionInScreen(String position) {
		
		System.out.print(CODE+"0G"+CODE+position+"d");
	}
}
