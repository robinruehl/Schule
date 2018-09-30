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
	 float healthPotsHeal;
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
		 this.healthPotsHeal  = 8;
		}
	 
	 
	 //Die bentigte xp zum hochleveln abrufen
	public int getXpToMax() {
		int xptomax = 50+level*50;
		return xptomax;
	}
	
	//Die Trefferwarscheinlichkeit berechnen
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
}
