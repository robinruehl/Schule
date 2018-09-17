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

    
    String inputTXT;
    String consoleTXT;
    boolean input;
    Game GAME;
	private boolean scrollbarListener;
	Player player;
    
    public Player getPlayer() {
		return player;
	}

	public Controller() {
    	
    }
    
    public void init() {
    	
    }
    
    public void startGame() {
    	System.out.println("GAMESTART");
    	consoleWrite("-Das Testgelände!-");
    	//hppotAmmount.setText("10");
    	GAME = new Game(this);
    	GAME.createRooms();
    	GAME.setCurrentRoom(GAME.StartRaum);
    	player = new Player();
    	consoleWrite(GAME.CurrentRoom.getBescshreibung());
    	if (!scrollbarListener){
			scrollbarListener = true;
			titledPane.heightProperty().addListener(
				    (observable, oldValue, newValue) -> {
				    	main.layout();
				        consoleTextScrollPane.setVvalue( 1.0d );
				    }
				);
		}
    	update(player);
    }
    
    public void consoleWrite(String text) {
		if (consoleTXT == null) {
			System.out.println("consoleWrite consoleTXT == null");
			//System.out.println(text);
			consoleText.setText(text);
			consoleTXT = text;
		}
		else{
			System.out.println("consoleWrite not null");
			//System.out.println(text);
			consoleTXT = consoleTXT + "\n" + text;
			consoleText.setText(consoleTXT);
			
		}
	}
    
    public void update(Player player) {
    	/*
    	int healthPots = GAME.player.getHealth();
    	float health = Monster.Player.getHealth();
    	float enemyHealth = SampleController.getEnemyHealth();
    	float enemyNewHealth = SampleController.getEnemyNewHealth();
    	String enemy = SampleController.getEnemy();
    	Float maxHealth = Monster.Player.getMaxHealth();
    	int maxAttackDamage = Monster.Player.getAttackDamage();
    	int Luck = Monster.Player.getLuck();
    	int pp = Monster.Player.getPerkpoints();
    	int intelligence = Monster.Player.getIntelligence();
    	float xptomax = (Monster.Player.getLevel()*150);
    	
    	playerLevel.setText(""+Monster.Player.getLevel());
    	playerXperienceDisplay.setText(""+Monster.Player.getExperience()+"/"+xptomax);
    	xpBar.setProgress(Monster.Player.getExperience()/xptomax);
    	hppotAmmount.setText("" + healthPots);
		healthBar.setProgress(hpbar);
		hpAmmount.setText("" + health);
		enemyHealthbar.setProgress(enemyHealth/enemyNewHealth);
		enemyhpAmmount.setText("" + enemyHealth);
		enemyName.setText(enemy);
		menuPlayerMaxHealth.setText(""+maxHealth);
		menuPlayerAttackDamage.setText(""+maxAttackDamage);
		menuPlayerLuck.setText(""+Luck);
		menuPlayerIntelligence.setText(""+intelligence);
		perkpoints.setText(""+pp);
		*/
    	
		hppotAmmount.setText("" + player.getHealthPots());
		healthBar.setProgress(player.getHealth()/player.getMaxHealth());
		hpAmmount.setText("" + player.getHealth());
		menuPlayerMaxHealth.setText(""+player.getMaxHealth());
		menuPlayerAttackDamage.setText(""+player.getAttackDamage());
		menuPlayerLuck.setText(""+player.getLuck());
		menuPlayerIntelligence.setText(""+player.getIntelligence());
		perkpoints.setText(""+player.getPerkpoints());
		
	}
    
    public void newInput() {
		inputTXT = getConsoleinp().getText();
		if (inputTXT.length()==0) {
			input = false;
		}
		else {
			input = true;
			inputTXT = getConsoleinp().getText();
			consoleWrite(inputTXT);
			getConsoleinp().setText(null);
			inputHandler(inputTXT);
		}
	}
    
    public void inputHandler(String input) {
		System.out.println("inputhandler:"+inputTXT);
		if (input.equals("norden")) {
			
		}
		else if (input.equals("norden")) {
			
		}
	}
    
    public void slash() {
    	System.out.println("slash");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.slash();
    	}
    }
    
    public void stab() {
    	System.out.println("stab");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.stab();
    	}
    }
    
    public void block() {
    	System.out.println("block");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.block();
    	}
    }
    
    public void potion() {
    	System.out.println("potion");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.potionfight();
    	}
    	else {
    		if (!GAME.encounterIsWaitingForInput && !GAME.FIGHT.yourTurn) {
        		GAME.FIGHT.potion();
        	}
    	}
    }
    
    public void goNorth() {
    	if (!GAME.encounterIsWaitingForInput) {
    		GAME.goNorth();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!");
    	}
	}
	
	public void goEast() {
    	if (!GAME.encounterIsWaitingForInput) {
    		GAME.goEast();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!");
    	}
	}
	
	public void goSoutht() {
    	if (!GAME.encounterIsWaitingForInput) {
    		GAME.goSoutht();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!");
    	}
	}
	
	public void goWest() {
    	if (!GAME.encounterIsWaitingForInput) {
    		GAME.goWest();
    	}
    	else {
    		consoleWrite("Du kannst nicht davon rennen!");
    	}
	}
	
	public void instakill() {
		System.out.println("instakill");
    	if (GAME.encounterIsWaitingForInput) {
    		GAME.FIGHT.instakill();
    	}
	}
	public void pottiboii (int pots) {
		hppotAmmount.setText(""+pots);
	}
    
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
