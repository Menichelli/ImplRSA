package model;

import java.math.BigInteger;
import java.util.Scanner;


public class RSA {
	
	public static BigInteger toBigInteger(String phrase)
	{
		byte[] m_byte = phrase.getBytes();
		BigInteger m;
		m = new BigInteger(m_byte);
		
		return m;
	}
	
	public static BigInteger saisirMessageEnClair()
	{
		String phrase;
		int i,j;
		BigInteger m;
		Scanner sc = new Scanner(System.in);
		System.out.print("Saisir le message � chiffrer : ");
		phrase = sc.next();
		m = RSA.toBigInteger(phrase);
		
		return m;
	}
	
	
	
	public static BigInteger chiffrementRSA(BigInteger m, BigInteger e, BigInteger n)
	{
		BigInteger c;
		
		c = m.modPow(e, n);
		
		return c;
	}
	
	public static BigInteger dechiffrementRSA(BigInteger c, BigInteger d, BigInteger n)
	{
		BigInteger M;
		M = c.modPow(d,n);
		
		return M;
	}
}

