package de.adiko01.PointsAndDoors;

import java.awt.Point;

public class PointsAndDoors {
	// Konstanten
	final static String VERSION = "1.0";
	
	// Variablen
	private String Task;
	
	// Punkte
	private Point player = new Point();
	private Point enemy = new Point();
	private Point door = new Point();
	private Point money = new Point();
	
	// Spiel Status
	private GameStatus status;
	
	PointsAndDoors() {
		// Variablen
		Task = "Sammele das Geldstück auf.";
		
		// Punkte
		player.move(1,1);
		enemy.x = (int) (Math.random() * 10 + 1);
		enemy.y = (int) (Math.random() * 10 + 1);
		door.x = (int) (Math.random() * 10 + 1);
		door.y = (int) (Math.random() * 10 + 1);
		money.x = (int) (Math.random() * 10 + 1);
		money.y = (int) (Math.random() * 10 + 1);
		
		//Spiel Status
		status = GameStatus.RUN;
	}
	
	private Boolean isPointReachable(Point StartPoint, int dX, int dY) {
		
		int x = StartPoint.x + dX;
		int y = StartPoint.y + dY;
		
		if (x < 1 || x > 10) {
			return false;
		} else if (y < 1 || y > 10) {
			return false;
		}
		return true;
	}
	
	private void gameLogic () {
			
		// Auswertung Spieler
		if (player.equals(money)) {
			money.move(-1, -1);
			Task = "Gehe zur Tür";
		} else if (player.equals(door) && moneyFound()) {
			Task = "Du hast Gewonnen";
			status = GameStatus.PlayerWins;
		}
		
		// Bewege Gegner
		int dX = 0;
		int dY = 0;
		
		do {
			int pos = (int) (Math.random() * 8 + 1);
			if (pos == 1) {
				dX = 1;
				dY = 0;
			} else if (pos == 2) {
				dX = 0;
				dY = 1;
			} else if (pos == 3) {
				dX = 1;
				dY = 1;
			} else if (pos == 4) {
				dX = 1;
				dY = -1;
			} else if (pos == 5) {
				dX = -1;
				dY = 0;
			} else if (pos == 6) {
				dX = 0;
				dY = -1;
			} else if (pos == 7) {
				dX = -1;
				dY = -1;
			} else if (pos == 8) {
				dX = -1;
				dY = 1;
			}
		} while (!isPointReachable(enemy, dX, dY));
		enemy.translate(dX, dY);
		
		
		// Auswertung Gegner
		if (enemy.equals(money)) {
			money.move(-1, -1);
			Task = "Gehe zur Tür";
		} else if (enemy.equals(door) && moneyFound()) {
			Task = "Der Gegner hat Gewonnen";
			status = GameStatus.EnemyWins;
		}
	}
	
	/** 
	 * @return ob das Geldstück gefunden wurde
	 */
	public boolean moneyFound () {
		if (money.x==-1||money.y==-1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Bewegt den Spieler
	 * @param c
	 * 			u - nach oben
	 * 			d - nach unten
	 * 			l - nach links
	 * 			r - nach rechts
	 */
	public void movePlayer (char c) {
		int dX = 0, dY = 0;
		if (c=='u') {
			// Ein Feld nach oben
			dX = 0;
			dY = -1;
		} else if (c=='d') {
			// Ein Feld nach unten
			dX = 0;
			dY = 1;
		} else if (c=='l') {
			//Ein Feld nach links
			dX = -1;
			dY = 0;
		} else if (c=='r') {
			//Ein Feld nach rechts
			dX = 1;
			dY = 0;
		}
		if (isPointReachable(player, dX, dY)) {
			player.translate(dX, dY);
			gameLogic();
		} else {
			throw new IllegalMoveException();
		}
	}
	
	public GameStatus getStatus () {
		return status;
	}
	
	/**
	 * @return Aktuelle Aufgabe als String
	 */
	public String getTask () {
		return Task;
	}
	/**
	 * @param obj ist ein Werte aus {@code GameObjects}
	 * @return Position des Objektes auf dem Spielfeld als {@code int}
	 */
	public int getPos (GameObjects obj) {
		// Rückgabe Wert
		int ret = 0;
		//Hilfspunkt
		Point p = new Point(-100,-100);
		if (obj == GameObjects.Player) {
			p = player;
		} else if (obj == GameObjects.Enemy) {
			p = enemy;
		} else if (obj == GameObjects.Door) {
			p = door;
		} else if (obj == GameObjects.Money) {
			p = money;
		}
		//    (Berechne die vollen Zeilen) * 10 Felder pro Zeile
		ret = (p.y - 1) * 10;
		ret = ret + p.x;
		ret = ret - 1;
		
		return ret;
	}
	
	/**
	 * @param obj ist ein Werte aus {@code GameObjects}
	 * @return Position des Objektes auf dem Spielfeld als {@code Point}
	 */
	public Point getPoint (GameObjects obj) {
		// Rückgabe Wert
		Point ret;
		if (obj == GameObjects.Player) {
			ret = new Point(player);
		} else if (obj == GameObjects.Enemy) {
			ret = new Point(enemy);
		} else if (obj == GameObjects.Door) {
			ret = new Point(door);
		} else if (obj == GameObjects.Money) {
			ret = new Point(money);
		} else {
			ret = null;
		}
		return ret;
	}
}
