package com.kilby;

/**
 * The RandomPasswordGenerator generates a password that consists of
 * letters and numbers using the psudo-random Random class.
 *
 * @author Michael Kilby
 * @version 2.1.2: Mar 19, 2015
 *
 */
public class RandomPasswordGenerator
{
	private StringBuilder password = new StringBuilder();
	private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * The randomNumber method generates a random number using a given range.
	 * 
	 * @param min This is the minimum number of the random range.
	 * @param max This is the maximum number of the random range.
	 * @return int This returns a psudo-random number using the range of max - min.
	 */
	private int randomNumber(int min, int max)
	{
	   int range = (max - min) + 1;
	   return (int)(Math.random() * range) + min;
	}
	
	/**
	 * The generateNumbers method generates an amount of numbers according to a given percentage.
	 * 
	 * @param percent This is the percent of the password that is numbers.
	 * @return <b>String</b> This returns the number part of the password.
	 */
	private String generateNumbers(double percent)
	{
		StringBuilder numPass = new StringBuilder();
			for (int y = 0; y <= percent; y++)
			{
				int numForPass = randomNumber(1,10);
				numPass.append(numForPass);
			}
		return numPass.toString();
	}
	
	/**
	 * The generateChars method generates an amount of letters according to a given percentage.
	 * 
	 * @param percent This is the percent of the password that is characters.
	 * @return <b>String</b> This returns the character part of the password.
	 */
	private String generateChars(double percent)
	{
		StringBuilder charPass = new StringBuilder();
		for (int x = 0; x <= percent; x++)
		{
			char alphaPass = alphabet.charAt(randomNumber(1,51));//51 because strings start at 0
			charPass.append(alphaPass);
		}
		return charPass.toString();
	}
	
	/**
	 * The generatePassword method generates a string using given numbers and an order.
	 * 
	 * @param length This is the length of the password.
	 * @param numPercent This is the percent of the password that is numbers.
	 * @param charPercent This is the percent of the password that is letters.
	 * @param order This is the order that numbers and letters come in the password. "numbers" means numbers first, "chars" means letters first.
	 * @return <b>String</b> This is the final password.
	 */
	public String generatePassword(int length, double numPercent, double charPercent, String order)
	{
		//clear vars
		password.setLength(0);
		
		//create the correct lengths
		numPercent *= length;
		charPercent *= length;

		//generate in order
		if(order == "numbers")
		{
			password.append(generateNumbers((int)numPercent));
			password.append(generateChars((int)charPercent));
		}
		if(order == "chars")
		{
			password.append(generateChars((int)charPercent));
			password.append(generateNumbers((int)numPercent));	
		}
		
		return password.toString();
	}
}
