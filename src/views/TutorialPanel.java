package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import controller.Control;

public class TutorialPanel extends JFrame{

	private static final long serialVersionUID = 1L;
	private GridSystem gridSystem;
	private TutorialPanelGameZone gameZone;
	
	public TutorialPanel(Rectangle player, Rectangle gun, Rectangle bullet, Control control) {
		
		setExtendedState(MAXIMIZED_BOTH);
		
		addKeyListener(control);
		
		JPanel panel = new JPanel();
		
		gridSystem = new GridSystem(panel);
		gridSystem.addExternalBorder(10, 10, 10, 10);
		panel.setBackground(Color.BLACK);
	
		JTextPane pane = new JTextPane();
		pane.addKeyListener(control);
		pane.setForeground(Color.WHITE);
		pane.setBackground(Color.BLACK);
		pane.setBorder(null);
		pane.setEditable(false);
		pane.setFont(new Font("Arial", Font.BOLD, 40));
		pane.setText("Tutorial\n"
				+ "En este juego debes eliminar a tus oponentes con la ayuda de armas que caen por el mapa.\n"
				+ "El movimiento de tu personaje es controlado con las teclas ← →,\n"
				+ "el salto con la BARRA ESPACIADORA y el disparo con la tecla Z");
		
		panel.add(pane, gridSystem.insertComponent(0, 0, 12, 0.1));
		
		gameZone = new TutorialPanelGameZone(player, gun, bullet, control);
		panel.add(gameZone, gridSystem.insertComponent(1, 0, 12, 1));
		
		add(panel);
	}
	
	public void repaintAll(Rectangle player, Rectangle gun, Rectangle bullet) {
		gameZone.setAll(player, gun, bullet);
		repaint();
		
	}
	
}
