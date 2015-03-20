package com.kilby;

/**
 * A class that generates a random password according to a set of rules.
 *
 * @author Michael Kilby
 *
 */
public class RandomPasswordGenerator
{
	private int passwordLength;
	private StringBuilder password = new StringBuilder();
	private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private int randomNumber(int min, int max)
	{
	   int range = (max - min) + 1;
	   return (int)(Math.random() * range) + min;
	}
	
	private String generateNumbers(double percent)
	{
		StringBuilder numPass = new StringBuilder();
			for (int y = 0; y < percent; y++)
			{
				int numForPass = randomNumber(1,10);
				//int random = (int)(Math.random() * 10 + 1);
				numPass.append(numForPass);
			}
		return numPass.toString();
	}
	
	private String generateChars(double percent)
	{
		StringBuilder charPass = new StringBuilder();
		for (int x = 0; x < percent; x++)
		{
			int charForPass = randomNumber(1,51); //51 because strings start at 0
			//int charForPass = (int)(Math.random() * 52 + 1);
			char alphaPass = alphabet.charAt(charForPass);
			charPass.append(alphaPass);
		}
		return charPass.toString();
	}
	
	public String generatePassword(int length, double numPercent, double charPercent, String order)
	{
		//clear vars
		this.passwordLength = length;
		password.setLength(0);
		
		//create the correct lengths
		numPercent *= length;
		charPercent *= length;

		//generate in order
		if(order == "numbers")
		{
			password.append(generateNumbers(numPercent));
			password.append(generateChars(charPercent));
		}
		if(order == "chars")
		{
			password.append(generateChars(charPercent));
			password.append(generateNumbers(numPercent));	
		}
		
		return password.toString();
	}
}
