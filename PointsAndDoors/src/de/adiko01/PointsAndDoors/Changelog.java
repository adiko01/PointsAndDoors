package de.adiko01.PointsAndDoors;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Changelog extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
		//this
		JFrame bla = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		TextArea textArea_Game = new TextArea();
		textArea_Game.setText(Konstanten.CHANGELOG_GAME);
		textArea_Game.setEditable(false);
		tabbedPane.addTab("Game", null, textArea_Game, null);
		
		TextArea textArea_GUI = new TextArea();
		textArea_GUI.setText(Konstanten.CHANGELOG_GUI);
		textArea_GUI.setEditable(false);
		tabbedPane.addTab("GUI", null, textArea_GUI, null);
		
		TextArea textArea_Terminal = new TextArea();
		textArea_Terminal.setText("Wird ausgeführt, wenn die JAR mit dem Parameter cmd geöffnet wird.\n\n" + Konstanten.CHANGELOG_TERMINAL);
		textArea_Terminal.setEditable(false);
		tabbedPane.addTab("Terminal", null, textArea_Terminal, null);
		
	}
}
