package com.cbstllo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author CLaudine Bustillo
 * This game is played by one or two players, there are two modes: One Player mode and Two Player Mode
 * One player mode: Program gives random word to the player.
 * Two player mode: Random Player will give the word to be guessed
 *
 */
public class Hangman2022 {
	 public static void main(String[] args) throws FileNotFoundException {  
		 Messages message= new Messages();
		 message.introduction();   
		 
		 Scanner input = new Scanner(System.in);
		    
		 	//Start of the Game
		    message.start();
		    String players = input.nextLine();
		    
		    String word;
		    
		    //One Player-mode
		    if (players.equals("1")) {
		      message.player1();
		      Scanner scanner = new Scanner(new File("C:\\Users\\MARIBELL\\Desktop\\HANGMAN GAME\\dictionary.txt"));
		      List<String> rndmword = new ArrayList<>();
		      
		    //searches for a random text in our .txt file
		      while (scanner.hasNext()) {
		        rndmword.add(scanner.nextLine());
		      }
		      Random rndm = new Random();
		      word = rndmword.get(rndm.nextInt(rndmword.size()));   //picks random index to come up with a random word
		      word=word.toLowerCase();
		    }
		    
		    //Two Player Mode
		    else {
		      message.player2();
		      message.enterWord();
		      word = input.nextLine();
		      word=word.toLowerCase();
		      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		      message.enterAnswer();
		    }
		    
		    //System.out.println(word);
		    
		    List<Character> playerGuesses = new ArrayList<>();
		    
		    Integer wrongCount = 0;
		    
		    while(true) {
		      printHangedMan(wrongCount);
		      
		      if (wrongCount >= 6) {
		        message.gameOver();
		        System.out.println("The word was: " + word);
		        break;
		      }
		      
		      printWordState(word, playerGuesses);
		      if (!getPlayerGuess(input, word, playerGuesses)) {
		        wrongCount++;
		      }
		      
		      if(printWordState(word, playerGuesses)) {
		        message.rightAnswer();
		        break;
		      }
		      
		      message.tryAnswer();
		      if(input.nextLine().equals(word)) {
		        message.rightAnswer();
		        break;
		      }
		      else {
		        message.notTheAnswer();
		      }
		    }
		  }
	 /**
	  * method that draws a hangman, everytime the player's guess is wrong.
	  * @param wrongCount
	  */

		  private static void printHangedMan(Integer wrongCount) {
		    System.out.println(" -------");
		    System.out.println(" |     |");
		    if (wrongCount >= 1) {
		      System.out.println(" O");
		    }
		    
		    if (wrongCount >= 2) {
		      System.out.print("\\ ");
		      if (wrongCount >= 3) {
		        System.out.println("/");
		      }
		      else {
		        System.out.println("");
		      }
		    }
		    
		    if (wrongCount >= 4) {
		      System.out.println(" |");
		    }
		    
		    if (wrongCount >= 5) {
		      System.out.print("/ ");
		      if (wrongCount >= 6) {
		        System.out.println("\\");
		      }
		      else {
		        System.out.println("");
		      }
		    }
		    System.out.println("");
		    System.out.println("");
		  }
		  /**
		   * handles the player's guess
		   * @param input
		   * @param rndmword
		   * @param playerGuesses
		   * @return
		   */
		  private static boolean getPlayerGuess(Scanner input, String rndmword, List<Character> playerGuesses) {
		    System.out.println("Please enter a letter:");
		    String letterGuess = input.nextLine();
		    playerGuesses.add(letterGuess.charAt(0));
		    
		    return rndmword.contains(letterGuess);
		  }

		  /**
		   * everytime player gives right let
		   * @param word
		   * @param playerGuesses
		   * @return
		   */
		  private static boolean printWordState(String word, List<Character> playerGuesses) {
		    int correctCount = 0;
		    for (int i = 0; i < word.length(); i++) {
		      if (playerGuesses.contains(word.charAt(i))) {
		        System.out.print(word.charAt(i));
		        correctCount++;
		      }
		      else {
		        System.out.print("-");
		      }
		    }
		    System.out.println();
		    
		    return (word.length() == correctCount);
	}
}
