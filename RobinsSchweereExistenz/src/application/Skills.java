package application;

public class Skills {
	

	public Skills() {}

	void skillincr(int skill, Player player) {
		if (skill == 1) {
			if (player.perkpoints>0) {
				player.maxHealth = (player.maxHealth+20);
				player.perkpoints = (player.perkpoints-1);
			}

		}
		else if (skill ==2) {
			if (player.perkpoints>0) {
				player.attackDamage = (player.attackDamage+10);
				player.perkpoints = (player.perkpoints-1);
			}
		
		}
		else if (skill ==3) {
			if (player.perkpoints>0) {
				player.luck = (player.luck+1);
				player.perkpoints = (player.perkpoints-1);
			}

		}
		else if (skill ==4) {
			if (player.perkpoints>0) {
				player.intelligence = (player.intelligence+1);
				player.perkpoints = (player.perkpoints-1);
			}
			
		}
	}
}
