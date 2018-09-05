package application;

public class Raum {
	private String bescshreibung;
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
	}
	//Zweiter Konstruktor
	public Raum(String beschreibung, Raum NordRaum, Raum OstRaum, Raum SuedRaum, Raum WestRaum) {
		this.bescshreibung = beschreibung;
		this.NordRaum = NordRaum;
		this.SuedRaum = SuedRaum;
		this.OstRaum = OstRaum;
		this.WestRaum = WestRaum;
	}
	
	
	
	
	//Getter
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
	
}
