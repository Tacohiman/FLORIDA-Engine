package main;

public class Trade {
	Item[] stock;
	int[] prices;
	int healthP;
	InputListener listen = new InputListener();
	public Trade(Item[] storeStock, int[] storePrices, int healthPrice){
		stock = storeStock;
		prices = storePrices;
		healthP = healthPrice;
	}
	public void store(Player player){
		System.out.println("1. Buy");
		System.out.println("2. Sell");
		System.out.println("3. Heal");
		switch (listen.GetNum(2)){
			case 1:
				System.out.println("1. " + stock[0].itemName);
				System.out.println("2. " + stock[1].itemName);
				System.out.println("3. " + stock[2].itemName);
				System.out.println("4. " + stock[3].itemName);
				System.out.println("5. " + stock[4].itemName);
				
				switch (listen.GetNum(5)){
					case 1:
						System.out.println("Bought "+ stock[0].itemName);
						player.addItem(stock[0]);
						Player.moneys -= prices[0];
						break;
					case 2:
						System.out.println("Bought "+ stock[1].itemName);
						player.addItem(stock[1]);
						Player.moneys -= prices[1];
						break;
					case 3:
						System.out.println("Bought "+ stock[2].itemName);
						player.addItem(stock[2]);
						Player.moneys -= prices[2];
						break;
					case 4:
						System.out.println("Bought "+ stock[3].itemName);
						player.addItem(stock[3]);
						Player.moneys -= prices[3];
						break;
					case 5:
						System.out.println("Bought "+ stock[4].itemName);
						player.addItem(stock[4]);
						Player.moneys -= prices[4];
						break;
				}
			break;
			case 2:
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
				if(player.inventory[1] == null){
					switch(listen.GetNum(1)){
						case 1:
							sell(player.inventory[0]);
							break;
 					}
				}
				else if(player.inventory[2] == null){
					switch(listen.GetNum(2)){
					case 1:
						sell(player.inventory[0]);
						break;
					case 2:
						sell(player.inventory[1]);
						break;
					}
				}
				else if(player.inventory[3] == null){
					switch(listen.GetNum(3)){
					case 1:
						sell(player.inventory[0]);
						break;
					case 2:
						sell(player.inventory[1]);
						break;
					case 3:
						sell(player.inventory[2]);
						break;
					}
				}
				else if(player.inventory[4] == null){
					switch(listen.GetNum(4)){
					case 1:
						sell(player.inventory[0]);
						break;
					case 2:
						sell(player.inventory[1]);
						break;
					case 3:
						sell(player.inventory[2]);
						break;
					case 4:
						sell(player.inventory[3]);
						break;
					}
				}
				else{
					switch(listen.GetNum(4)){
					case 1:
						sell(player.inventory[0]);
						break;
					case 2:
						sell(player.inventory[1]);
						break;
					case 3:
						sell(player.inventory[2]);
						break;
					case 4:
						sell(player.inventory[3]);
						break;
					case 5:
						sell(player.inventory[4]);
						break;
				}
			}
			break;
			case 3:
				System.out.println("You have: " + player.getHealth() + "/" + player.getBaseHealth() + " health left.");
				System.out.println("How much to heal?");
				System.out.println("");
				System.out.println("1. 1 Health - cost: " + healthP);
				System.out.println("2. 2 Health - cost: " + healthP * 2);
				System.out.println("3. 3 Health - cost: " + healthP * 3);
				switch(3){
					case 1:
						player.giveHealth(1);
						System.out.println("You have " + player.getHealth() + "health");
						player.moneys -= healthP;
						
						break;
					case 2:
						player.giveHealth(2);
						System.out.println("You have " + player.getHealth() + "health");
						break;
					case 3:
						player.giveHealth(3);
						System.out.println("You have " + player.getHealth() + "health");
						break;
				}
		}
	}
	public void sell(Item selling){
		Player.moneys += selling.goldValue;
		selling = null;
	}
}
