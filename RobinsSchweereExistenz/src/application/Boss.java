package application;

public class Boss extends Enemy {
	
	String[] bossnames = {"Dicker dude","Robin the Creator","Original Meme", "der Liebenberg"};
	
	Boss(Player player) {
		super();
		int chosentype = rand.nextInt(bossnames.length);
		this.name = bossnames[chosentype];
		if (chosentype == 0) {
			this.health = (rand.nextInt(maxHealth/2)+maxHealth/2)*((player.level/2)+3);
			this.accuracy = rand.nextInt(40) + 30;
			this.level = player.level;
			this.maxAttackDMG = rand.nextInt(25) + 20 + 10*player.level;
		}
		else if (chosentype == 1) {
			this.health = (rand.nextInt(maxHealth/2)+maxHealth/2)*((player.level/2)+9);
			this.accuracy = rand.nextInt(40) + 30;
			this.level = player.level;
			this.maxAttackDMG = rand.nextInt(25) + 10 + 2*player.level;
		}
		else if (chosentype == 2) {
			this.health = (rand.nextInt(maxHealth/2)+maxHealth/2)*((player.level/2)+2);
			this.accuracy = rand.nextInt(40) + 30;
			this.level = player.level;
			this.maxAttackDMG = rand.nextInt(25) + 30 + 5*player.level;
		}
		else if (chosentype == 3) {
			this.health = (rand.nextInt(maxHealth/2)+maxHealth/2)*((player.level)+10);
			this.accuracy = rand.nextInt(40) + 10;
			this.level = player.level*3/2;
			this.maxAttackDMG = rand.nextInt(60) + 60 + 5*player.level;
		}
		
		
		else {
			this.health = (rand.nextInt(maxHealth/2)+maxHealth/2)*((player.level/4)+1);
			this.name = enemies[rand.nextInt(enemies.length)];
			this.accuracy = rand.nextInt(40) + 30;
			this.level = player.level;
			this.maxAttackDMG = rand.nextInt(25) + 20 + 5*player.level;
		}
	}

}
