package application;

import java.util.Random;

public class Player {
	 Random rand = new Random();
	 int luck;
	 float money;
	 float health;
	 float maxHealth;
	 int attackDamage;
	 int accuracy;
	 int healthPots;
	 int intelligence;
	 float experience;
	 int level;
	 int perkpoints;
	 float healthPotsHeal = 40;
	 int healthPotDropChance = 50; //in %
	 
	 Player() {
		 this.luck = 10;
		 this.money = 0;
		 this.health = 100;
		 this.maxHealth = 100;
		 this.attackDamage = 50;
		 this.accuracy = 25;
		 this.healthPots = 10;
		 this.intelligence = 10;
		 this.experience = 0;
		 this.level = 1;
		 this.perkpoints = 25;
		}
	 
	 
	 
	public int getXpToMax() {
		int xptomax = 50+level*50;
		return xptomax;
	}
	
	public float getHitChance() {
		float temp = luck;
		float temp2 = 1;
		float hitchance = accuracy;
		while(temp>0) {
			hitchance = hitchance+100/(8*temp2);
			temp--;
			temp2++;
		}
		System.out.println(hitchance);
		return hitchance;
	}
	
	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPerkpoints() {
		return perkpoints;
	}
	public  void setPerkpoints(int perkpoints) {
		this.perkpoints = perkpoints;
	}
	public  float getExperience() {
		return experience;
	}
	public  void setExperience(float experience) {
		this.experience = experience;
	}
	public  int getIntelligence() {
		return intelligence;
	}
	public  void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public  int getLuck() {
		return luck;
	}
	public  void setLuck(int luck) {
		this.luck = luck;
	}
	public  float getMoney() {
		return money;
	}
	public  void setMoney(float money) {
		this.money = money;
	}
	public  int getLevel() {
		return level;
	}
	public  void setLevel(int level) {
		this.level = level;
	}
	public  float getHealth() {
		return health;
	}
	public  void setHealth(float health) {
		this.health = health;
	}
	public  float getMaxHealth() {
		return maxHealth;
	}
	public  void setMaxHealth(float maxHealth) {
		this.maxHealth = maxHealth;
	}
	public  int getAttackDamage() {
		return attackDamage;
	}
	public  void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	public  int getHealthPots() {
		return healthPots;
	}
	public  void setHealthPots(int healthPots) {
		this.healthPots = healthPots;
	}
	public  float getHealthPotsHeal() {
		return healthPotsHeal;
	}
	public  void setHealthPotsHeal(float healthPotsHeal) {
		this.healthPotsHeal = healthPotsHeal;
	}
	public  int getHealthPotDropChance() {
		return healthPotDropChance;
	}
	public  void setHealthPotDropChance(int healthPotDropChance) {
		this.healthPotDropChance = healthPotDropChance;
	}
}
