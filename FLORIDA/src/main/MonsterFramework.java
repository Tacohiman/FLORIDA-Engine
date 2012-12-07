package main;

public interface MonsterFramework {
	public void setHealth(int health);
	public int getHealth();
	public void setDamage(int damage);
	public int getDamage();
	public String getName();
	public int damageDealt(int bonus);
}
