package application;

import java.util.Random;

public class Enemy {
	Random rand = new Random();
	String[] enemies = {"Max", "Sven der Ackermann", "ein Türke", "eine Thot"};
	int maxEnemyHealth = 100;
	float enemyNewHealth;
	int maxEnemyAttackDMG = 25;
	float enemyHealth;
	int level;
	String enemyname;
	int enemyNBR;
	int accuracy;
	
	Enemy(Player player) {
		this.enemyHealth = (rand.nextInt(maxEnemyHealth/2)+maxEnemyHealth/2);
		this.enemyname = enemies[rand.nextInt(enemies.length)];
		this.accuracy = rand.nextInt(40) + 30;
		this.level = player.getLevel();
	}
	
	public int getEnemyNBR() {
		return enemyNBR;
	}

	public void setEnemyNBR(int enemyNBR) {
		this.enemyNBR = enemyNBR;
	}

	public int getMaxEnemyAttackDMG() {
		return maxEnemyAttackDMG;
	}

	public void setMaxEnemyAttackDMG(int maxEnemyAttackDMG) {
		this.maxEnemyAttackDMG = maxEnemyAttackDMG;
	}

	public float getEnemyHealth() {
		return enemyHealth;
	}

	public void setEnemyHealth(float enemyHealth) {
		this.enemyHealth = enemyHealth;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEnemyname() {
		return enemyname;
	}

	public void setEnemyname(String enemyname) {
		this.enemyname = enemyname;
	}

	/*public  void getnewEnemy() {
		enemyHealth = rand.nextInt(maxEnemyHealth);
		enemyname = enemies[rand.nextInt(enemies.length)];
		return ;
	}*/
	
}
