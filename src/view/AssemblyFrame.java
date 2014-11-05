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

public class AssemblyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static AssemblyFrame instance;

	public JTextField tfPrimeNumber;
	public JTextArea textAreaKeys, textAreaMessage;
	public JButton buttonOK,buttonRandom,buttonCopyKeys,buttonCopyPrime;

	private AssemblyFrame() {
		this.setTitle("Assemblage du message");
		this.setSize(450, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout(30, 10);
		panel.setLayout(layout);

		this.setContentPane(panel);

		//NORTH
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(1, 1));

		JPanel panelNorth1 = new JPanel();
		panelNorth1.setLayout(new FlowLayout(FlowLayout.TRAILING));
		buttonCopyPrime = new JButton("Copier");
		buttonCopyPrime.addActionListener(MyListener.getInstance());
		panelNorth1.add(buttonCopyPrime);
		panelNorth1.add(new JLabel("nombre premier"));
		tfPrimeNumber = new JTextField(10);
		panelNorth1.add(tfPrimeNumber);

		panelNorth.add(panelNorth1);
		
		//CENTER
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(2, 1));

		//--CENTER1
		JPanel panelCenter1 = new JPanel();
		JPanel panelCenter11 = new JPanel();
		panelCenter11.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonCopyKeys = new JButton("Copier");
		buttonCopyKeys.addActionListener(MyListener.getInstance());
		panelCenter11.add(buttonCopyKeys);
		panelCenter11.add(new JLabel("Saisir les ensembles de cle/valeur",JLabel.CENTER));
		panelCenter1.add(panelCenter11);
		textAreaKeys = new JTextArea(5, 35);
		JScrollPane scrollAreaKeys = new JScrollPane(textAreaKeys);
		panelCenter1.add(scrollAreaKeys);

		//--CENTER2
		JPanel panelCenter2 = new JPanel();
		panelCenter2.add(new JLabel("Message",JLabel.CENTER));
		textAreaMessage = new JTextArea(5, 35);
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
		panel.add(panelNorth, BorderLayout.NORTH);
		panel.add(panelCenter, BorderLayout.CENTER);
		panel.add(panelSouth, BorderLayout.SOUTH);
	}

	public static AssemblyFrame getInstance() {
		instance=(instance==null)?new AssemblyFrame():instance;
		return instance;
	}

}
