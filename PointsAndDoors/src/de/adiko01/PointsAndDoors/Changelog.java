package de.adiko01.PointsAndDoors;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**Changelog Panel
 * @author adiko01
 * @version 1.1
 */
@SuppressWarnings("serial")
public class Changelog extends JFrame {
	
	/** Das Pane */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args werden ignoriert
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Changelog frame = new Changelog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Changelog() {
		setTitle(Konstanten.TITLE + ": Changelog");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane);

		TextArea textArea_Game = new TextArea();
		textArea_Game.setText(Konstanten.CHANGELOG_GAME);
		textArea_Game.setEditable(false);
		tabbedPane.addTab("Game", null, textArea_Game, null);

		TextArea textArea_GUI = new TextArea();
		textArea_GUI.setText("Version 1.1 - 2024-01-03\r\n - Anleitung hinzugefügt\r\nVersion 1.0 - 2023-04-20\r\n - Erste GUI");
		textArea_GUI.setEditable(false);
		tabbedPane.addTab("GUI", null, textArea_GUI, null);

		TextArea textArea_Terminal = new TextArea();
		textArea_Terminal.setText("Wird ausgeführt, wenn die JAR mit dem Parameter cmd geöffnet wird.\n\n" + Konstanten.CHANGELOG_TERMINAL);
		textArea_Terminal.setEditable(false);
		tabbedPane.addTab("Terminal", null, textArea_Terminal, null);

	}
}
