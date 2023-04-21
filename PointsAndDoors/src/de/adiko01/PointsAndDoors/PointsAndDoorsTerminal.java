package de.adiko01.PointsAndDoors;

import de.adiko01.java.tools.ConsoleArt;

import java.util.Scanner;


/**
 * Terminal interpreter für {@link PointsAndDoors}
 * @author adiko01
 * @version 2.1
 */
public class PointsAndDoorsTerminal {
	//Konstanten
	/** Verion des Terminalinterpreters */
	final static String VERSION = "2.1";

	/**Start Methode des Interpreters
	 * @param args werden Ignoriert
	 */
	public static void main (String[] args) {

		while (true) {
			/** Das aktive Spiel */
			PointsAndDoors game = new PointsAndDoors();

			System.out.print(
					  "# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #\n"
					+ "#                        PointsAndDoors                         #\n"
					+ "#                        Game Version " + PointsAndDoors.VERSION + "                       #\n"
					+ "#                Terminal Interpreter Version " + VERSION + "               #\n"
					+ "#                          SPIELREGELN                          #\n"
					+ "#   Bewege dich mit hilfe der Tasten auf dem 10x10 Spielfeld.   #\n"
					+ "#         Mögliche bewegungen                                   #\n"
					+ "#          u      hoch                                          #\n"
					+ "#          d      runter                                        #\n"
					+ "#          r      rechts                                        #\n"
					+ "#          l      links                                         #\n"
					+ "#                                                               #\n"
					+ "#   Das Spiel kann abgebrochen werden mit der Eingabe von \033[0;31mexit\033[0m  #\n"
					+ "#                                                               #\n"
					+ "# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #\n"
					);

			//Spieler Bewegung
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			do {
				printMap(game);

				do {
					char c;
					System.out.print("Bewegung [u,d,l,r]: ");
					String l = s.nextLine().toLowerCase();
					if (l.equals("exit")) {
						try {
							System.out.println("\033[0;34m Das Spiel wird beendet! \033[0m");
							Thread.sleep(1500);
				        } catch (InterruptedException ignored) {
				        }
						System.exit(0);
					} else {
						c = l.charAt(0);
						try {
							game.movePlayer(c);
							break;
						} catch (IllegalMoveException e) {
							System.out.println("Die Eingabe war ungültig. Wiederhole!");
						}
					}
				} while(true);
			} while (game.getStatus() == GameStatus.RUN);

			//Gewinner Auswerten
			if (game.getStatus() == GameStatus.PlayerWins) {
				ConsoleArt.print("GEWONNEN");
			} else if (game.getStatus() == GameStatus.EnemyWins) {
				ConsoleArt.print("VERLOREN");
			}

			//Nach dem Spiel das Spiel neustarten
			System.out.println("In 5 Sekunden wird eine neue Runde gestartet \n"
					+ "Zum Abbrechen, das Fenster Schließen, oder mit \033[0;31mStrg \033[0m + \033[0;31m C \033[0m das Programm beenden.");
			try {
				Thread.sleep(5000);
	        } catch (InterruptedException ignored) {
	        }

		}
	}

	/**
	 * Druckt die Karte auf die Konsole
	 * @param game Ein aktives Spiel als Objekt vom Typ {@link PointsAndDoors}
	 */
	private static void printMap(PointsAndDoors game) {
		//Drucke die Karte in die Konsole
		System.out.print(
				  "- - - - - - - - - - - - - - - - - - - - -\n"
				+ "\033[0;33mAUFGABE: " + game.getTask() + " \033[0m\n"
				+ "- - - - - - - - - - - - - - - - - - - - -\n"
				);

		for (int r=1; r<=10; r++) {
			for (int l=1; l<=10; l++) {
				if (game.getPoint(GameObjects.Player).x == l && game.getPoint(GameObjects.Player).y==r) {
					System.out.print("\033[0;31mP\033[0m");
				} else if (game.getPoint(GameObjects.Enemy).x == l && game.getPoint(GameObjects.Enemy).y==r) {
					System.out.print("\033[0;35mG\033[0m");
				} else if (game.getPoint(GameObjects.Door).x == l && game.getPoint(GameObjects.Door).y==r && game.moneyFound()) {
					System.out.print("\033[0;33mD\033[0m");
				} else if (game.getPoint(GameObjects.Door).x == l && game.getPoint(GameObjects.Door).y==r && !game.moneyFound()) {
					System.out.print("D");
				} else if (game.getPoint(GameObjects.Money).x == l && game.getPoint(GameObjects.Money).y==r) {
					System.out.print("\033[0;33m$\033[0m");
				} else {
					System.out.print("x");
				}
				System.out.print(" ");
				if(r == 4 && l == 10) {
					System.out.print("          | x - Freie Felder");
				} else if(r == 5 && l == 10) {
					System.out.print("          | \033[0;31mP\033[0m - Position Spieler");
				} else if(r == 6 && l == 10) {
					System.out.print("          | \033[0;35mG\033[0m - Position Gegenspieler");
				} else if(r == 7 && l == 10 && !game.moneyFound()) {
					System.out.print("          | \033[0;33m$\033[0m - Position Geld");
				} else if(r == 7 && l == 10 && game.moneyFound()) {
					System.out.print("          | $ - Position Geld");
				} else if(r == 8 && l == 10 && game.moneyFound()) {
					System.out.print("          | \033[0;33mD\033[0m - Position der Tür");
				} else if(r == 8 && l == 10 && !game.moneyFound()) {
					System.out.print("          | D - Position der Tür");
				}
			}
			System.out.print("\n");
		}
	}
}
