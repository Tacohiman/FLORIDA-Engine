package main;

public class PrintInventory {
	public int printInv(Player player){
		try{
			System.out.println("1. " + player.getEquippedItem().itemName + " (Currently Equipped)");
		}
		catch(java.lang.NullPointerException e){
			System.out.println("No weapons!");
			return 0;
		}
		try{
			System.out.println("2. " + player.inventory[1].itemName);
		}
		catch(java.lang.NullPointerException e){
			return 1;
		}
		try{
			System.out.println("3. " + player.inventory[2].itemName);
		}
		catch(java.lang.NullPointerException e){
			return 2;
		}
		try{
			System.out.println("4. " + player.inventory[3].itemName);
		}
		catch(java.lang.NullPointerException e){
			return 3;
		}
		try{
			System.out.println("5. " + player.inventory[4].itemName);
			
		}
		catch(java.lang.NullPointerException e){
			return 4;
		}
		return 5;
	}
}
