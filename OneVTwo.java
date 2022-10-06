package oneVtwo;

import java.util.Random;

// Little rng game.  Player one vs Player two 
public class OneVTwo {

	public static void main(String[] args) {
		// Starting health values and method call
		double playerOne = 100;
		double playerTwo = 100;
		oneVsTwo(playerOne, playerTwo);
	}

	// Method where most of the stuff happens
	static void oneVsTwo(double playerOne, double playerTwo) {

		// This is the starting and main loop
		// Player two starts first
		while (playerOne > 0 || playerTwo > 0) {
			System.out.println("Player ONE has " + playerOne + " health");
			// This calls roll method. A simple rng generator
			// Determines how much damage is dealt to the overall health
		int damage = 20 + roll();
			// Damage reduced for player2 to make the winning more fair/even
			double reduceDmg = damage * .9;
			// Rounder to clean up decimal places
			double reduceRoundedDmg = Math.round(reduceDmg * 100.0) / 100.0;
			double p1 = playerOne - reduceRoundedDmg;
			double p1Rounded = Math.round(p1 * 100.0) / 100.0;
			playerOne = p1Rounded;

			System.out.println("Player TWO hits player ONE for " + reduceRoundedDmg + " damage");
			System.out.println("pPlayer ONE now has " + playerOne + " health");
		System.out.println();
			// For when player two wins. Prints final results and exits
		if (playerOne <= 0) {
				System.out.println("---------Player TWO wins---------");
				System.out.println("Player ONE has " + playerOne + " health");
				System.out.println("Player TWO has " + playerTwo + " health");
			return;
		}

		// Player one swings/damage dealt
		// Mostly the same as above just without damage reducer
		System.out.println("Player TWO has " + playerTwo + " health");
		damage = 20 + roll2();
		double rounded = Math.round(damage * 100.0) / 100.0;
		playerTwo = playerTwo - rounded;
		System.out.println("Player ONE hits player TWO for " + rounded + " damage");
		System.out.println("Player TWO now has " + playerTwo + " health");
		System.out.println();

		if (playerTwo <= 0) {
			System.out.println("=====Player ONE wins=====");
			System.out.println("Player ONE has " + playerOne + " health");
			System.out.println("Player TWO has " + playerTwo + " health");
			return;
		}
	}

	}

// Basic rng generator for player one
	static int roll() {
		Random ran = new Random();
		int rand = ran.nextInt(25);
		return rand;
	}

	// Basic rng generator for player two
	static int roll2() {
		Random ran = new Random();
		int rand = ran.nextInt(25);
		return rand;
	}

}
