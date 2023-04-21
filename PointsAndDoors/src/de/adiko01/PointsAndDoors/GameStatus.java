package de.adiko01.PointsAndDoors;

/** Typensichere Aufzählung zu zuständen des Spieles
 * @author adiko01
 * @version 1.1
 */
public enum GameStatus {
	/** Das Spiel ist im Fehlerzustand */
	ERROR,
	
	/** Das Spiel läuft ohne Probleme */
	RUN,
	
	/** Das Spiel ist beendet, der Spieler hat gewonnen */
	PlayerWins,
	
	/** Das Spiel ist beendet, der Gegner hat gewonnen  */
	EnemyWins
}
