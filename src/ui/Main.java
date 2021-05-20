package ui;

import model.FlagMessage;
import thread.FlagMessageThread;

public class Main {

	public final static String CODE = "\u001b[";
	public final static String YELLOW  = CODE+"43m";
	public final static String BLUE  = CODE+"44m";
	public final static String RED  = CODE+"41m";

	public static void main(String[] args) {

		FlagMessage fm = new FlagMessage();
		FlagMessageUI fmui = new FlagMessageUI(fm);
		FlagMessageThread thread1 = new FlagMessageThread(fm, fmui, 10, 110, 1,"0", YELLOW, 10);
		FlagMessageThread thread2 = new FlagMessageThread(fm, fmui, 5, 110, 1,"11", BLUE, 25);
		FlagMessageThread thread3 = new FlagMessageThread(fm, fmui, 5, 110, 1,"16", RED, 30);

		System.out.print(CODE+"2J");

		thread1.start();

		thread2.start();

		thread3.start();
	}
}
