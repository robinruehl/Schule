package application;

public class Fights {
	
	static Player player;
	
	static Enemy enemy;
	
	public static void isFight(Raum Raum) {
		if (Raum.isEnemy()) {
			System.out.println("n gegner oh nee!");
			Fight();
		}
		else {
			System.out.println("kein gegner o jaaa!");
		}
	}
	
	private static void Fight() {
		enemy = new Enemy();
		player = Game.getPlayer();
		
		
		
	}
}
