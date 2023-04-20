package de.adiko01.PointsAndDoors;

/** Start Classe der JAR File
 * @author adiko01
 */
public class Main {
	
	/** Start Methode
	 * Standartdmäßig wird der GUI Modus gestartet
	 * @param args <br>
	 * 				Kein Parameter: wie {@code gui} <br>
	 * 				{@code help}: Zeigt die Hilfe <br>
	 * 				{@code changelog cmd}: Zeigt den Changelog der Terminal Version an.<br>
	 * 				{@code changelog game}: Zeigt den Changelog des Spieles an.<br>
	 * 				{@code changelog gui}: Zeigt den Changelog der Gui.<br>
	 * 				{@code cmd}: Startet PoinsAndDoors im Terminal Modus.<br>
	 * 				{@code gui}: Startet PoinsAndDoors im GUI Modus.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("Kein Parameter");
			PointsAndDoorsGUI.main(null);
		} else if (args[0].equalsIgnoreCase("help")) {
			System.out.print(Konstanten.HELP);
		} else if (args[0].equalsIgnoreCase("gui")) {		
			PointsAndDoorsGUI.main(null);	
		}  else if (args[0].equalsIgnoreCase("cmd")) {		
			PointsAndDoorsTerminal.main(null);	
		}  else if (args[0].equalsIgnoreCase("changelog")) {		
			if (args[1].equalsIgnoreCase("cmd")) {
				System.out.print(Konstanten.CHANGELOG_TERMINAL);
			} else if (args[1].equalsIgnoreCase("gui")) {
				System.out.print(Konstanten.CHANGELOG_GUI);
			}  else if (args[1].equalsIgnoreCase("game")) {
				System.out.print(Konstanten.CHANGELOG_GAME);
			} else {
				System.out.print(Konstanten.HELP);
			}
		} else {
			System.out.print(Konstanten.HELP);
		}
	}

}
