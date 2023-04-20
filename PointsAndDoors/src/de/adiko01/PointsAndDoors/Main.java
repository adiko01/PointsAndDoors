package de.adiko01.PointsAndDoors;

public class Main {
	
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
			}
		}
	}

}
