package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static String[] board;
	static String turn;
	static String winner;
	static int moves;
	
	public static void main(String[] args) {
		
		board = new String[9];
		Random random = new Random();
		int randomTurn = random.nextInt(2);
		if (randomTurn == 0) { turn = "x";} else if (randomTurn == 1) { turn = "o";} //randomize turn
		winner = null;
		Scanner scanner = new Scanner(System.in);
		Boolean winnerValid = false;
		Boolean validInput = false;
		int input = 0;
		
		System.out.println("TicTacToe");
		
		setupBoard();
		printBoard();
		
		while (winnerValid == false) {
			while (validInput == false) {
				
				input = scanner.nextInt();
				
				if (input > 0 && input < 10) {
					
					validInput = true;
					
				} else {
					
					System.out.println("invalid input");
					
				}
				
			}
			
			validInput = false;
			moves++;
			
			if (board[input - 1].equals(String.valueOf(input))) {
				
				board[input - 1] = turn; //turns input (helps to check winner)
				
				if (turn.equals("x")) {
					
					turn = "o";
					
				} else {
					
					turn = "x";
					
				}
				
				printBoard();
				winnerCheck();
				
				if (winner != null) {
					
					winnerValid = true;
					
				}
				
			} else {
				
				System.out.println("already marked");
				
			}
			
		}
		
		if (winnerValid == true) {
			if (winner.equals("tie")) {
				
				System.out.println("\n tie - in 9 moves");
				
			} else {
				
				System.out.println("\n" + winner + " wins - in " + moves + " moves");
				
			}
			
		}
		
	}
	
	static void winnerCheck() {
		
		String winLine = null;
		
		for (int i = 0; i < 9; i++) {
			
			switch (i) {
			
			case 0:
				winLine = board[0] + board[1] + board[2];
				break;
			case 1:
				winLine = board[3] + board[4] + board[5];
				break;
			case 2:
				winLine = board[6] + board[7] + board[8];
				break;
			case 3:
				winLine = board[0] + board[3] + board[6];
				break;
			case 4:
				winLine = board[1] + board[4] + board[7];
				break;
			case 5:
				winLine = board[2] + board[5] + board[8];
				break;
			case 6:
				winLine = board[0] + board[4] + board[8];
				break;
			case 7:
				winLine = board[2] + board[4] + board[6];
				break;
			}
			
			if (winLine.equals("xxx")) {
				
				winner = "Player1 (x)";
				
			} else if (winLine.equals("ooo")) {
				
				winner = "Player2 (o)";
				
			}
			
		}
		
		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
				
				break;
				
			}
			if (i == 8) {
				
				winner = "tie";
				
			}
			
		}
		
	}
	
	static void printBoard() {
		
		System.out.println("Player1 (x) vs Player2 (o) \n");
		
		if (turn.equals("x")) {
			System.out.println("Player1's (X) Turn \n");
		} else if (turn.equals("o")) {
			System.out.println("Player2's (O) Turn \n");
		}
		
		System.out.println(" | " + board[0] + " | " + board[1] + " | " + board[2] + " |" + "\n"
				+ " | " + "---------"  + " |" + "\n"
				+ " | " + board[3] + " | " + board[4] + " | " + board[5] + " |" + "\n"
				+ " | " + "---------" + " |" + "\n"
				+ " | " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		
	}
	
	static void setupBoard() {
		
		for (int i = 0; i < 9; i++) {
			
			board[i] = String.valueOf(i + 1);
			
		}
		
	}
	
}
