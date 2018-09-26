package application;

public class Skills {
	

	public Skills() {}
	
	//Die Skills bzw. Attribute des Spielers erh�hen. 
	void skillincr(int skill, Player player) {
		if (skill == 1) {									//Maximale Lebenspunkte erh�hen
			if (player.perkpoints>0) {						//daf�r muss man nat�rlich Perkpoints haben
				player.maxHealth = (player.maxHealth+20);	//die maximale Lebenspunkte werden erh�ht um 20 Lebenspunkte
				player.perkpoints = (player.perkpoints-1);	//ein Perkpoint wird abgezogen
			}

		}
		else if (skill ==2) {								//Schaden erh�hen
			if (player.perkpoints>0) {
				player.attackDamage = (player.attackDamage+10);
				player.perkpoints = (player.perkpoints-1);
			}
		
		}
		else if (skill ==3) {								//Gl�ck erh�hen
			if (player.perkpoints>0) {
				player.luck = (player.luck+1);
				player.perkpoints = (player.perkpoints-1);
			}

		}
		else if (skill ==4) {								//Intelligenz erh�hen
			if (player.perkpoints>0) {
				player.intelligence = (player.intelligence+1);
				player.perkpoints = (player.perkpoints-1);
			}
			
		}
	}
}
