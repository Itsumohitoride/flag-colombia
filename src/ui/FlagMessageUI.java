package ui;

import model.FlagMessage;

public class FlagMessageUI {

	public final static String CODE = "\u001b[";

	private FlagMessage flagMessage;

	public FlagMessageUI(FlagMessage flagmessage) {
		this.flagMessage = flagmessage;
	}

	public void printMessage() {

		System.out.print(flagMessage.getMessage());
	}

	public void positionInScreen(int positionX, String positionY) {

		System.out.print(CODE+positionX+"G"+CODE+positionY+"d");
	}
}
