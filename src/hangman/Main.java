package hangman;

import java.util.Scanner;

public class Main {
	
	static String[] word;
	static int tries;
	
	public static void main(String[] args) {
		
		word = new String[1];
		
		setupWord();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hangman");
		
		
		
	}
	
	static void setupWord() {
		
		word = new String[1];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("word: ");
		
		String tWord = scanner.nextLine();
		
		word[0] = tWord;
		
	}
	
}
