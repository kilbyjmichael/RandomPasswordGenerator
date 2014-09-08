package com.kilby;

import java.util.Scanner;

/**
 * A program that generates a random password according to a set of rules
 *
 * @author Michael Kilby
 *
 */
public class RandomPasswordGenerator
{
	/**
	 * @param args
	 */

	public static void main(String[] args)
	{
		int passwordLength;
		System.out.print("Enter the length of the outputted password: ");
		Scanner askNum = new Scanner(System.in);
		passwordLength = askNum.nextInt();
		askNum.close(); //done with getting number
		
		double sevPercent = .7 * passwordLength; //numbers
		double tenPercent = .3 * passwordLength; //letters
		
//begin number generating loop
		StringBuilder numPass = new StringBuilder();	
		for (int y = 0; y < sevPercent; y++)
		{
			int random = (int)(Math.random() * 10 + 1);
			numPass.append(random);
		}
//end loop
		
//begin character generating loop
		StringBuilder charPass = new StringBuilder();
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int x = 0; x < tenPercent; x++)
		{
			int charForPass = (int)(Math.random() * 52 + 1);
			char alphaPass = 'a';
			alphaPass = alphabet.charAt(charForPass);
			numPass.append(alphaPass);
		}
//end loop
		
		System.out.println(numPass);
		System.out.println(charPass);
	}

}
