package application;

import java.util.Random;

public class Fights {
	
	boolean yourTurn = false;
	Random rand = new Random();
	float enemyNewMax = 50;
	
	Fights(Controller GUI, Game GAME){
		this.GUI = GUI;
		this.GAME = GAME;
	}
	
	Enemy enemy;
	
	Player player;
	
	Controller GUI;
	
	Game GAME;

	public void setGUI(Controller gUI) {
		GUI = gUI;
	}
	
	public  void isFight(Raum Raum) {
		if (Raum.isEnemy()) {
			System.out.println("n gegner oh nee!");
			GUI.displayEnem();
			Fight();
		}
		else {
			System.out.println("kein gegner o jaaa!");
			GUI.disableEnem();
		}
	}
	
	public void instakill() {
		yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
		System.out.println("instakill");
    	int temp = player.attackDamage;
    	enemy.health = -1;
    	GUI.consoleWrite("Du triffst " + enemy.name + " f�r " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
    	GUI.update(player);
    	checkFight();
	}
	
	private  void Fight() {
		player = GUI.getPlayer();
		enemy = new Enemy(player);
		enemyNewMax = enemy.health;
		GUI.update(player);
		encounter();
	}
	
	public void slash() {
		yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
    	System.out.println("slash");
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du w�rfelst " + acc);
    	if (player.getHitChance() >= acc) {
        	int temp = player.attackDamage;
        	enemy.health = enemy.health-temp;
        	GUI.consoleWrite("Du triffst " + enemy.name + " f�r " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.maxAttackDMG);
    		player.health = (player.health-temp);
    		GUI.consoleWrite("Der Gegner trifft dich f�r " + temp + " Schaden und du hast noch " + player.health + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	GUI.update(player);
    	checkFight();
    }
	
	public void stab() {
		yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
    	System.out.println("slash");
    	int trys = 1;
    	System.out.println(trys);
    	int acc;
    	while (trys > 0) {
    		acc = rand.nextInt(100);
    		GUI.consoleWrite("Du w�rfelst " + acc);
    		if (player.getHitChance() >= acc) {
            	int temp = rand.nextInt(player.attackDamage/2)+5;
            	
            	enemy.health = (enemy.health-temp);
            	GUI.consoleWrite("Du triffst " + enemy.name + " f�r " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
        	}
        	else {
        		GUI.consoleWrite("Du hast den Gegner verfehlt!");
        		trys--;
        	}
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.maxAttackDMG);
    		player.health = (player.health-temp);
    		GUI.consoleWrite("Der Gegner trifft dich f�r " + temp + " Schaden und du hast noch " + player.health + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	GUI.update(player);
    	checkFight();
	}
	
    public void block() {
    	System.out.println("block");
    	yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
    	System.out.println("slash");
    	int trys = rand.nextInt(3)+3;
    	System.out.println(trys);
    	int acc;
    	
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.maxAttackDMG);
    		acc = rand.nextInt(100);
    		GUI.consoleWrite("Der Gegner greift dich an!");
    		GUI.consoleWrite("Du w�rfelst " + acc);
    		if (player.getHitChance() > acc) {
    			GUI.consoleWrite("Due kannst den Gegnerischen Angriff mit deinem Schild abwenden!");
    		}
    		else {
    			player.health = (player.health-temp);
    			GUI.consoleWrite("Der Gegner trifft dich f�r " + temp + " Schaden und du hast noch " + player.health + " Leben!");
    		}
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	GUI.update(player);
    	checkFight();
    }
    
    public void potion() {
    	if (yourTurn){
			yourTurn = false;
			GAME.encounterIsWaitingForInput = false;
			//GUI.update(player);
			if(player.healthPots > 0) {
				player.health += player.healthPotsHeal;
				player.healthPots --;
				GUI.pottiboii(player.healthPots);
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				//GUI.update(player);
				GUI.getHealthBar().setProgress(player.health/player.maxHealth);
				GUI.consoleWrite("Du hast einen Lebens Elixir getrunken und deine Lebenspunkte auf " + player.health + " erh�ht!");
				//response = true;
				if (player.health <= 0) {
					GUI.consoleWrite("Youve taken too much damage and have died.");
				}
				else if (enemy.health <= 0) {
					GUI.consoleWrite("The enemy has died");
					//lootdrop();
					//newEnemy();
				}
				else {
					encounter();
				}
			}
			else {
				GUI.consoleWrite("No health pots left");
				//response = true;
				if (player.health <= 0) {
					GUI.consoleWrite("Youve taken too much damage and have died.");
					//response = true;
				}
				else if (enemy.health <= 0) {
					GUI.consoleWrite("The enemy has died");
					//newEnemy();
				}
				else {
					encounter();
				}
			}
		}
		else if (!yourTurn && !GAME.encounterIsWaitingForInput){
	    	System.out.println("potion");
			if(player.healthPots > 0) {
				player.health += player.healthPotsHeal;
				player.healthPots --;
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				GUI.update(player);
				GUI.consoleWrite("Du hast einen Lebens Elixir getrunken und deine Lebenspunkte auf " + player.health + " erh�ht!");
				GUI.pottiboii(player.healthPots);
			}
		}
    }
    
    public void potionfight() {
    	if (yourTurn){
			yourTurn = false;
			GAME.encounterIsWaitingForInput = false;
			//GUI.update(player);
			if(player.healthPots > 0) {
				player.health += player.healthPotsHeal;
				player.healthPots --;
				GUI.pottiboii(player.healthPots);
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				//GUI.update(player);
				GUI.update(player);
				GUI.consoleWrite("Youve drank a health pot and youve heald to " + player.health + "HP.");
				//response = true;
				if (player.health <= 0) {
					GUI.consoleWrite("Youve taken too much damage and have died.");
				}
				else if (enemy.health <= 0) {
					GUI.consoleWrite("The enemy has died");
					//lootdrop();
					//newEnemy();
				}
				else {
					encounter();
				}
			}
			else {
				GUI.consoleWrite("No health pots left");
				//response = true;
				if (player.health <= 0) {
					GUI.consoleWrite("Youve taken too much damage and have died.");
					//response = true;
				}
				else if (enemy.health <= 0) {
					GUI.consoleWrite("The enemy has died");
					//newEnemy();
				}
				else {
					encounter();
				}
			}
		}
		else {

		}
    }
    
    private void checkFight() {
		if (player.health<=0) {
			System.out.println("you ded");
			GUI.consoleWrite("Du bist gestorben!");
		}
		else if (enemy.health<=0) {
			System.out.println("enemy ded");
			GUI.consoleWrite("Der Gegner ist gestorben!");
			xpdrop();
			GAME.CurrentRoom.setenemy(false);
		}
		else {
			encounter();
		}
	}
    
	private void encounter() {
		//turn ++;
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite(" Gegner " + enemy.name + " Nummer " + enemy.NBR);
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite("\t Spieler Lebenspunkte: "+player.health);
		GUI.consoleWrite("\t Gegner Lebenspunkte: " + enemy.health);
		GUI.consoleWrite("\t Was willst du machen? \n");
		yourTurn = true;
		GAME.encounterIsWaitingForInput = true;
	}
	
	private void xpdrop() {
		int exp = (5*(player.intelligence/2)*enemy.level/2)+(rand.nextInt(50)*player.luck/20);
		GUI.consoleWrite("Du erh�ltst vom Gegner " + exp + "Erfahrung!");
		player.experience = (player.experience+exp);
		if (player.experience>player.getXpToMax()) {
			player.experience = player.experience-player.getXpToMax();
			player.level = (player.level+1);
			player.experience =  player.perkpoints+1;
			GUI.consoleWrite("Du erreichst das Level" + player.level + " und hast noch " + player.perkpoints + " Meisterschaftspunkte!");
		}
		GUI.update(player);
	}
}
