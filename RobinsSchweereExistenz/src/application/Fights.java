package application;

import java.util.Random;

public class Fights {
	
	//tuhen sie es sich bitte nicht an es ist cancer
	
	boolean yourTurn = false;
	Random rand = new Random();
	float enemyNewMax = 50; //habe schon einen wert gegeben, da dann etwas im GUI am anfang dargestellt werden kann oder so
	
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
			if (Raum.isBoss()) {
				System.out.println("Boss");
				FightBoss();
			}
			else {
				Fight();
			}
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
    	GUI.consoleWrite("Du triffst " + enemy.name + " für " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
    	GUI.update(player);
    	checkFight();
	}
	
	private  void FightBoss() {
		player = GUI.getPlayer();
		if (GAME.CurrentRoom == GAME.LastRaum) {
			
		}
		enemy = new Boss(player);
		enemyNewMax = enemy.health;
		GUI.update(player);
		GUI.consoleWrite("Ein epischer Boss ist aufgetaucht!");
		encounter();
	}
	
	private  void Fight() {
		player = GUI.getPlayer();
		enemy = new Enemy(player);
		enemyNewMax = enemy.health;
		GUI.update(player);
		GUI.consoleWrite("Ein Gegner ist aufgetaucht!");
		encounter();
	}
	
	public void slash() {
		yourTurn = false;
		GAME.encounterIsWaitingForInput = false;
    	System.out.println("slash");
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du würfelst " + acc);
    	if (player.getHitChance() >= acc) {
        	int temp = player.attackDamage;
        	enemy.health = enemy.health-temp;
        	GUI.consoleWrite("Du triffst " + enemy.name + " für " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.maxAttackDMG/2)+enemy.maxAttackDMG/2;
    		player.health = (player.health-temp);
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.health + " Leben!");
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
    	int hits = 0;
    	float damagemult = 1;
    	System.out.println(trys);
    	int acc;
    	while (trys > 0 && hits < 20) {
    		acc = rand.nextInt(100);
    		GUI.consoleWrite("Du würfelst " + acc);
    		if (player.getHitChance() >= acc) {
            	int temp = rand.nextInt(player.attackDamage)+5;
            	System.out.println(temp);
            	temp *= damagemult;
            	System.out.println(damagemult);
            	enemy.health = (enemy.health-temp);
            	GUI.consoleWrite("Du triffst " + enemy.name + " für " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
            	damagemult = damagemult/4*3;
            	hits++;
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
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.health + " Leben!");
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
    	int acc;
    	
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.maxAttackDMG*5/4);
    		acc = rand.nextInt(100);
    		GUI.consoleWrite("Der Gegner greift dich an!");
    		GUI.consoleWrite("Du würfelst " + acc);
    		if (player.getHitChance() > acc) {
    			GUI.consoleWrite("Du kannst den gegnerischen Angriff mit deinem Schild abwenden!");
    			int tempp = enemy.maxAttackDMG/4;
    			enemy.health -= tempp;
    			GUI.consoleWrite("Der Gegner nimmt " + tempp + " Rückstoßschaden!");
    			
    		}
    		else {
    			player.health = (player.health-(temp));
    			GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.health + " Leben!");
    		}
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	GUI.update(player);
    	checkFight();
    }
    
