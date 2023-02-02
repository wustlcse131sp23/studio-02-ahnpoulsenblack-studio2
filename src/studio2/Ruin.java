package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter start amount: ");
		double startAmount = in.nextDouble();
		System.out.println("Enter win chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter win limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Enter total simulations: ");
		int totalSimulations = in.nextInt();
		int simCount = 0;
		int winCount = 0;
		int loseCount = 0;
		
		
		while (((startAmount > 0)&&(startAmount < winLimit))&&simCount<=totalSimulations) {
		//for (double startAmount = 500; (startAmount > 0)||(startAmount < 1000); totalSimulations++) {
			if (Math.random() < winChance)
				{
					startAmount = startAmount + 1;
					winCount++;
				}
				else
				{
					startAmount = startAmount - 1;
					loseCount++;
				}
				simCount++;
				System.out.println("Balance: " + startAmount);
			
				
		}
		if (startAmount == 0)
		{
			System.out.println("Ruin!");
		}
		if(startAmount == winLimit)
		{
			System.out.println("You're a winner son!");
		}
		System.out.println("Simulation count: " + simCount);
		System.out.println("Loses: " + loseCount);
		System.out.println("Wins: " + winCount);
		
		double expectedRuin;
		if(winChance == 0.5) 
		{
		expectedRuin = 1 - startAmount/winLimit;
		System.out.println("Expected ruin: " + expectedRuin);
		}
		else {
			double alpha = (1-winChance)/winChance;
			expectedRuin = (Math.pow(alpha, startAmount)- Math.pow(alpha, winLimit)/(1-Math.pow(alpha, winLimit)));
			System.out.println("Expected ruin: " + expectedRuin);
		}
		
	}

}
