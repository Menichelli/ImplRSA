package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.MyListener;

public class AssemblyFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static AssemblyFrame instance;
	
	public JTextArea textAreaKeys, textAreaMessage;
	public JButton buttonOK,buttonRandom;
	
	private AssemblyFrame() {
		this.setTitle("Assemblage du message");
		this.setSize(450, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout(30, 10);
		panel.setLayout(layout);

		this.setContentPane(panel);

		//NORTH
		
		//CENTER
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(2, 1));
		
		//--CENTER1
		JPanel panelCenter1 = new JPanel();
		panelCenter1.add(new JLabel("saisir les ensembles de cle/valeur",JLabel.CENTER));
		textAreaKeys = new JTextArea(4, 35);
		JScrollPane scrollAreaKeys = new JScrollPane(textAreaKeys);
		panelCenter1.add(scrollAreaKeys);
		
		//--CENTER2
		JPanel panelCenter2 = new JPanel();
		panelCenter2.add(new JLabel("Liste des couples (argument,valeur)",JLabel.CENTER));
		textAreaMessage = new JTextArea(4, 35);
		textAreaMessage.setEditable(false);
		JScrollPane scrollAreaMessage = new JScrollPane(textAreaMessage);
		panelCenter2.add(scrollAreaMessage);
		
		panelCenter.add(panelCenter1);
		panelCenter.add(panelCenter2);
		
		//SOUTH
		JPanel panelSouth = new JPanel();
		buttonOK = new JButton("Assembler");
		buttonOK.addActionListener(MyListener.getInstance());
		panelSouth.add(buttonOK);


		//Assembly
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelSouth, BorderLayout.SOUTH);
	}
	
	public static AssemblyFrame getInstance() {
		instance=(instance==null)?new AssemblyFrame():instance;
		return instance;
	}
	
}
