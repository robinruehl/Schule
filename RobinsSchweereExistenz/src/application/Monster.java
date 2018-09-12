package application;

import java.util.Random;

public class Monster {
	
	


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
	public class Player {
		Random rand = new Random();
		 int luck = 10;
		 float money = 0;
		 float health = 100;
		 float maxHealth = 100;
		 int attackDamage = 50;
		 int healthPots = 10;
		 int intelligence = 10;
		 float experience = 0;
		 int level = 1;
		 int perkpoints = 25;
		
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
		 float healthPotsHeal = 40;
		 int healthPotDropChance = 50; //in %

	}
}
