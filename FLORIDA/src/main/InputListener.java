package main;

import java.util.Scanner;

public class InputListener {
	static int temp = 0;
	public int GetNum(int numOptions){
		Scanner scan = new Scanner(System.in);
		try{
			temp = scan.nextInt();
		}
		catch(java.util.InputMismatchException e){
			System.out.println("No characters, please.");
			GetNum(numOptions);
		}
		finally{
			if (temp > numOptions){
				System.out.println("That number is too high!");
				GetNum(numOptions);
			}
			return temp;
		}
	}
	public String GetString(){
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
}