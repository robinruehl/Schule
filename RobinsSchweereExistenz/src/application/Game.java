package application;

public class  Game {
	
	/*das Spiel selber*/
	
	//unsere Räume
	Raum CurrentRoom;
	Raum StartRaum;
	Raum MittlererRaum;
	Raum NoerdlicherRaum;
	Raum OestlicherRaum;
	Raum SuedlicherRaum;
	int createdrooms = 1;
	int initrooms = 1;
	
	//Mein array für alle Räume nach osten zum testen vom kämpfen
	Raum[] extrarooms;
	
	Skills Skills;
	Player player;
	Controller GUI;
	Fights FIGHT;
	
	boolean encounterIsWaitingForInput;
	
	//Konstruktor
	Game (Controller GUI) {
		this.GUI = GUI;
	}
	
	//Räume erstellen
	public void createRooms() {
		extrarooms = new Raum[101];	//101 extra Räume
		
		//Räume erstellen
		StartRaum = new Raum("Du siehst einen langweiligen Raum, nur mit einer Tür in oestlicher Richtung.",  false);
		System.out.println("created StartRaum");
		//consoleWrite("created StartRaum");
		MittlererRaum = new Raum("Du siehst einen weniger langweiligen Raum mit Türen in jeder Richtung.", true);
		System.out.println("created MittlererRaum");
		//consoleWrite("created MittlererRaum");
		NoerdlicherRaum = new Raum("Du siehst einen langweiligen Raum und du kannst nur zurrueck gehen.", false);
		System.out.println("created NoerdlicherRaum");
		//consoleWrite("created NoerdlicherRaum");
		OestlicherRaum = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Westen und einer grün glühenden Tür nach Osten.", false);
		System.out.println("created OestlicherRaum");
		//consoleWrite("created OestlicherRaum");
		SuedlicherRaum = new Raum("Du siehst einen langweiligen Raum und du kannst nur zurrueck gehen.", false);
		System.out.println("created SuedlicherRaum");
		//consoleWrite("created OestlicherRaum");
		
		//Die verbundenen Räume zuweisen...
		StartRaum.setRooms(null, MittlererRaum, null, null);
		MittlererRaum.setRooms(NoerdlicherRaum, OestlicherRaum, SuedlicherRaum, StartRaum);
		NoerdlicherRaum.setRooms(null, null, MittlererRaum, null);
		OestlicherRaum.setRooms(null, extrarooms[0], null, MittlererRaum);
		SuedlicherRaum.setRooms(MittlererRaum, null, null, null);
		SuedlicherRaum.setRooms(MittlererRaum, null, null, null);
		
		//Verbindungsraum der langen Kette von Räumen erstellen
		extrarooms[0] = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Osten und nach Westen.", null, extrarooms[1], null, OestlicherRaum, true);
		
		//Die Raumkette jetzt herzaubern
		while (createdrooms <= 98) {
			System.out.println(createdrooms);
			extrarooms[createdrooms] = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Osten und nach Westen.", true);
			createdrooms++;
		};
		
		/*while (createdrooms <= 98) {System.out.println(createdrooms);extrarooms[createdrooms] = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Osten und nach Westen.", null, extrarooms[createdrooms+1], null, extrarooms[initrooms-1], true);createdrooms++;};*/
		
		
		//Die verbundenen Räume des oestlichen Raums und des verbindungs Raums nochmal zuweisen...
		OestlicherRaum.setRooms(null, extrarooms[0], null, MittlererRaum);
		extrarooms[0].setRooms(null, extrarooms[1], null, OestlicherRaum);
		
		//Die verbundenen Räume der Raumkette jetzt zuweisen.
		while (initrooms <= 98) {
			extrarooms[initrooms].setRooms(null, extrarooms[initrooms+1], null, extrarooms[initrooms-1]);
			initrooms++;
		}
		
		//nochmal um sicher zu gehen...
		extrarooms[0].setRooms(null, extrarooms[1], null, OestlicherRaum);
		System.out.println(extrarooms[0].getOstRaum().toString());
		
		FIGHT = new Fights(GUI, this);
		Skills = new Skills();
		player = GUI.getPlayer();
	}
	
	
	//Bewegen :)
	public void goNorth() {
		if (getCurrentRoom().getNordRaum() !=null) {			//falls es einen solchen Raum giebt
			setCurrentRoom(getCurrentRoom().getNordRaum());		//setze ihn als dein jetzigen Raum
			System.out.println("norden gegangen");				
			GUI.consoleWrite("Du bist nach Norden gegangen!");			//Ausgeben in die Konsole
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite("----------------------------------------------");
			GUI.consoleWrite(getCurrentRoom().getBeschreibung());		//Raumbeschreibung auslesen
			System.out.println("fighting check n stuff");
			FIGHT.isFight(getCurrentRoom());							//Überprüfen ob ein Gegner im Raum ist
		}
		else {													//falls kein solcher Raum existiert nichts machen außer in die Konsole eintragen, dass es nicht geht
			System.out.println("nicht nach norden gegangen");
			GUI.consoleWrite("Du kannst nicht nach Norden gehen!");
		}
	}
	
	public void goEast() {
		if (getCurrentRoom().getOstRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getOstRaum());
			System.out.println("osten gegangen");
			GUI.consoleWrite("Du bist nach Osten gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite("----------------------------------------------");
			GUI.consoleWrite(getCurrentRoom().getBeschreibung());
			System.out.println("fighting check n stuff");
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach osten gegangen");
			GUI.consoleWrite("Du kannst nicht nach Osten gehen!");
		}
	}
	
	public void goSoutht() {
		if (getCurrentRoom().getSuedRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getSuedRaum());
			System.out.println("sueden gegangen");
			GUI.consoleWrite("Du bist nach Sueden gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite("----------------------------------------------");
			GUI.consoleWrite(getCurrentRoom().getBeschreibung());
			System.out.println("fighting check n stuff");
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach sueden gegangen");
			GUI.consoleWrite("Du kannst nicht nch Sueden gehen!");
		}
	}
	
	public void goWest() {
		if (getCurrentRoom().getWestRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getWestRaum());
			System.out.println("westen gegangen");
			GUI.consoleWrite("Du bist nach Westen gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite("----------------------------------------------");
			GUI.consoleWrite(getCurrentRoom().getBeschreibung());
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach westen gegangen");
			GUI.consoleWrite("Du kannst nicht nacg Westen gehen!");
		}
	}
	
	//getter und setter
	public Player getPlayer() {
		return player;
	}
	
	public Raum getCurrentRoom() {
		return CurrentRoom;
	}

	public void setCurrentRoom(Raum currentRoom) {
		CurrentRoom = currentRoom;
	}
	
    
	public boolean isEncounterIsWaitingForInput() {
		return encounterIsWaitingForInput;
	}

	public void setEncounterIsWaitingForInput(boolean encounterIsWaitingForInput) {
		this.encounterIsWaitingForInput = encounterIsWaitingForInput;
	}
}
