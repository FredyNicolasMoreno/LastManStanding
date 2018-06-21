package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Actions;
import controller.Control;

public class DialogRegsitry extends JDialog{

	private static final long serialVersionUID = 1L;
	private JTextField tfName, txtIP, txtPort;
	private TitledBorder userName, ip, port;
	private JButton btnAccept;

	public DialogRegsitry(Control controller) {
		setLocationRelativeTo(null);
		setSize(250, 300);

		setLayout(new BorderLayout());
	
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.BLACK);
		pnlCenter.setLayout(new GridLayout(2, 1));
		add(pnlCenter, BorderLayout.CENTER);
		
		tfName = new  JTextField();
		tfName.setBackground(Color.BLACK);
		tfName.setForeground(new Color(0,168,165));
		userName = new TitledBorder("Username");
		userName.setTitleColor(new Color(0,168,165));
		tfName.setBorder(userName);
		pnlCenter.add(tfName);

		txtIP = new  JTextField();
		txtIP.setBackground(Color.BLACK);
		ip = new TitledBorder("IP");
		ip.setTitleColor(new Color(0,168,165));
		txtIP.setForeground(new Color(0,168,165));
		txtIP.setBorder(ip);
		pnlCenter.add(txtIP);

		txtPort = new  JTextField();
		txtPort.setBackground(Color.BLACK);
		port = new TitledBorder("Port");
		port.setTitleColor(new Color(0,168,165));
		txtPort.setForeground(new Color(0,168,165));
		txtPort.setBorder(port);
		pnlCenter.add(txtPort);
		
		btnAccept = new JButton("Registry");
		btnAccept.setActionCommand(Actions.ACCEPT.toString());
		btnAccept.addActionListener(controller);
		btnAccept.setBorderPainted(false);
		btnAccept.setFont(new Font("Agency FB", Font.BOLD, 40));
		btnAccept.setBackground(new Color(110, 34, 0));
		btnAccept.setForeground(new Color(0,168,165));;
		add(btnAccept, BorderLayout.SOUTH);
	}	
	
	
	public String getName(){
		return tfName.getText();
	}


	public String getIP() {
		return txtIP.getText();
	}

	public String getTxtPort() {
		return txtPort.getText();
	}
	
}
