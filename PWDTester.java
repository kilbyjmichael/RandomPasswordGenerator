package com.kilby;

public class PWDTester
{

	public static void main(String[] args)
	{
		RandomPasswordGenerator pd = new RandomPasswordGenerator();
		
		//System.out.println(pd.generatePassword(10, .7, .3));
		
		for(int ten = 1; ten < 10; ten++)
		{
			System.out.println(pd.generatePassword(ten, 0.7, 0.3, "numbers"));
		}
	}

}
