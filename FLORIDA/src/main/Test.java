package main;

import java.util.Scanner;

public class Test {
	static byte temp = 0;
	public static void main(String[] args){
		System.out.println("What do you do?");
		System.out.println(GetString());
	}
	public static byte GetNum(byte numOptions){
		Scanner scan = new Scanner(System.in);
		try{
			temp = scan.nextByte();
		}
		catch(java.util.InputMismatchException e){
			System.out.println("No characters, please.");
			GetNum((byte) 1);
		}
		finally{
			if (temp > numOptions){
				System.out.println("That number is too high!");
				GetNum(numOptions);
			}
			return temp;
		}
	}
	public static String GetString(){
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
	public void test(){
		try{
			System.out.println("1. " + player.getEquippedItem().itemName + " (Currently Equipped)");
		}
		catch(java.lang.NullPointerException e){
			System.out.println("No weapons!");
		}
		try{
			System.out.println("2. " + player.inventory[1].itemName);
		}
		catch(java.lang.NullPointerException e){
		}
		try{
			System.out.println("3. " + player.inventory[2].itemName);
		}
		catch(java.lang.NullPointerException e){
		}
		try{
			System.out.println("4. " + player.inventory[3].itemName);
		}
		catch(java.lang.NullPointerException e){
		}
		try{
			System.out.println("5. " + player.inventory[4].itemName);
		}
		catch(java.lang.NullPointerException e){
		}
	}
}
