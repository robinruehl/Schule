package application;

import java.util.Random;

public class Enemy {
	Random rand = new Random();
	String[] enemies = {"Max", "Sven der Ackermann", "ein Krieger", "ein Ork", "lange Lange", "der Liebenberg", "rachsüchtiger Koppens", "ein Slav", "eine große Banane"};
	int maxHealth = 100;
	float newHealth;
	int maxAttackDMG;
	float health;
	int level;
	String name;
	int NBR;
	int accuracy;
	
	Enemy(Player player) {
		//Generieren von Lebenspunkten und Schaden, sowie den Namen. Dannach dem level dem des Spielers gleichsetzten. Ich wollte Leben und Schaden später davon abhängig machen.
		this.health = (rand.nextInt(maxHealth/2)+maxHealth/2);
		this.name = enemies[rand.nextInt(enemies.length)];
		this.accuracy = rand.nextInt(40) + 30;
		this.level = player.level;
		this.maxAttackDMG = rand.nextInt(25) + 20 + 5*player.level;
	}
	
}
