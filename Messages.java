package com.cbstllo;
/**
 * 
 * class where all the messages are stored.
 */
public class Messages {
	public void introduction() {
		System.out.println("Welcome to HANGMAN, this game is played by one or two players."
				+ "\n\nOne Player Mode: Program gives random number for the player to guess"
				+ "\nTwo Player Mode: Random player will be picked from the group, and will give out the word to be guessed"
				+ "by the rest of the player");
		System.out.println("*********************************************************************************");
	}
	/**
	 * message printed out at the beginning of the game
	 */
	public void start() {
		System.out.println("Choose mode:\nOne Player Mode press (1)\nTwo Player Mode press (2)");
	}
	/**
	 * message printed if user chooses to play One Player Mode
	 */
	
	public void player1() {
		System.out.println("You Choose: One Player Mode");
	}
	/**
	 * message printed if user chooses to play Two Player Mode
	 */
	public void player2() {
		System.out.println("You Choose: Two Player Mode");
	}
	/**
	 * message printed if program wants Player 1 to enter the name, to be guessed by player 1
	 */
	public void enterWord() {
		System.out.println("Player 1: Enter your word here:");
	}
	/**
	 * message printed program tells Player 2 to take a guess
	 */
	public void enterAnswer() {
		System.out.println("Player 2: Your turn to guess the word");
	}
	/**
	 * message printed program if player guessed the right word
	 */
	public void rightAnswer() {
		System.out.println("Yey! You got the right Answer! ");
	}
	/**
	 * message printed program tells Player 2 to guess the word
	 */
	public void tryAnswer() {
		System.out.println("Now, try to guess the word:");
	}
	
	/**
	 * message printed if player's 2 guess of the word is wrong.
	 */
	public void notTheAnswer() {
		System.out.println("Nope, that's not the word");
	}
	
	/**
	 * message printed program tells if player maximized his life and didn't get the right answer
	 */
	public void gameOver() {
		System.out.println("GAME OVER!");
	}
}
