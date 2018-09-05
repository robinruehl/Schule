package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SampleController {
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
	
	public void startGame() {
		this.input = false;
		createRooms();
	}
	
	public void createRooms() {
		Raum StartRaum;
		Raum MittlererRaum = null;
		Raum NoerdlicherRaum = null;
		Raum OestlicherRaum = null;
		Raum SuedlicherRaum = null;
		StartRaum = new Raum("Ein langweiliger Raum", null, null, null, null);
		System.out.println("created StartRaum");
		this.consoleWrite("created StartRaum");
		MittlererRaum = new Raum("Ein weniger langweiliger Raum", NoerdlicherRaum, OestlicherRaum, SuedlicherRaum, StartRaum);
		System.out.println("created MittlererRaum");
		this.consoleWrite("created MittlererRaum");
		NoerdlicherRaum = new Raum("Ein langweiliger Raum", null, null, MittlererRaum, null);
		System.out.println("created NoerdlicherRaum");
		this.consoleWrite("created NoerdlicherRaum");
		OestlicherRaum = new Raum("Ein langweiliger Raum", null, null, null, MittlererRaum);
		System.out.println("created OestlicherRaum");
		this.consoleWrite("created OestlicherRaum");
		SuedlicherRaum = new Raum("Ein langweiliger Raum", SuedlicherRaum, null, null, null);
		System.out.println("created SuedlicherRaum");
		this.consoleWrite("created OestlicherRaum");
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
}
