package application;

import java.util.Random;

public class Fights {
	
	boolean yourTurn = false;
	Random rand = new Random();
	
	
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
			Fight();
		}
		else {
			System.out.println("kein gegner o jaaa!");
		}
	}
	
	public void instakill() {
		yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
		System.out.println("instakill");
    	int temp = player.getAttackDamage();
    	enemy.setEnemyHealth(-1);
    	GUI.consoleWrite("Du triffst " + enemy.enemyname + " für " + temp + " Schaden und " + enemy.enemyname + " hat noch " + enemy.getEnemyHealth() + " Leben!");
    	GUI.update(player);
    	checkFight();
	}
	
	private  void Fight() {
		enemy = new Enemy();
		player = GUI.getPlayer();
		GUI.update(player);
		encounter();
	}
	
	public void slash() {
		yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
    	System.out.println("slash");
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du würfelst " + acc);
    	if (player.accuracy >= acc) {
        	int temp = player.getAttackDamage();
        	enemy.setEnemyHealth(enemy.getEnemyHealth()-temp);
        	GUI.consoleWrite("Du triffst " + enemy.enemyname + " für " + temp + " Schaden und " + enemy.enemyname + " hat noch " + enemy.getEnemyHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.getMaxEnemyAttackDMG());
    		player.setHealth(player.getHealth()-temp);
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.getHealth() + " Leben!");
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
    		GUI.consoleWrite("Du würfelst " + acc);
    		if (player.accuracy >= acc) {
            	int temp = rand.nextInt(player.getAttackDamage()/2)+5;
            	
            	enemy.setEnemyHealth(enemy.getEnemyHealth()-temp);
            	GUI.consoleWrite("Du triffst " + enemy.enemyname + " für " + temp + " Schaden und " + enemy.enemyname + " hat noch " + enemy.getEnemyHealth() + " Leben!");
        	}
        	else {
        		GUI.consoleWrite("Du hast den Gegner verfehlt!");
        		trys--;
        	}
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.getMaxEnemyAttackDMG());
    		player.setHealth(player.getHealth()-temp);
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.getHealth() + " Leben!");
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
    		int temp = rand.nextInt(enemy.getMaxEnemyAttackDMG());
    		acc = rand.nextInt(100);
    		GUI.consoleWrite("Der Gegner greift dich an!");
    		GUI.consoleWrite("Du würfelst " + acc);
    		if (player.getAccuracy() > acc) {
    			GUI.consoleWrite("Due kannst den Gegnerischen Angriff mit deinem Schild abwenden!");
    		}
    		else {
    			player.setHealth(player.getHealth()-temp);
    			GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.getHealth() + " Leben!");
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
			if(player.getHealthPots() > 0) {
				player.health += player.healthPotsHeal;
				player.healthPots --;
				GUI.pottiboii(player.getHealthPots());
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				//GUI.update(player);
				GUI.getHealthBar().setProgress(player.health/player.maxHealth);
				GUI.consoleWrite("Du hast einen Lebens Elixir getrunken und deine Lebenspunkte auf " + player.health + " erhöht!");
				//response = true;
				if (player.health <= 0) {
					GUI.consoleWrite("Youve taken too much damage and have died.");
				}
				else if (enemy.getEnemyHealth() <= 0) {
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
				else if (enemy.getEnemyHealth() <= 0) {
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
			if(player.getHealthPots() > 0) {
				player.health += player.healthPotsHeal;
				player.healthPots --;
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				GUI.update(player);
				GUI.consoleWrite("Du hast einen Lebens Elixir getrunken und deine Lebenspunkte auf " + player.health + " erhöht!");
				GUI.pottiboii(player.getHealthPots());
			}
		}
    }
    
    public void potionfight() {
    	if (yourTurn){
			yourTurn = false;
			GAME.encounterIsWaitingForInput = false;
			//GUI.update(player);
			if(player.getHealthPots() > 0) {
				player.health += player.healthPotsHeal;
				player.healthPots --;
				GUI.pottiboii(player.getHealthPots());
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
				else if (enemy.getEnemyHealth() <= 0) {
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
				else if (enemy.getEnemyHealth() <= 0) {
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
		if (player.getHealth()<=0) {
			System.out.println("you ded");
			GUI.consoleWrite("Du bist gestorben!");
		}
		else if (enemy.getEnemyHealth()<=0) {
			System.out.println("enemy ded");
			GUI.consoleWrite("Der Gegner ist gestorben!");
			GAME.CurrentRoom.setenemy(false);
		}
		else {
			encounter();
		}
	}
    
	private void encounter() {
		//turn ++;
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite(" Gegner " + enemy.getEnemyname() + " Nummer " + enemy.getEnemyNBR());
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite("\t Spieler Lebenspunkte: "+player.getHealth());
		GUI.consoleWrite("\t Gegner Lebenspunkte: " + enemy.getEnemyHealth());
		GUI.consoleWrite("\t Was willst du machen? \n");
		yourTurn = true;
		GAME.encounterIsWaitingForInput = true;
	}
}
