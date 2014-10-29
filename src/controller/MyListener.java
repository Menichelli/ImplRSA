package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

import model.RSA;
import model.Share;
import view.DeciphermentFrame;
import view.EncryptionFrame;
import view.MainWindow;
import view.SharingFrame;

public class MyListener implements ActionListener {
	
	private static MyListener instance;
	
	private final static int PRIME_LENGHT = 1024;
	
	private MyListener() {}
	
	public static MyListener getInstance() {
		instance = (instance==null)?new MyListener():instance;
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src==MainWindow.getInstance().buttonEncryption) {
			EncryptionFrame.getInstance().setVisible(true);
		} else if(src==MainWindow.getInstance().buttonDecipherment) {
			DeciphermentFrame.getInstance().setVisible(true);
		} else if(src==MainWindow.getInstance().buttonSharing) {
			SharingFrame.getInstance().setVisible(true);
		} else if(src==MainWindow.getInstance().buttonAssembly) {
			
			
			//TODO
		} else if(src==EncryptionFrame.getInstance().buttonOK) {
			BigInteger exponent = new BigInteger(EncryptionFrame.getInstance().tfExponent.getText());
			BigInteger module = new BigInteger(EncryptionFrame.getInstance().tfModule.getText());
			String message = EncryptionFrame.getInstance().textAreaMessage.getText();
			BigInteger cypher = RSA.chiffrementRSA(message, exponent, module);
			EncryptionFrame.getInstance().textAreaCypher.setText(cypher.toString());
		} else if(src==DeciphermentFrame.getInstance().buttonOK) {
			BigInteger exponent = new BigInteger(DeciphermentFrame.getInstance().tfExponent.getText());
			BigInteger module = new BigInteger(DeciphermentFrame.getInstance().tfModule.getText());
			BigInteger cypher = new BigInteger(DeciphermentFrame.getInstance().textAreaCypher.getText());
			String message = RSA.dechiffrementRSA(cypher, exponent, module);
			DeciphermentFrame.getInstance().textAreaMessage.setText(message);
		} else if(src==SharingFrame.getInstance().buttonRandom) {
			SharingFrame.getInstance().tfPrime.setText(
					new String(
							BigInteger.probablePrime(PRIME_LENGHT, new Random())
							.toString()));
		} else if(src==SharingFrame.getInstance().buttonOK) {
			BigInteger primeNumber = new BigInteger(SharingFrame.getInstance().tfPrime.getText());
			if(!primeNumber.isProbablePrime(1000)) {
				throw new IllegalArgumentException("le nombre saisi n'est pas premier!");
			}
			int totalShares = Integer.parseInt(SharingFrame.getInstance().tfTotalShares.getText());
			int minimalShares = Integer.parseInt(SharingFrame.getInstance().tfMinimalShares.getText());
			
			String message = SharingFrame.getInstance().textAreaMessage.getText();
			
			Map<Integer,BigInteger> res = Share.shareMessage(primeNumber, totalShares, minimalShares, message);
			SharingFrame.getInstance().textAreaKeys.setText("");
			for(Integer key : res.keySet()) {
				SharingFrame.getInstance().textAreaKeys.append("cle: "+key+"\tvaleur: "+res.get(key)+"\n");
			}
		}
	}

}
