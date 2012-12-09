package main;

import java.util.Scanner;
import java.util.Random;

public class Level1 {
	InputListener listen = new InputListener();
	Random rand = new Random();
	Resistance resist = new Resistance(1, 0, 4, 0, 1);
	Buffs buff = new Buffs(2, 0, 0, 0, 1);
	Buffs buff2 = new Buffs(1, 1, 1, 1, 2);
	Magic stats = new Magic(1, 2, 3, 4, 1, 2, 3, 4, 5, 5);
	Item testItem2 = new Item(100, "Mc. Stabbs", buff2);
	Monster test = new Monster(6, 1, "The Formidable Test", testItem2, 100, resist);
	Item testItem = new Item(100, "The Testing Butt-Rapier", buff);
	Player player = new Player(10, 10, 10, 2, stats, "");
	public void levelMain(){
		System.out.println("Welcome Traveler! Type your name:");
		String name = listen.GetString();
		player.setName(name);
		System.out.println("Hello " + name);
		System.out.println("In your travels, You find a legendry sword: " + testItem.itemName);
		System.out.println("It gives you + " + testItem.buffs.melee + " melee damage!");
		player.addItem(testItem);
		System.out.println("OH NOES, A MONSTER APPROACHETH: \"" + test.getName() + "\"");
		System.out.println("Your options are:");
		System.out.println("1. Run");
		System.out.println("2. Fight");
		int temp = listen.GetNum(2);
		if(temp == 1){
			if (rand.nextInt(2) == 1){
				System.out.println("You escapeth the monster");
			}
			else{
				System.out.println("Your valient attempts fail, prepare for battle!");
				encounter1(test);
				System.out.println("The long battle ended.");
			}
		}
		else if(temp == 2){
			System.out.println("Here we go!");
			encounter1(test);
			System.out.println("The long battle ended.");
		}
		System.out.println("After that, you press onwards.");
		PrintInventory inv = new PrintInventory();
		inv.printInv(player);
		
		
	}
	public void encounter1(Monster encounter1){
		int playerOnFirst;
		System.out.println("The monster is a butt. I am running out of ideas, I mostly just want to code. Screw this story stuff");
		Battle battle1 = new Battle(player, test);
		battle1.init();
		
	}
}
