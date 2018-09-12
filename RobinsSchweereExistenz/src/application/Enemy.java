package application;

import java.util.Random;

public class Enemy {
	Random rand = new Random();
	String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
	int maxEnemyHealth = 100;
	float enemyNewHealth;
	int maxEnemyAttackDMG = 25;
	float enemyHealth;
	int level;
	String enemyname;
	int enemyNBR;
	
	Enemy() {
		this.enemyHealth = (rand.nextInt(maxEnemyHealth/2)+maxEnemyHealth/2);
		this.enemyname = enemies[rand.nextInt(enemies.length)];
	}
	
	public int getEnemyNBR() {
		return enemyNBR;
	}

	public void setEnemyNBR(int enemyNBR) {
		this.enemyNBR = enemyNBR;
	}

	/*public  void getnewEnemy() {
		enemyHealth = rand.nextInt(maxEnemyHealth);
		enemyname = enemies[rand.nextInt(enemies.length)];
		return ;
	}*/
}
