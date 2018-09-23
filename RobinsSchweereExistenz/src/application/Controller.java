package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Controller {
	
	/*sehr dreckiger Controller.*/
	
	
	//unser gui.
	@FXML
    private AnchorPane main;
    @FXML
    private TextField consoleinp;
    @FXML
    private ScrollPane consoleTextScrollPane;
    @FXML
    private TitledPane titledPane;
    @FXML
    private Text consoleText;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonEnter;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private ProgressBar xpBar;
    @FXML
    private Text playermoney;
    @FXML
    private Text playerLevel;
    @FXML
    private Text xpAmmount;
    @FXML
    private Text hpAmmount;
    @FXML
    private Text hppotAmmount;
    @FXML
    private Text playerXperienceDisplay;
    @FXML
    private Text menuPlayerMaxHealth;
    @FXML
    private Text menuPlayerAttackDamage;
    @FXML
    private Text menuPlayerLuck;
    @FXML
    private Text menuPlayerIntelligence;
    @FXML
    private Button increaseDamageStat;
    @FXML
    private Button increaseHealthStat;
    @FXML
    private Button increaseLuckStat;
    @FXML
    private Button increaseIntelligenceStat;
    @FXML
    private Text perkpoints;
    @FXML
    private Text enemyName;
    @FXML
    private ProgressBar enemyHealthbar;
    @FXML
    private Text enemyhpAmmount;
    @FXML
    private AnchorPane AnchorEnem;
    @FXML
    private AnchorPane AnchorPlayer;
    
    
    //Konsole im GUI
    String inputTXT;
    String consoleTXT;
    boolean input;
    //Damit die Konsole mit scrolled
    private boolean scrollbarListener;
    
    //Spiel und Spieler als Objekt
    Game GAME;
	Player player;
    
	//warum nicht
    public Player getPlayer() {
		return player;
	}
    
    //Irgendwie hilft es, wenn ich da n placeholder habe
	public Controller() {
    	
    }
    
	//initialisieren später oder so vl
    public void init() {
    	
    }
    
    //Knopf vom GUI startet das Spiel hier.
    public void startGame() {
    	System.out.println("GAMESTART");
    	consoleWrite("-Das Testgelände!-");
    	
    	//sollte Gegner im GUI disabln
    	disableEnem();
    	
    	//hppotAmmount.setText("10");
    	
    	//Das ganze Spiel als obj.
    	GAME = new Game(this);
    	
    	//Das Level generieren.
    	GAME.createRooms();
    	
    	//Den Startraum besetzen.
    	GAME.setCurrentRoom(GAME.StartRaum);
    	
    	//Spieler erstellen!
    	player = new Player();
    	
    	//Die Beschreibung des ersten Raums laden.
    	consoleWrite(GAME.CurrentRoom.getBescshreibung());
    	
    	//ScrollbarListener generieren, sodass die konsole immer mit Scrolled.
    	if (!scrollbarListener){
			scrollbarListener = true;
			titledPane.heightProperty().addListener(
				    (observable, oldValue, newValue) -> {
				    	main.layout();
				        consoleTextScrollPane.setVvalue( 1.0d );
				    }
				);
		}
    	//GUI updaten!
    	update(player);
    }
    //In der Konsole Auschreiben
    public void consoleWrite(String text) {
    	
    	//Falls noch nichts geschrieben wurde,
		if (consoleTXT == null) {
			System.out.println("consoleWrite consoleTXT == null");
			//System.out.println(text);
			consoleTXT = text;
			consoleText.setText(text); // lese ich nur den gegebenen Text aus, da sonst ein Nullpointer Fehler aufkommt
		}
		//sonst
		else{
			System.out.println("consoleWrite not null");
			//System.out.println(text);
			consoleTXT = consoleTXT + "\n" + text; //den Text zu den vorherigen Text hinzufügen
			consoleText.setText(consoleTXT); //und den Text in der Konsole neu schreiben
			
		}
	}
    
    //Einfach alles updaten
    public void update(Player player) {
    	
    	//Gametab
    	//Spieler
    	hpAmmount.setText("" + player.health);
    	playerLevel.setText(""+player.level);
    	playerXperienceDisplay.setText(""+player.experience+"/"+player.getXpToMax());
    	healthBar.setProgress(player.health/player.maxHealth);
    	//Gegner
    	enemyHealthbar.setProgress(GAME.FIGHT.enemy.health/GAME.FIGHT.enemyNewMax);
		enemyhpAmmount.setText("" + GAME.FIGHT.enemy.health);
		enemyName.setText(GAME.FIGHT.enemy.name);
		//Sonstige
		hppotAmmount.setText("" + player.healthPots);
		
    	//Playertab
    	menuPlayerMaxHealth.setText(""+player.maxHealth);
		menuPlayerAttackDamage.setText(""+player.attackDamage);
		menuPlayerLuck.setText(""+player.luck);
		menuPlayerIntelligence.setText(""+player.intelligence);
    	xpBar.setProgress(player.experience/player.getXpToMax());
    	perkpoints.setText(""+player.perkpoints);
	}
    
    
    //blablabla
    public void displayEnem() {
    	AnchorEnem.setDisable(false);
    	System.out.println("false");
    }
    public void disableEnem() {
    	AnchorEnem.setDisable(true);
    	System.out.println("true");
    }
    
    //Man kann auch in die Konsole was eintippen....
    public void newInput() {
		inputTXT = getConsoleinp().getText();
		if (inputTXT.length()==0) {   //Nur enter drücken soll nichts machen
			input = false;
		}
		else {						  //aber sonst cleared er dieses Inputfeld
			input = true;
			inputTXT = getConsoleinp().getText();
			consoleWrite(inputTXT);
			getConsoleinp().setText(null);
			inputHandler(inputTXT);	  //und leiten ihn zum (sehr billigen, nicht genuzten)Handler weiter.
		}
	}
    
    //kp will vl noch was damit machen.
    public void inputHandler(String input) {
		System.out.println("inputhandler:"+inputTXT);
		if (input.equals("norden")) {
			//place.
		}
		else if (input.equals("norden")) {
			//holder.
		}
	}
    
    //wenn du den gegner zerschneiden willst.
    public void slash() {
    	System.out.println("slash");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.slash();
    	}
    }
    
    //wenn du den gegner ABSTECHEN willst.
    public void stab() {
    	System.out.println("stab");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.stab();
    	}
    }
    //wenn du den angriff des Gegners abwehren willst.
    public void block() {
    	System.out.println("block");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.block();
    	}
    }
    
    //wenn du dein Alkoholismus verstärken willst.
    public void potion() {
    	System.out.println("potion");
    	if (GAME.encounterIsWaitingForInput) {	//wenn du im Kampf bist.
    		GAME.FIGHT.potionfight();
    	}
    	else {
    		if (!GAME.encounterIsWaitingForInput && !GAME.FIGHT.yourTurn) {  //wenn du nicht im Kampf bist und du nicht dran bist irgendetwas zu machen.
        		GAME.FIGHT.potion();
        	}
    	}
    }
    
    public void goNorth() {  //yay nach norden gehen.
    	if (!GAME.encounterIsWaitingForInput) { //falls du nicht im kampf bist.
    		GAME.goNorth();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!");  //falls du im kampf bist darfst du nicht davon rennen.
    	}
	}
	
	public void goEast() { //--
    	if (!GAME.encounterIsWaitingForInput) { //--
    		GAME.goEast();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!"); //--
    	}
	}
	
	public void goSoutht() { //--
    	if (!GAME.encounterIsWaitingForInput) { //--
    		GAME.goSoutht();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!"); //--
    	}
	}
	
	public void goWest() { //--
    	if (!GAME.encounterIsWaitingForInput) { //--
    		GAME.goWest();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!"); //--
    	}
	}
	
	public void instakill() { //kämpfen dauert zu lang deswegen kann man ihn instakillen.
		System.out.println("instakill");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.instakill();
    	}
	}
	
	public void pottiboii (int pots) { //extra update für die pots.
		hppotAmmount.setText(""+pots);
	}
    
	//Skills aufwerten mit perkpoints nach hochleveln.
	public void incMaxHealth () {
		GAME.Skills.skillincr(1, player);
		update(player);
	}
	public void incAtt () {
		GAME.Skills.skillincr(2, player);
		update(player);
	}
	public void incLuck () {
		GAME.Skills.skillincr(3, player);
		update(player);
	}
	public void incInt () {
		GAME.Skills.skillincr(4, player);
		update(player);
	}
	
	
	//braucht man vl mal.
	public TextField getConsoleinp() {
		return consoleinp;
	}
	public void setConsoleinp(TextField consoleinp) {
		this.consoleinp = consoleinp;
	}
	public Text getConsoleText() {
		return consoleText;
	}
	public void setConsoleText(Text consoleText) {
		this.consoleText = consoleText;
	}

	public ProgressBar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(ProgressBar healthBar) {
		this.healthBar = healthBar;
	}
}
