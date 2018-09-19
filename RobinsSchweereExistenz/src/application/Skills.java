package application;

public class Skills {
	

	public Skills() {
		// TODO Auto-generated constructor stub
	}

	void skillincr(int skill, Player player) {
		if (skill == 1) {
			if (player.getPerkpoints()>0) {
				player.setMaxHealth(player.getMaxHealth()+20);
				player.setPerkpoints(player.getPerkpoints()-1);
			}

		}
		else if (skill ==2) {
			if (player.getPerkpoints()>0) {
				player.setAttackDamage(player.getAttackDamage()+10);
				player.setPerkpoints(player.getPerkpoints()-1);
			}
		
		}
		else if (skill ==3) {
			if (player.getPerkpoints()>0) {
				player.setLuck(player.getLuck()+1);
				player.setPerkpoints(player.getPerkpoints()-1);
			}

		}
		else if (skill ==4) {
			if (player.getPerkpoints()>0) {
				player.setIntelligence(player.getIntelligence()+1);
				player.setPerkpoints(player.getPerkpoints()-1);
			}
			
		}
	}
}
