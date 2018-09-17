package application;

public class Raum {
	private String bescshreibung;
	private boolean Enemy;
	private Raum NordRaum;
	private Raum OstRaum;
	private Raum SuedRaum;
	private Raum WestRaum;
	//Erster Konstruktor
	public Raum() {
		this.bescshreibung = "placeholder";
		this.NordRaum = null;
		this.SuedRaum = null;
		this.OstRaum = null;
		this.WestRaum = null;
		this.Enemy = false;
	}
	//Zweiter Konstruktor
	public Raum(String beschreibung, Raum NordRaum, Raum OstRaum, Raum SuedRaum, Raum WestRaum, boolean Enemy) {
		this.bescshreibung = beschreibung;
		this.NordRaum = NordRaum;
		this.SuedRaum = SuedRaum;
		this.OstRaum = OstRaum;
		this.WestRaum = WestRaum;
		this.Enemy = Enemy;
	}
	//Gegnercheckky
	public void setenemy(boolean bool) {
		this.Enemy = bool;
	}
	
	
	
	//Getter
	public boolean isEnemy() {
		return Enemy;
	}
	public void setEnemy(boolean enemy) {
		Enemy = enemy;
	}
	public String getBescshreibung() {
		return bescshreibung;
	}
	public Raum getNordRaum() {
		return NordRaum;
	}
	public Raum getOstRaum() {
		return OstRaum;
	}
	public Raum getSuedRaum() {
		return SuedRaum;
	}
	public Raum getWestRaum() {
		return WestRaum;
	}
	public void setNordRaum(Raum nordRaum) {
		NordRaum = nordRaum;
	}
	public void setOstRaum(Raum ostRaum) {
		OstRaum = ostRaum;
	}
	public void setSuedRaum(Raum suedRaum) {
		SuedRaum = suedRaum;
	}
	public void setWestRaum(Raum westRaum) {
		WestRaum = westRaum;
	}
	
	public void setRooms(Raum nordRaum, Raum ostRaum, Raum suedRaum, Raum westRaum) {
		NordRaum = nordRaum;
		OstRaum = ostRaum;
		SuedRaum = suedRaum;
		WestRaum = westRaum;
	}
}
