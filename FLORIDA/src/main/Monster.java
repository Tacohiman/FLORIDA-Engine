package main;
import java.util.*;
public class Monster /*extends Encounter */{
	int health = 0;
	int baseDamage = 0;
	int currentHealth = 0;
	int bonusDam = 0;
	String name;
	Item loot;
	int drop;
	Resistance resistance;
	Random rand = new Random();
	
	public Monster(int health1, int baseDamage1, String name1, Item loot1, int moneyDrop, Resistance resist){
		health = health1;
		baseDamage = baseDamage1;
		name = name1;	
		resistance = resist;
		currentHealth = health;
		loot = loot1;
		drop = moneyDrop;
	}
	
	public void setTotalHealth(int setHealth) {
		health = setHealth;
	}

	public int getTotalHealth() {
		return health;
	}
	public int getCurrentHealth(){
		return currentHealth;
	}
	public void removeHealth(int remove){
		currentHealth -= remove;
	}

	public void setDamage(int setDamage) {
		baseDamage = setDamage;
	}
	public void setBonusDamage(int bonus){
		bonusDam = bonus;
	}

	public int getDamage() {
		return baseDamage;
	}
	
	public String getName(){
		return name;
	}
	public int dealDamage(){
		return rand.nextInt(baseDamage) + bonusDam + 1;
	}
}