    public void potion() {
    	if (yourTurn && player.health > 0){
			yourTurn = false;
			GAME.encounterIsWaitingForInput = false;
			//GUI.update(player);
			if(player.healthPots > 0) {
				player.health += player.healthPotsHeal*player.luck;
				player.healthPots --;
				GUI.pottiboii(player.healthPots);
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
				else if (enemy.health <= 0) {
					GUI.consoleWrite("The enemy has died");
					//lootdrop();
					//newEnemy();
				}
				else {
					int acc = rand.nextInt(100);
			    	if (enemy.accuracy >= acc) {
			    		int temp = rand.nextInt(enemy.maxAttackDMG/2);
			    		player.health = (player.health-temp);
			    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.health + " Leben!");
			    	}
			    	else {
			    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
			    	}
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
		else if (!yourTurn && !GAME.encounterIsWaitingForInput && player.health > 0){
	    	System.out.println("potion");
	    	if (player.health == player.maxHealth) {
    			GUI.consoleWrite("Deine Lebenspunkte sind aber schon voll. Das würde keinen Sinn ergeben.");
    			return;
			}
			if(player.healthPots > 0) {
				player.health += player.healthPotsHeal*player.luck;
				player.healthPots --;
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				GUI.update(player);
				GUI.consoleWrite("Du hast einen Lebens Elixir getrunken und deine Lebenspunkte auf " + player.health + " erhöht!");
				GUI.pottiboii(player.healthPots);
			}
		}
    }
    
    public void potionfight() {
    	if (yourTurn && player.health > 0){
    		if (player.health == player.maxHealth) {
    			GUI.consoleWrite("Deine Lebenspunkte sind aber schon voll. Das würde keinen Sinn ergeben.");
    			return;
			}
			yourTurn = false;
			GAME.encounterIsWaitingForInput = false;
			//GUI.update(player);
			if(player.healthPots > 0) {
				player.health += player.healthPotsHeal*player.luck;
				player.healthPots --;
				GUI.pottiboii(player.healthPots);
				if (player.health > player.maxHealth) {
					player.health = player.maxHealth;
					//GUI.update(player);
				}
				//GUI.update(player);
				GUI.update(player);
				GUI.consoleWrite("Du hast einen Lebens Elixir getrunken und deine Lebenspunkte auf " + player.health + " erhöht!");
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
					int acc = rand.nextInt(100);
			    	if (enemy.accuracy >= acc) {
			    		int temp = rand.nextInt(enemy.maxAttackDMG/2);
			    		player.health = (player.health-temp);
			    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.health + " Leben!");
			    	}
			    	else {
			    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
			    	}
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
    
    public void checkFight() {
		if (player.health<=0) {
			System.out.println("you ded");
			GUI.consoleWrite("Du bist gestorben!");
		}
		else if (enemy.health<=0) {
			System.out.println("enemy ded");
			GUI.consoleWrite("Der Gegner ist gestorben!");
			xpdrop();
			GAME.CurrentRoom.setenemy(false);
			GAME.CurrentRoom.setDeadEnamy(true);
			GUI.update(player);
			GUI.consoleWrite("----------------------------------------------");
			GUI.consoleWrite(GAME.CurrentRoom.getBeschreibung());
		}
		else {
			encounter();
		}
	}
    
	private void encounter() {
		//turn ++;
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite(" Gegner " + enemy.name);
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite("\t Spieler Lebenspunkte: "+player.health);
		GUI.consoleWrite("\t Gegner Lebenspunkte: " + enemy.health);
		GUI.consoleWrite("\t Was willst du machen? \n");
		yourTurn = true;
		GAME.encounterIsWaitingForInput = true;
	}
	
	private void xpdrop() {
		
		//alt
		/*int exp = (5*(player.intelligence/2)*enemy.level/2)+(rand.nextInt(50)*player.luck/20);*/
		if (GAME.CurrentRoom.isBoss()) {
			int exp = ((5*(player.intelligence/2)*enemy.level/2)+(rand.nextInt(50)*2))*3;
			GUI.consoleWrite("Du erhältst vom epischen Boss " + exp + "Erfahrung!");
			player.experience = (player.experience+exp);
			if (player.experience>player.getXpToMax()) {
				player.experience = player.experience-player.getXpToMax();
				player.level = (player.level+1);
				player.perkpoints ++;
				GUI.consoleWrite("Du erreichst das Level" + player.level + " und hast noch " + player.perkpoints + " Meisterschaftspunkte zu verwenden!");
			}
			GUI.update(player);
		}
		else {
			int exp = (5*(player.intelligence/2)*enemy.level/2)+(rand.nextInt(50)*2);
			GUI.consoleWrite("Du erhältst vom Gegner " + exp + "Erfahrung!");
			player.experience = (player.experience+exp);
			if (player.experience>player.getXpToMax()) {
				player.experience = player.experience-player.getXpToMax();
				player.level = (player.level+1);
				player.perkpoints ++;
				GUI.consoleWrite("Du erreichst das Level" + player.level + " und hast noch " + player.perkpoints + " Meisterschaftspunkte!");
			}
			GUI.update(player);
		}
		
	}
	public void droppot() {
		int acc;
		acc = rand.nextInt(100);
		if (player.getHitChance() >= acc) {
			player.healthPots ++;
			GUI.consoleWrite("Du has ein Elixir gefunden!");
		}
		
	}
}
