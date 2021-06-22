import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Welcome to Hangman");		
		File dictionary = new File("/Users/juliake/Desktop/JavaPrograms/Hangman/src/engmix.txt");
		
		Scanner textScanner = new Scanner(dictionary);
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> words = new ArrayList<>();
		
		while(textScanner.hasNext()) {
			words.add(textScanner.nextLine());
		}
		
		String hidden_text = words.get((int)(Math.random() * words.size()));
		char[] textArray = hidden_text.toCharArray();
		
		char[] myAnswers = new char[textArray.length];
		for(int i = 0; i < textArray.length; i++) {
			myAnswers[i] = '?';
		}
		
		boolean finished = false;
		int lives = 6;
		
		while(finished == false) {
			System.out.println("**************************");
			
			String letter = input.next();
			//checks for a valid input
			while(letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
				System.out.println("Error input - try again");
				letter = input.next();
			}
			
			//checks if letter is in the word
			
			boolean found = false;
			for(int i = 0; i < textArray.length; i++) {
				if(letter.charAt(0) == textArray[i]) {
					myAnswers[i] = textArray[i];
					found = true;
				}
			}
			
			if(!found) {
				lives--;
				
				System.out.println("Wrong Letter");
			}
			
			boolean done = true;
			for(int i = 0; i < myAnswers.length; i++) {
				if(myAnswers[i] == '?') {
					System.out.print(" _");
					done = false;
				}else {
					System.out.print(" " + myAnswers[i]);
				}
			}
			
			System.out.println("\n" + "Lives left: " + lives);
			drawHangman(lives);
			
			//check if the game ends
			if(done) {
				System.out.println("Congrats you found the word");
				finished = true;
			}
			
			if(lives <= 0 ) {
				System.out.println("You are dead! Study your English");
				finished = true;
			}
		}
		
		System.out.println("The word was " + hidden_text);
		
	}
		
		public static void drawHangman(int l) {
			  if(l == 6) {
			   System.out.println("|----------");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 5) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 4) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|    |");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 3) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 2) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else if(l == 1) {
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|   /");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			  else{
			   System.out.println("|----------");
			   System.out.println("|    O");
			   System.out.println("|   -|-");
			   System.out.println("|   /|");
			   System.out.println("|");
			   System.out.println("|");
			   System.out.println("|");
			  }
			 

	}

}
