package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TutorialPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridSystem gridSystem;
	private TutorialPanelGameZone gameZone;
	
	public TutorialPanel() {
		gridSystem = new GridSystem(this);
		gridSystem.addExternalBorder(10, 10, 10, 10);
		setBackground(Color.BLACK);
	
		JTextPane pane = new JTextPane();
		pane.setForeground(Color.WHITE);
		pane.setBackground(Color.BLACK);
		pane.setBorder(null);
		pane.setEditable(false);
		pane.setFont(new Font("Arial", Font.BOLD, 40));
		pane.setText("Tutorial\n"
				+ "En este juego debes eliminar a tus oponentes con\n"
				+ "la ayuda de armas que caen por el mapa. El movimiento\n"
				+ "de tu personaje es controlado con las teclas W, A, S, D");
		
		add(pane, gridSystem.insertComponent(0, 0, 12, 0.1));
		
		gameZone = new TutorialPanelGameZone();
		add(gameZone, gridSystem.insertComponent(1, 0, 12, 1));
		
		setVisible(true);
	}
	
}
