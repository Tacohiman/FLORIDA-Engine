package main;
import java.util.Random;
public class Battle {
	Player player;
	Monster monster;
	int attackType;
	int turnCounter;
	boolean monsterDie;
	boolean playerDie;
	boolean noWeapons;
	Random rand = new Random();
	InputListener listen = new InputListener();
	public Battle(Player play, Monster monst){
		player = play;
		monster = monst;
	}
	public void init(){
		System.out.println("The Battle Begins!");
		System.out.println("You see: " + monster.getName() + " it has: " + monster.getTotalHealth() + " health!");
		if (rand.nextInt(2) == 1){
			turnCounter = 1; // player goes first
			System.out.println("You go first!");
		}
		else{
			turnCounter = 0; // monster goes first
			System.out.println("The monster goes first!");
		}
		turnCounter(turnCounter);
	}
	public void turnCounter(int turn){
		if (turn == 0){
			while(!monsterDie && !playerDie){
				monsterTurn();
				playerTurn();
			}
		}
		if (turn == 1){
			while(!monsterDie && !playerDie){
				playerTurn();
				monsterTurn();
			}
		}
		player.stats.currentMana = player.stats.mana;		
	}
	public void monsterTurn(){
		int temp = monster.dealDamage();
		player.removeHealth(temp);
		if(temp == 0){
			System.out.println("The monster missed!");
			System.out.println("You have: " + player.getHealth() + " health left! " + "out of: " + player.getBaseHealth() + " health");
		}
		else{
			System.out.println("Monster dealt: " + temp + " damage!");
			System.out.println("You have: " + player.getHealth() + " health left! " + "out of: " + player.getBaseHealth() + " health");
			if (player.getHealth() <= 0){
				playerDie();
			}
		}
	}
	public void playerDie() {
		playerDie = true;
		System.out.println("The " + monster.getName() + " delivered your killing blow.");
		System.out.println(player.getName() + " fell to the ground, and died.");
		try {
			Thread.sleep(10000);
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void monsterDie(){
		monsterDie = true;
		System.out.println(monster.getName() + " died, you having killed it.");
		if (monster.drop != 0){
			System.out.println("You gained: " + monster.drop + " gold.");
			player.giveMoneys(monster.drop);
		}
		if (monster.loot != null){
			System.out.println("You got: " + monster.loot.itemName);
			player.addItem(monster.loot);
		}
	}
	public void playerTurn(){
		System.out.println("You have: " + player.getHealth() + " health, and: " + player.stats.currentMana + " mana left");
		System.out.println("What do you do?");
		System.out.println("");
		System.out.println("1. Use Melee attack");
		System.out.println("2. Use Magic attack");
		System.out.println("3. Switch weapon");
		switch(listen.GetNum(3)){
			case 1:
				monster.removeHealth(player.meleeAttack(monster.resistance));
				break;
			case 2:
				System.out.println("What magic would you like to use?");
				System.out.println("1. Red");
				System.out.println("2. Blue");
				System.out.println("3. Green");
				System.out.println("4. Purple");
				monster.removeHealth(player.magicAttack(listen.GetNum(4), monster.resistance));
				break;
			case 3:
				System.out.println("What weapon would you like to equip?");
				try{
					System.out.println("1. " + player.getEquippedItem().itemName + " (Currently Equipped)");
				}
				catch(java.lang.NullPointerException e){
					System.out.println("No weapons!");
					noWeapons = true;
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
				if(noWeapons){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
				if(player.inventory[1] == null){
					player.equipItem(listen.GetNum(1));
				}
				else if(player.inventory[2] == null){
					player.equipItem(listen.GetNum(2));
				}
				else if(player.inventory[3] == null){
					player.equipItem(listen.GetNum(3));
				}
				else if(player.inventory[4] == null){
					player.equipItem(listen.GetNum(4));
				}
				else{
					player.equipItem(listen.GetNum(5));
				}
				break;
		}
		if(monster.getCurrentHealth() <= 0){
			monsterDie();
		}
		else{
			System.out.println("The monster has: " + monster.getCurrentHealth() + " health left");
		}
	}
}
