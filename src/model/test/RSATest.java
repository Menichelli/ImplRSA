package model.test;

import java.math.BigInteger;

import model.RSA;


public class RSATest {

	public static void main(String[] args) {
		BigInteger n, p, q, e, m, c, d, M;
		String phrase;
			
		phrase = "cat";
		
		p = new BigInteger("885320963"); 						// Premier nombre premier		- Priv�
		q = new BigInteger("238855417");						// Deuxieme nombre premier		- Priv�
		n = p.multiply(q);										// p*q							- Public
		e = new BigInteger("9007");								// Exposant de chiffrement		- Public
		m = RSA.toBigInteger(phrase);							// Message en clair				- Priv�
		c = RSA.chiffrementRSA(m, e, n);						// Message chiffr�				- Public
		d = new BigInteger("116402471153538991");				// Exposant de d�chiffrement	- Priv�
		M = RSA.dechiffrementRSA(c, d, n);						// Message d�chiffr� 			- Priv�
		
		
		System.out.println("Message en clair : " + phrase);
		
		System.out.println("Nombre premier p 		    : " + p);
		System.out.println("Nombre premier q 		    : " + q);
		System.out.println("Nombre premier n 		    : " + n);
		System.out.println("Exposant de chiffrement e   : " + e);
		System.out.println("Message en clair m 		    : " + m);
		System.out.println("message chiffre c		    : " + c);
		System.out.println("Exposant de dechiffrement d : " + d);
		System.out.println("Message d�crypt� M          : " + M);
		System.out.println(new String(M.toByteArray()));
	}
}
