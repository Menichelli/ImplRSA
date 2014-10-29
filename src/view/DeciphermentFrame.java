package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.MyListener;

public class DeciphermentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static DeciphermentFrame instance;

	public JTextArea textAreaMessage, textAreaCypher;
	public JButton buttonOK;

	private DeciphermentFrame() {
		this.setTitle("Dechiffrement RSA");
		this.setSize(300, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout(30, 10);
		panel.setLayout(layout);

		this.setContentPane(panel);

		//NORTH PANEL
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(1, 1));

		JPanel panelNorth1 = new JPanel();
		panelNorth1.setLayout(new FlowLayout(FlowLayout.TRAILING));
		panelNorth1.add(new JLabel("exposant de dechiffrement"));
		panelNorth1.add(new JTextField(9));
		
		panelNorth.add(panelNorth1);

		//CENTER PANEL
		JPanel panelCenter = new JPanel();
		panelCenter.add(new JLabel("Saisir le message chiffre"));
		textAreaCypher = new JTextArea(3, 24);
		JScrollPane scrollAreaCypher = new JScrollPane(textAreaCypher);
		panelCenter.add(scrollAreaCypher);
		panelCenter.add(new JLabel(""));
		panelCenter.add(new JLabel("Message en clair"));
		textAreaMessage = new JTextArea(3, 24);
		textAreaMessage.setEditable(false);
		JScrollPane scrollAreaMessage = new JScrollPane(textAreaMessage);
		panelCenter.add(scrollAreaMessage);

		//SOUTH PANEL
		JPanel panelSouth = new JPanel();
		buttonOK = new JButton("Dechiffrer");
		buttonOK.addActionListener(MyListener.getInstance());
		panelSouth.add(buttonOK);

		//Assembly
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelSouth, BorderLayout.SOUTH);
	}

	public static DeciphermentFrame getInstance() {
		instance = (instance==null)? new DeciphermentFrame():instance;
		return instance;
	}

}
