package com.cipherbyte;

import java.util.Random;

import javax.swing.JOptionPane;

public class GuessTheNumber {
	public static void main(String[] args) {
		final int MIN_RANGE=1;
		final int MAX_RANGE=100;
		final int MAX_ATTEMPTS=5;
		
		int randomNumber=generateRandomNumber(MIN_RANGE,MAX_RANGE);
		int attempts=0;
		
		JOptionPane.showMessageDialog(null, "Welcome to Guess the Number Game!");
		
		while(attempts<MAX_ATTEMPTS) {
			String input=JOptionPane.showInputDialog("Enter your guess between "+MIN_RANGE+" and "+MAX_RANGE+":");
			
			if(input==null) {
				JOptionPane.showMessageDialog(null,"Thank you for playing.Goodbye!");
				System.exit(0);
			}
			
			int guess=Integer.parseInt(input);
			attempts++;
			
			if(guess==randomNumber) {
				JOptionPane.showMessageDialog(null, "Congratulations!You've guessed the number "+randomNumber+" in "+attempts+" attempts.");
				System.exit(0);
			}
			else if(guess<randomNumber) {
				JOptionPane.showMessageDialog(null, "Too low!Try again.");
			}
			else {
				JOptionPane.showMessageDialog(null, "Too high!Try again.");
			}
		}
		
		JOptionPane.showMessageDialog(null,"Sorry,you've used all your attempts.The number was "+randomNumber);
	}
	
	public static int generateRandomNumber(int min,int max) {
		Random random=new Random();
		return  random.nextInt(max-min+1)+min;
	}
}
