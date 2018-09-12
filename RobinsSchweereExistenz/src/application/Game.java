package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Game {
	
	@FXML
    private AnchorPane main;
    @FXML
    private TextField consoleinp;
    @FXML
    private ScrollPane consoleTextScrollPane;
    @FXML
    private TitledPane titledPane;
    @FXML
    private  Text consoleText;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonEnter;
    
    
	
    static String consoleTXT;
	String inputTXT;
	boolean input;
	Raum CurrentRoom;
	Raum StartRaum;
	Raum MittlererRaum;
	Raum NoerdlicherRaum;
	Raum OestlicherRaum;
	Raum SuedlicherRaum;
	static Player player;
	public void startGame() {
		this.input = false;
		createRooms();
		CurrentRoom = StartRaum;
		player = new Player();
		System.out.println("reading desc");
		this.consoleWrite(CurrentRoom.getBescshreibung());
	}
	
	public static Player getPlayer() {
		return player;
	}

	public void createRooms() {
		StartRaum = new Raum("Ein langweiliger Raum, nur mit einer Tuer in oestlicher Richtung.", null, MittlererRaum, null, null, false);
		System.out.println("created StartRaum");
		//this.consoleWrite("created StartRaum");
		MittlererRaum = new Raum("Ein weniger langweiliger Raum, mit Tueren in jeder Richtung und einem Gegner!", NoerdlicherRaum, OestlicherRaum, SuedlicherRaum, StartRaum, true);
		System.out.println("created MittlererRaum");
		//this.consoleWrite("created MittlererRaum");
		NoerdlicherRaum = new Raum("Ein langweiliger Raum und du kannst nur zurrueck gehen.", null, null, MittlererRaum, null, false);
		System.out.println("created NoerdlicherRaum");
		//this.consoleWrite("created NoerdlicherRaum");
		OestlicherRaum = new Raum("Ein langweiliger Raum und du kannst nur zurrueck gehen.", null, null, null, MittlererRaum, false);
		System.out.println("created OestlicherRaum");
		//this.consoleWrite("created OestlicherRaum");
		SuedlicherRaum = new Raum("Ein langweiliger Raum und du kannst nur zurrueck gehen.", SuedlicherRaum, null, null, null, false);
		System.out.println("created SuedlicherRaum");
		//this.consoleWrite("created OestlicherRaum");
		
		StartRaum.setRooms(null, MittlererRaum, null, null);
		MittlererRaum.setRooms(NoerdlicherRaum, OestlicherRaum, SuedlicherRaum, StartRaum);
		NoerdlicherRaum.setRooms(null, null, MittlererRaum, null);
		OestlicherRaum.setRooms(null, null, null, MittlererRaum);
		SuedlicherRaum.setRooms(MittlererRaum, null, null, null);
		
	}
	
	public void newInput() {
		inputTXT = consoleinp.getText();
		if (inputTXT.length()==0) {
			input = false;
		}
		else {
			input = true;
			inputTXT = consoleinp.getText();
			consoleWrite(inputTXT);
			consoleinp.setText(null);
			inputHandler(inputTXT);
		}
	}
	
	private void consoleWrite(String text) {
		if (consoleTXT == null) {
			System.out.println("consoleWrite consoleTXT == null");
			System.out.println(text);
			System.out.println("consoleWrite"+consoleTXT);
			consoleText.setText(text);
			consoleTXT = text;
		}
		else{
			System.out.println("consoleWrite not null");
			System.out.println(text);
			System.out.println(consoleTXT);
			consoleTXT = consoleTXT + "\n " + text;
			consoleText.setText(consoleTXT);
			
		}
	}
	
	private void inputHandler(String input) {
		System.out.println("inputhandler:"+inputTXT);
		if (input.equals("norden")) {
			
		}
		else if (input.equals("norden")) {
			
		}
	}
	
	public void goNorth() {
		if (CurrentRoom.getNordRaum() !=null) {
			CurrentRoom = CurrentRoom.getNordRaum();
			System.out.println("norden gegangen");
			this.consoleWrite("Du bist nach Norden gegangen!");
			System.out.println("you are now in the room: "+CurrentRoom.toString());
			System.out.println("reading desc");
			this.consoleWrite(CurrentRoom.getBescshreibung());
			System.out.println("fighting check n stuff");
			Fights.isFight(CurrentRoom);
		}
		else {
			System.out.println("nicht nach norden gegangen");
			this.consoleWrite("Du bist nicht nach Norden gegangen!");
		}
	}
	
	public void goEast() {
		if (CurrentRoom.getOstRaum() !=null) {
			CurrentRoom = CurrentRoom.getOstRaum();
			System.out.println("osten gegangen");
			this.consoleWrite("Du bist nach Osten gegangen!");
			System.out.println("you are now in the room: "+CurrentRoom.toString());
			System.out.println("reading desc");
			this.consoleWrite(CurrentRoom.getBescshreibung());
			System.out.println("fighting check n stuff");
			Fights.isFight(CurrentRoom);
		}
		else {
			System.out.println("nicht nach osten gegangen");
			this.consoleWrite("Du bist nicht nach Osten gegangen!");
		}
	}
	
	public void goSoutht() {
		if (CurrentRoom.getSuedRaum() !=null) {
			CurrentRoom = CurrentRoom.getSuedRaum();
			System.out.println("sueden gegangen");
			this.consoleWrite("Du bist nach Sueden gegangen!");
			System.out.println("you are now in the room: "+CurrentRoom.toString());
			System.out.println("reading desc");
			this.consoleWrite(CurrentRoom.getBescshreibung());
			System.out.println("fighting check n stuff");
			Fights.isFight(CurrentRoom);
		}
		else {
			System.out.println("nicht nach sueden gegangen");
			this.consoleWrite("Du bist nicht nach Sueden gegangen!");
		}
	}
	
	public void goWest() {
		if (CurrentRoom.getWestRaum() !=null) {
			CurrentRoom = CurrentRoom.getWestRaum();
			System.out.println("westen gegangen");
			this.consoleWrite("Du bist nach Westen gegangen!");
			System.out.println("you are now in the room: "+CurrentRoom.toString());
			System.out.println("reading desc");
			this.consoleWrite(CurrentRoom.getBescshreibung());
			Fights.isFight(CurrentRoom);
		}
		else {
			System.out.println("nicht nach westen gegangen");
			this.consoleWrite("Du bist nicht nach Westen gegangen!");
		}
	}
}
