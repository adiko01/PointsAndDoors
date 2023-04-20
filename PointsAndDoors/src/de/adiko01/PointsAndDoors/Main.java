package de.adiko01.PointsAndDoors;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			System.out.println("Kein Parameter");
			PointsAndDoorsGUI.main(null);
		} else if (args[0].equalsIgnoreCase("help")) {
			System.out.print(Konstanten.TITLE + "\n"
							+ "HELP \n"
							+ "");
		} else if (args[0].equalsIgnoreCase("gui")) {		
			PointsAndDoorsGUI.main(null);	
		}  else if (args[0].equalsIgnoreCase("cmd")) {		
			PointsAndDoorsTerminal.main(null);	
		}
	}

}
