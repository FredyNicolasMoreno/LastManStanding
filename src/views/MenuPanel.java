package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Actions;
import controller.Control;

public class MenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private GridSystem grid;

	public MenuPanel(Control control) {
		this.addKeyListener(control);
		setBackground(Color.BLACK);
		
		grid = new GridSystem(this);
		grid.addExternalBorder(10, 10, 10, 10);
		
		JLabel label = new JLabel(reSize(new ImageIcon(getClass().getResource("/resources/lmsLogo.jpg"))));
		add(label, grid.insertComponent(0, 5, 5, 0.8));
		
		JButton newGame = new JButton("Tutorial");
		newGame.setBorderPainted(false);
		newGame.setFont(new Font("Agency FB", Font.BOLD, 40));
		newGame.setBackground(new Color(110, 34, 0));
		newGame.setForeground(new Color(0,168,165));
		newGame.addActionListener(control);
		newGame.setActionCommand(Actions.NEW_GAME.toString());
		add(newGame, grid.insertComponent(1, 4, 3, 0.3));
		
		JButton multiPlayer = new JButton("MultiPlayer");
		multiPlayer.setBorderPainted(false);
		multiPlayer.setFont(new Font("Agency FB", Font.BOLD, 40));
		multiPlayer.setBackground(new Color(110, 34, 0));
		multiPlayer.setForeground(new Color(0,168,165));
		add(multiPlayer, grid.insertComponent(1, 7, 2, 0.3));
		
		JButton settings = new JButton("Settings");
		settings.setBorderPainted(false);
		settings.setFont(new Font("Agency FB", Font.BOLD, 40));
		settings.setBackground(new Color(110, 34, 0));
		settings.setForeground(new Color(0,168,165));
		add(settings, grid.insertComponent(1, 9, 0, 1));
		
		
	}
	
	public Icon reSize(ImageIcon imagen){
		Image tamanio = (imagen.getImage()).getScaledInstance(1500, 500, Image.SCALE_SMOOTH);
		return new ImageIcon(tamanio);
	}
	
}
