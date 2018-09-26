package application;

public class Skills {
	

	public Skills() {}
	
	//Die Skills bzw. Attribute des Spielers erhöhen. 
	void skillincr(int skill, Player player) {
		if (skill == 1) {									//Maximale Lebenspunkte erhöhen
			if (player.perkpoints>0) {						//dafür muss man natürlich Perkpoints haben
				player.maxHealth = (player.maxHealth+20);	//die maximale Lebenspunkte werden erhöht um 20 Lebenspunkte
				player.perkpoints = (player.perkpoints-1);	//ein Perkpoint wird abgezogen
			}

		}
		else if (skill ==2) {								//Schaden erhöhen
			if (player.perkpoints>0) {
				player.attackDamage = (player.attackDamage+10);
				player.perkpoints = (player.perkpoints-1);
			}
		
		}
		else if (skill ==3) {								//Glück erhöhen
			if (player.perkpoints>0) {
				player.luck = (player.luck+1);
				player.perkpoints = (player.perkpoints-1);
			}

		}
		else if (skill ==4) {								//Intelligenz erhöhen
			if (player.perkpoints>0) {
				player.intelligence = (player.intelligence+1);
				player.perkpoints = (player.perkpoints-1);
			}
			
		}
	}
}
