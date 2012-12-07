package main;
import java.util.Random;
public class Player {
	static int moneys;
	static int baseHealth;
	static int currentHealth;
	static int damageBonusOther;
	static int baseDamage = 0;
	static String name;
	Item[] inventory = new Item[5];
	int inventorySpace = 0;
	Magic stats;
	Random rand = new Random();
	Player(int startingMoney, int startingBaseHealth, int currentHealth1, int startingDam, Magic stat, String playerName){
		moneys = startingMoney;
		baseHealth = startingBaseHealth;
		name = playerName;
		currentHealth = currentHealth1;
		baseDamage = startingDam;
		stats = stat;
		
	}
	public void setHealth(int setHealth) {
		currentHealth = setHealth;
	}
	public void giveHealth(int giveHealth){
		currentHealth += giveHealth;
	}

	public int getHealth() {
		return currentHealth;
	}
	public void removeHealth(int remove){
		currentHealth -= remove;
	}

	public void setBaseDamage(int setDamage) {
		baseDamage = setDamage;
	}

	public int getBaseDamage() {
		return baseDamage;
	}
	public void addItem(Item add){
		if (inventorySpace < 5){
			inventory[inventorySpace] = add;
			inventorySpace++;
		}
		else if (inventorySpace >= 5){
			System.out.println("Inventory is full");
		}
	}
	public void equipItem(int num){
		num--;
		Item temp = inventory[0];
		inventory[0] = inventory[num];
		inventory[num] = temp;
	}
	public void giveMoneys(int money){
		moneys += money;
	}
	public void setName(String nameGiven){
		name = nameGiven;
	}
	public void options(int prior){
		
	}
	public int getBaseHealth(){
		return baseHealth;
	}
	public int magicAttack(int type, Resistance resist){
		switch(type){
			case 1:
				if (Magic.currentMana <= Magic.mana && Magic.currentMana >= Magic.redCost){
					Magic.currentMana -= Magic.redCost;
					if (resist.red >= Magic.red){
						System.out.println("It is completely immune!");
						return 0;
					}
					else{
						return Magic.red + inventory[0].buffs.red;
					}
				}
				else{
					System.out.println("You do not have enough mana!");
					return 0;
				}
			case 2:
				if (Magic.currentMana <= Magic.mana && Magic.currentMana >= Magic.blueCost){
					Magic.currentMana -= Magic.blueCost;
					if (resist.blue >= Magic.blue){
						System.out.println("It is completely immune!");
						return 0;
					}
					else{
						return Magic.blue + inventory[0].buffs.blue;
					}
				}
				else{
					System.out.println("You do not have enough mana!");
					return 0;
				}

			case 3:
				if (Magic.currentMana <= Magic.mana && Magic.currentMana >= Magic.greenCost){
					Magic.currentMana -= Magic.greenCost;
					if (resist.green >= Magic.green){
						System.out.println("It is completely immune!");
						return 0;
					}
					else{
						return Magic.green + inventory[0].buffs.green;
					}
				}
				else{
					System.out.println("You do not have enough mana!");
					return 0;
				}
			case 4:
				if (Magic.currentMana <= Magic.mana && Magic.currentMana >= Magic.purpleCost){
					Magic.currentMana -= Magic.purpleCost;
					if (resist.purple >= Magic.purple){
						System.out.println("It is completely immune!");
						return 0;
					}
					else{
						return Magic.purple + inventory[0].buffs.purple;
					}
				}
				else{
					System.out.println("You do not have enough mana!");
					return 0;
				}
			default:
				return 0;
		}
	}
	public int meleeAttack(Resistance resist){
		int rawDamage = rand.nextInt(baseDamage) + inventory[0].buffs.melee + damageBonusOther;
		if (rawDamage <= resist.melee){
			System.out.println("It resisted your attack!");
			return 0;
		}
		else{
			return rand.nextInt(baseDamage) + inventory[0].buffs.melee + damageBonusOther - resist.melee;

		}
	}
	public Item getEquippedItem(){
		return inventory[0];
	}
	public void takeMoneys(int take){
		moneys -= take;
	}
	
	public void setBonusDamageOther(int bonus){
		damageBonusOther = bonus;
	}
	public void removeBonusDamage(){
		damageBonusOther = 0;
	}
	public int getDamageBonusOther(){
		return damageBonusOther;
	}
	public String getName(){
		return name;
	}
}
