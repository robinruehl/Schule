package application;

public class  Game {

    static String consoleTXT;
	String inputTXT;
	boolean input;
	Raum CurrentRoom;
	Raum StartRaum;
	Raum MittlererRaum;
	Raum NoerdlicherRaum;
	Raum OestlicherRaum;
	Raum SuedlicherRaum;
	int createdrooms = 1;
	int initrooms = 1;
	Raum[] extrarooms;
	
	
	Player player;
	Controller GUI;
	Fights FIGHT;
	boolean encounterIsWaitingForInput;

	Game (Controller GUI) {
		this.GUI = GUI;
	}
	
	public void createRooms() {
		extrarooms = new Raum[101];
		StartRaum = new Raum("Du siehst einen langweiligen Raum, nur mit einer Tür in oestlicher Richtung.", null, MittlererRaum, null, null, false);
		System.out.println("created StartRaum");
		//consoleWrite("created StartRaum");
		MittlererRaum = new Raum("Du siehst einen weniger langweiligen Raum mit Türen in jeder Richtung.", NoerdlicherRaum, OestlicherRaum, SuedlicherRaum, StartRaum, true);
		System.out.println("created MittlererRaum");
		//consoleWrite("created MittlererRaum");
		NoerdlicherRaum = new Raum("Du siehst einen langweiligen Raum und du kannst nur zurrueck gehen.", null, null, MittlererRaum, null, false);
		System.out.println("created NoerdlicherRaum");
		//consoleWrite("created NoerdlicherRaum");
		OestlicherRaum = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Westen und einer grün glühenden Tür nach Osten.", null, extrarooms[0], null, MittlererRaum, false);
		System.out.println("created OestlicherRaum");
		//consoleWrite("created OestlicherRaum");
		SuedlicherRaum = new Raum("Du siehst einen langweiligen Raum und du kannst nur zurrueck gehen.", SuedlicherRaum, null, null, null, false);
		System.out.println("created SuedlicherRaum");
		//consoleWrite("created OestlicherRaum");
		
		StartRaum.setRooms(null, MittlererRaum, null, null);
		MittlererRaum.setRooms(NoerdlicherRaum, OestlicherRaum, SuedlicherRaum, StartRaum);
		NoerdlicherRaum.setRooms(null, null, MittlererRaum, null);
		OestlicherRaum.setRooms(null, extrarooms[0], null, MittlererRaum);
		SuedlicherRaum.setRooms(MittlererRaum, null, null, null);
		SuedlicherRaum.setRooms(MittlererRaum, null, null, null);
		
		extrarooms[0] = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Osten und nach Westen.", null, extrarooms[1], null, OestlicherRaum, true);
				
		while (createdrooms <= 98) {
			System.out.println(createdrooms);
			extrarooms[createdrooms] = new Raum("Du siehst einen langweiligen Raum mit einer Tür nach Osten und nach Westen.", null, extrarooms[createdrooms+1], null, extrarooms[initrooms-1], true);
			createdrooms++;
		};
		OestlicherRaum.setRooms(null, extrarooms[0], null, MittlererRaum);
		extrarooms[0].setRooms(null, extrarooms[1], null, OestlicherRaum);
		while (initrooms <= 98) {
			extrarooms[initrooms].setRooms(null, extrarooms[initrooms+1], null, extrarooms[initrooms-1]);
			initrooms++;
		}
		extrarooms[0].setRooms(null, extrarooms[1], null, OestlicherRaum);
		System.out.println(extrarooms[0].getOstRaum().toString());
		
		FIGHT = new Fights(GUI, this);
		player = GUI.getPlayer();
	}
	
	public void goNorth() {
		if (getCurrentRoom().getNordRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getNordRaum());
			System.out.println("norden gegangen");
			GUI.consoleWrite("Du bist nach Norden gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite(getCurrentRoom().getBescshreibung());
			System.out.println("fighting check n stuff");
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach norden gegangen");
			GUI.consoleWrite("Du bist nicht nach Norden gegangen!");
		}
	}
	
	public void goEast() {
		if (getCurrentRoom().getOstRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getOstRaum());
			System.out.println("osten gegangen");
			GUI.consoleWrite("Du bist nach Osten gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite(getCurrentRoom().getBescshreibung());
			System.out.println("fighting check n stuff");
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach osten gegangen");
			GUI.consoleWrite("Du bist nicht nach Osten gegangen!");
		}
	}
	
	public void goSoutht() {
		if (getCurrentRoom().getSuedRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getSuedRaum());
			System.out.println("sueden gegangen");
			GUI.consoleWrite("Du bist nach Sueden gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite(getCurrentRoom().getBescshreibung());
			System.out.println("fighting check n stuff");
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach sueden gegangen");
			GUI.consoleWrite("Du bist nicht nach Sueden gegangen!");
		}
	}
	
	public void goWest() {
		if (getCurrentRoom().getWestRaum() !=null) {
			setCurrentRoom(getCurrentRoom().getWestRaum());
			System.out.println("westen gegangen");
			GUI.consoleWrite("Du bist nach Westen gegangen!");
			System.out.println("you are now in the room: "+getCurrentRoom().toString());
			System.out.println("reading desc");
			GUI.consoleWrite(getCurrentRoom().getBescshreibung());
			FIGHT.isFight(getCurrentRoom());
		}
		else {
			System.out.println("nicht nach westen gegangen");
			GUI.consoleWrite("Du bist nicht nach Westen gegangen!");
		}
	}
	
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
