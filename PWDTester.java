package com.kilby;

public class PWDTester
{

	public static void main(String[] args)
	{
		RandomPasswordGenerator pd = new RandomPasswordGenerator();
		
		//System.out.println(pd.generatePassword(10, .7, .3));
		
		for(int ten = 1; ten < 10; ten++)
		{
			System.out.println(pd.generatePassword(ten, .3, .7, "chars"));
		}
	}

}
