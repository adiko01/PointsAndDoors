package de.adiko01.PointsAndDoors;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class GUI_Anleitung extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Anleitung frame = new GUI_Anleitung();
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
	public GUI_Anleitung() {
		setTitle(Konstanten.TITLE + ": Anleitung");
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_Figuren = new JPanel();
		tabbedPane.addTab("Figuren", null, panel_Figuren, null);
		panel_Figuren.setLayout(null);
		
		JPanel panel_Spieler = new JPanel();
		panel_Spieler.setBackground(Color.RED);
		panel_Spieler.setBounds(10, 10, 50, 50);
		panel_Figuren.add(panel_Spieler);
		
		JLabel lbl_Spieler = new JLabel("Spieler");
		lbl_Spieler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Spieler.setBounds(70, 10, 108, 50);
		panel_Figuren.add(lbl_Spieler);
		
		JPanel panel_Gegner = new JPanel();
		panel_Gegner.setBackground(new Color(255, 0, 255));
		panel_Gegner.setBounds(10, 70, 50, 50);
		panel_Figuren.add(panel_Gegner);
		
		JLabel lbl_Gegner = new JLabel("Gegner");
		lbl_Gegner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Gegner.setBounds(70, 70, 108, 50);
		panel_Figuren.add(lbl_Gegner);
		
		JLabel lbl_Money = new JLabel("Geld");
		lbl_Money.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Money.setBounds(70, 130, 108, 50);
		panel_Figuren.add(lbl_Money);
		
		JPanel panel_Money = new JPanel();
		panel_Money.setBackground(Color.YELLOW);
		panel_Money.setBounds(10, 130, 50, 50);
		panel_Figuren.add(panel_Money);
		
		JPanel panel_Door = new JPanel();
		panel_Door.setBackground(new Color(139, 0, 0));
		panel_Door.setBounds(10, 190, 50, 50);
		panel_Figuren.add(panel_Door);
		
		JLabel lbl_Door = new JLabel("Tür");
		lbl_Door.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Door.setBounds(70, 190, 108, 50);
		panel_Figuren.add(lbl_Door);
		
		JLabel lbl_Spieler_2 = new JLabel("Im Terminal P");
		lbl_Spieler_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Spieler_2.setBounds(188, 10, 163, 50);
		panel_Figuren.add(lbl_Spieler_2);
		
		JLabel lbl_Enemy_2 = new JLabel("Im Terminal G");
		lbl_Enemy_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Enemy_2.setBounds(188, 70, 163, 50);
		panel_Figuren.add(lbl_Enemy_2);
		
		JLabel lbl_Money_2 = new JLabel("Im Terminal $");
		lbl_Money_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Money_2.setBounds(188, 130, 163, 50);
		panel_Figuren.add(lbl_Money_2);
		
		JLabel lbl_Door_2 = new JLabel("Im Terminal D");
		lbl_Door_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Door_2.setBounds(188, 190, 163, 50);
		panel_Figuren.add(lbl_Door_2);
	}
}
