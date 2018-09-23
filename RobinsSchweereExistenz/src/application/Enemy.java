package application;

import java.util.Random;

public class Enemy {
	Random rand = new Random();
	String[] enemies = {"Max", "Sven der Ackermann", "ein Türke", "eine Thot"};
	int maxHealth = 100;
	float newHealth;
	int maxAttackDMG = 25;
	float health;
	int level;
	String name;
	int NBR;
	int accuracy;
	
	Enemy(Player player) {
		this.health = (rand.nextInt(maxHealth/2)+maxHealth/2);
		this.name = enemies[rand.nextInt(enemies.length)];
		this.accuracy = rand.nextInt(40) + 30;
		this.level = player.level;
	}
	
}
