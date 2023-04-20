package de.adiko01.PointsAndDoors;

public class Konstanten {
	/** Programmtitel der Fenster */
	final static String TITLE = "PointsAndDoors - Game Version: " + PointsAndDoors.VERSION + " - GUI: " + PointsAndDoorsGUI.GUI_VERSION;
	
	
	/** Changelog GUI */
	final static String CHANGELOG_GUI =
			"Version 1.0 - 2023-04-20\n"
			+ " - Erste GUI";
	/** Holt die Konstate CHANGELOG_GUI */
	public String getCHANGELOG_GUI() {
		return CHANGELOG_GUI;
	}
	
	
	/** Changelog Terminalinterpreter */
	final static String CHANGELOG_TERMINAL =
			"Version 2.0 - 2023-04-20\n"
			+ " - Baut auf der neuen Game Version 2.0 auf.";
	/** Holt die Konstate CHANGELOG_TERMINAL */
	public String getCHANGELOG_TERMINAL() {
		return CHANGELOG_TERMINAL;
	}
	
	/** Changelog Game */
	final static String CHANGELOG_GAME =
			"Version 2.0 - 2023-04-20\n"
			+ " - Das Game ist nun ein Objekt\n"
			+ "Version 1.5 - 2023-02-25:\n"
			+ " - Kartenposition der Tür und des Gegenspielers wird jetzt besser dargestellt.\n"
			+ "Version 1.4 - 2023-02-24:\n"
			+ " - Bug in der Generierung der Gegenspielerbewegung behoben\n"
			+ "Version 1.3 - 2023-02-22:\n"
			+ " - Fehlermeldung bei ungültigen Eingaben wird ausgegeben\n"
			+ " - Fehlermeldung beim ansteueren eines Punktes außerhalb des Spielfeldes wird ausgegeben\n"
			+ " - Zwischen dem Beenden des alten und dem Starten des neuen Spieles wird 5 Sekunden gewartet.\n"
			+ " - Anweisungen des Spielers werden jetzt mit nextLine() eingelesen\n"
			+ " - Das Spiel kann jetzt mit exit beendet werden\n"
			+ " - Auf der Karte wird das aktuelle Aufgabenziel Gelb eingefärbt\n"
			+ "Version 1.2 - 2023-02-22:\n"
			+ " - Kleiner Schreibfehler berichtigt\n"
			+ " - Das Spiel startet nach dem beenden einer Runde jetzt eine neue Runde\n"
			+ "Version 1.1 - 2023-02-22:\n"
			+ " - Spiel in PointsAndDoors umbenannt\n"
			+ "Version 1.0 - 2023-02-22:\n"
			+ " - Spiel Erstellt";
	/** Holt die Konstate CHANGELOG_GAME mit dem Changelog des Spieles */
	public String getCHANGELOG_GAME() {
		return CHANGELOG_GAME;
	}
	
	
	/** Help Terminal */
	final static String HELP = TITLE + "\n"
			+ "HELP\n"
			+ "Optionen:\n"
			+ "    help              Zeigt diese Seite.\n"
			+ "    changelog cmd     Zeigt den Changelog der Terminal Version an.\n"
			+ "    changelog game    Zeigt den Changelog des Spieles an.\n"
			+ "    changelog gui     Zeigt den Changelog der Gui.\n"
			+ "    cmd               Startet PoinsAndDoors im Terminal Modus.\n"
			+ "    gui               Startet PoinsAndDoors im GUI Modus.\n";
	
	/** Holt die Konstate HELP für den Programm aufruf im Terminal*/
	public String getHELP() {
		return HELP;
	}
}
