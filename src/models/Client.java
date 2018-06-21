package models;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import controller.Control;



public class Client extends Connection{

	private String name;
	private GameManager gameManager;

	public Client(String ip, int port, String name) throws IOException{
		super(ip, port);
		this.name = name;
	}

	@Override
	void executeTask() {
		try {
			String string = readResponse();
			switch (string) {
			case "/message":
//				showMessage(string);
				break;
			case "MULTIPLAYER":
				send(String.valueOf(gameManager.getPlayer().getPlayer().getX()));
				send(String.valueOf(gameManager.getPlayer().getPlayer().getY()));
				break;
			default:
				break;
			}
		} catch (IOException e) {
		}
	}
//
//	private void showMessage(String[] string) {
//		if (!string[1].equals(name)) {
////			Controller.showMessage(string);
//		}
//	}

	public void saveFile() {
		try{
			setInput(new DataInputStream(getSocket().getInputStream()));
			String nameFile = getInput().readUTF().toString();
			int tam = getInput().readInt();
			FileOutputStream fos = new FileOutputStream(new File("src/datos/" + nameFile));
			BufferedOutputStream out = new BufferedOutputStream(fos);
			BufferedInputStream in = new BufferedInputStream(getSocket().getInputStream());
			byte[] buffer = new byte[tam];
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = (byte) in.read();
			}
			out.write(buffer);
			out.flush();
		} catch (IOException e1) {
			System.out.println("Recibir "+ e1.toString());
		}
	}

	public String getName() {
		return name;
	}
	
	public void setGame(GameManager game) {
		this.gameManager = game;
	}

}