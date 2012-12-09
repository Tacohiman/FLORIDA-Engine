package main;

public class Main {
	public static void main(String[] args){
		InputListener listen = new InputListener();
		System.out.println("This game was made with the FLORIDA engine - By Tyler Dorn");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("EVERYTHING IS OKAY, PRESS ENTER");
		}
		System.out.println("Pick what level you wish to play:");
		System.out.println("1. The No-Try Testing Forest");
		System.out.println("No other");
		switch(listen.GetNum(1)){
			case 1:
				Level1 level = new Level1();
				level.levelMain();
				break;
		}
	}
}
