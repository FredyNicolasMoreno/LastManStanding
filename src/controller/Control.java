package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.MainWindow;

public class Control implements ActionListener{

	private MainWindow mainWindow;
	
	public Control() {
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Actions.valueOf(e.getActionCommand())) {
		case NEW_GAME:
			mainWindow.newGame();
			break;

		default:
			break;
		}
	}
	
}
