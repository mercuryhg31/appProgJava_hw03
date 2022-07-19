package main.java.network;

import main.java.battleship.Game;

public class Host {
	
	// CONSTANTS
	private static final int VISITOR = 0;
	private static final int HOST = 1;
	
	private static Game game;
	private static int turn;

	public static void hostGame() {
		game = new Game();
		turn = -1; // no one's turn yet

		// ship placement

	}

	private static void nextTurn() {
		if (turn != 0 || turn != 1)
			throw new RuntimeException("Unknown turn " + turn);
		turn = turn ^ 1;
	}

}
