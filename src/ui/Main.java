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
		FlagMessageThread thread1 = new FlagMessageThread(fm, fmui, 10, 30, "0", YELLOW, 50);
		FlagMessageThread thread2 = new FlagMessageThread(fm, fmui, 5, 30, "11", BLUE, 50);
		FlagMessageThread thread3 = new FlagMessageThread(fm, fmui, 5, 30, "16", RED, 50);
		
		System.out.print(CODE+"2J");
		
		thread1.start();
		try {
			thread1.join(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		try {
			thread2.join(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread3.start();
		try {
			thread3.join(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
