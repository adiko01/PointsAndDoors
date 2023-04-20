package de.adiko01.PointsAndDoors;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * GUI interpreter für {@link PointsAndDoors}
 * @author adiko01
 */
public class PointsAndDoorsGUI {
	//Konstanten
	/** Verion der GUI */
	final static String GUI_VERSION= "1.0";

	/** Basis Frame */
	private JFrame frmPointAndDoors;

	/**
	 * Launch the application.
	 * @param args Argumente zur Übergabe (Werden nicht berücksichtigt)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PointsAndDoorsGUI window = new PointsAndDoorsGUI();
					window.frmPointAndDoors.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PointsAndDoorsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/** Das aktive Spiel */
		PointsAndDoors game = new PointsAndDoors();


		frmPointAndDoors = new JFrame();
		frmPointAndDoors.setTitle(Konstanten.TITLE);
		frmPointAndDoors.setBounds(100, 100, 580, 650);
		frmPointAndDoors.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmPointAndDoors.getContentPane().setLayout(null);

		/** Arry mit den Spielfeldern */
		JPanel[] panels = new JPanel[100];
		for (int i = 0; i < 100 ; i++ ) {
			//Erstelle das Panel
			panels[i] = new JPanel ();

			//Setze einen weißen Hintergrund
			panels[i].setBackground(Color.WHITE);

			//Rahmen der Panels
			panels[i].setBorder(BorderFactory.createLineBorder(Color.black));

			//Position Festlegen
			//Festlegen der Spalte
			int x = ((i % 10) * 50) + 30;
			//Festlegen der Zeile
			int y = ((i / 10) * 50) + 50;

			//Setze die Maße des Panels
			panels[i].setBounds(x, y, 50, 50);

			//Füge das Panel hinzu
			frmPointAndDoors.getContentPane().add(panels[i]);
		}

		/** Label mit der aktuellen Aufgabe */
		JLabel lbl_task = new JLabel(game.getTask());
		lbl_task.setBounds(390, 582, 186, 21);
		frmPointAndDoors.getContentPane().add(lbl_task);

		/** Button für das runter bewegen */
		JButton btn_runter = new JButton("Runter");
		btn_runter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.movePlayer('d');
				aktualisieren(game, panels, lbl_task);
			}
		});
		btn_runter.setBounds(10, 582, 85, 21);
		frmPointAndDoors.getContentPane().add(btn_runter);

		/** Button für das rauf bewegen */
		JButton btn_rauf = new JButton("Rauf");
		btn_rauf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.movePlayer('u');
				aktualisieren(game, panels, lbl_task);
			}
		});
		btn_rauf.setBounds(105, 582, 85, 21);
		frmPointAndDoors.getContentPane().add(btn_rauf);

		/** Button für das nach links bewegen */
		JButton btn_links = new JButton("Links");
		btn_links.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.movePlayer('l');
				aktualisieren(game, panels, lbl_task);
			}
		});
		btn_links.setBounds(200, 582, 85, 21);
		frmPointAndDoors.getContentPane().add(btn_links);

		/** Button für das nach rechts bewegen */
		JButton btn_rechts = new JButton("Rechts");
		btn_rechts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.movePlayer('r');
				aktualisieren(game, panels, lbl_task);
			}
		});

		btn_rechts.setBounds(295, 582, 85, 21);
		frmPointAndDoors.getContentPane().add(btn_rechts);

		/** Label über dem Feld */
		JLabel lbl_Header = new JLabel(Konstanten.TITLE + " by adiko01");
		lbl_Header.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Header.setBounds(10, 21, 546, 21);
		frmPointAndDoors.getContentPane().add(lbl_Header);

		aktualisieren(game , panels, lbl_task);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 556, 22);
		frmPointAndDoors.getContentPane().add(menuBar);

		JMenuItem mntm_Exit = new JMenuItem("Beenden");
		mntm_Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntm_Exit);

		JMenu mnNewMenu = new JMenu("About");
		menuBar.add(mnNewMenu);

		JMenuItem mntm_Changelog = new JMenuItem("Changelog");
		mntm_Changelog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Changelog.main(null);
			}
		});
		mnNewMenu.add(mntm_Changelog);

		JMenuItem barItem_About = new JMenuItem("About");
		barItem_About.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"PointsAndDoors - by adiko01\n"
								+ "Game Version: " + PointsAndDoors.VERSION + "\n"
								+ "GUI Version: " + GUI_VERSION + "\n"
								+ "GitHub: adiko01/HSPV-4.3-GdP");
			}
		});
		mnNewMenu.add(barItem_About);
	}


	/**
	 * Akualisiert das Spielfeld
	 * @param game
	 * @param panels
	 */
	@SuppressWarnings("deprecation")
	private void aktualisieren (PointsAndDoors game , JPanel[] panels, JLabel lbl_task) {
		if (game.getStatus() == GameStatus.RUN) {
			for (int i = 0; i < 100 ; i++) {
				//Hintergrundfarbe der Panels
				if (i == game.getPos(GameObjects.Player)) {
					markPanelAsPlayer(panels[i]);
				} else if (i == game.getPos(GameObjects.Money)) {
					markPanelAsMoney(panels[i]);
				} else if (i == game.getPos(GameObjects.Door)) {
					markPanelAsDoor(panels[i]);
				} else if (i == game.getPos(GameObjects.Enemy)) {
					markPanelAsEnemy(panels[i]);
				} else {
					resetPanel(panels[i]);
				}
			}
		} else if (game.getStatus() == GameStatus.ERROR) {
			for (JPanel panel : panels) {
				// Entferne die Panels
				panel.hide();
			}
			JLabel lbl_ERROR = new JLabel("ERROR");
			lbl_ERROR.setFont(new Font("Tahoma", Font.BOLD, 50));
			lbl_ERROR.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_ERROR.setBounds(22, 87, 501, 305);
			frmPointAndDoors.getContentPane().add(lbl_ERROR);
		} else {
			String WinnMessage = "";
			if (game.getStatus() == GameStatus.PlayerWins) {
				WinnMessage = "Herzlichen glückwunsch,<br> du hast gewonnen!";
			} else {
				WinnMessage = "Der Gegener hat <br> leider gewonnen!";
			}
			for (JPanel panel : panels) {
				// Entferne die Panels
				panel.hide();
			}
			JLabel lbl_WinnMessage = new JLabel("<html><body><center>" + WinnMessage + "</center></body></html>");
			lbl_WinnMessage.setFont(new Font("Tahoma", Font.BOLD, 35));
			lbl_WinnMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_WinnMessage.setBounds(22, 87, 501, 305);
			frmPointAndDoors.getContentPane().add(lbl_WinnMessage);
		}
		//Aktualisiere TASK
		lbl_task.setText(game.getTask());
	}
	private void resetPanel (JPanel panel) {
		panel.setBackground(Color.WHITE);
	}
	private void markPanelAsPlayer (JPanel panel) {
		panel.setBackground(Color.RED);
	}
	private void markPanelAsMoney (JPanel panel) {
		panel.setBackground(Color.YELLOW);
	}
	private void markPanelAsDoor (JPanel panel) {
		panel.setBackground(new Color(139, 0, 0));
	}
	private void markPanelAsEnemy (JPanel panel) {
		panel.setBackground(new Color(255, 0, 255));
	}
}
