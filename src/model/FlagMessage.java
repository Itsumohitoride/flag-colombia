package model;

public class FlagMessage {
	
	public final static String CODE   = "\u001b[";
	public final static String UP    = CODE+"A";
	public final static String DOWN  = CODE+"B";
	public final static String RIGHT = CODE+"C";
	public final static String LEFT  = CODE+"D";
	
	private String message = "";
	
	public FlagMessage() {
	}
	
	public void advance(String color) {
		message = "\u001b["+color+" "+DOWN+LEFT;
	}
	
	public void up() {
		message = UP;
	}
	
	public void right() {
		message = RIGHT;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
