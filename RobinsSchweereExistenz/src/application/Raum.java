package application;

public class Raum {
	private String beschreibung;
	private boolean Enemy;
	private Raum NordRaum;
	private Raum OstRaum;
	private Raum SuedRaum;
	private Raum WestRaum;
	//Erster Konstruktor
	Raum() {
		this.beschreibung = "placeholder";
		this.NordRaum = null;
		this.SuedRaum = null;
		this.OstRaum = null;
		this.WestRaum = null;
		this.Enemy = false;
	}
	
	//Zweiter Konstruktor
	Raum(String beschreibung, Raum NordRaum, Raum OstRaum, Raum SuedRaum, Raum WestRaum, boolean Enemy) {
		this.beschreibung = beschreibung;
		this.NordRaum = NordRaum;
		this.SuedRaum = SuedRaum;
		this.OstRaum = OstRaum;
		this.WestRaum = WestRaum;
		this.Enemy = Enemy;
	}
	
	//Dritter Konstruktor
	Raum(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	//Vierter Konstruktor
	Raum(String beschreibung, boolean Enemy) {
		this.beschreibung = beschreibung;
		this.Enemy = Enemy;
	}
	
	//Getter und setter
	public boolean isEnemy() {
		return Enemy;
	}
	public void setEnemy(boolean enemy) {
		Enemy = enemy;
	}
	public String getBeschreibung() {
		return beschreibung;
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
	public void setenemy(boolean bool) {
		this.Enemy = bool;
	}
	public void setRooms(Raum nordRaum, Raum ostRaum, Raum suedRaum, Raum westRaum) {
		NordRaum = nordRaum;
		OstRaum = ostRaum;
		SuedRaum = suedRaum;
		WestRaum = westRaum;
	}
}
