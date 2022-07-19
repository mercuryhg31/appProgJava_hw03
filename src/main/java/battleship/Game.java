package main.java.battleship;

public class Game {
	
	private Player player[];
	private Board board[];
	private boolean shipsSet[][];

	public Game() {
		this.player = new Player[2];
		player[0] = new Player();
		player[1] = new Player();
		this.board = new Board[2];
		board[0] = new Board();
		board[1] = new Board();

		shipsSet = new boolean[2][5];
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 5; ++j)
				shipsSet[i][j] = false;
		}
	}

	private void validatePlayer(int player) {
		if (player != 0 && player != 1)
			throw new IllegalArgumentException("Passed in illegal player " + player);
	}

	public void placeShips(int player, Position[] pos) {
		if (pos.length != 5)
			throw new RuntimeException("Need to place 5 ships per player.");
		for (int i = 0; i < 5; ++i)
			placeShip(player, i, pos[i].x, pos[i].y, pos[i].horizontal);
	}

	private void placeShip(int player, int ship, int x, int y, boolean horizontal) {
		validatePlayer(player);
		board[player].placeShip(this.player[player].ships[ship], x, y, horizontal);
		shipsSet[player][ship] = true;
	}

	/**
	 * Gets String visual of game board for testing purposes
	 * 
	 * @param player player number
	 * @return String visualizing board of indicated player
	 */
	public String getBoardVisual(int player) {
		validatePlayer(player);
		return board[player].toString();
	}

	/**
	 * 
	 * @param player player who is making the move
	 * @param x x position
	 * @param y y position
	 * @return true if there was a ship on slot and is newly hit, else false
	 *         (no ship at slot or previously hit location)
	 */
	public boolean hit(int player, int x, int y) {
		validatePlayer(player);
		return board[player ^ 1].hit(x, y);
	}

	/**
	 * Returns win state of the game
	 * 
	 * @return -1 if no one has one, 2 if both players are sunk,
	 *         else numer of last player standing
	 */
	public int won() {
		boolean zeroSunk = true;
		for (Ship s : player[0].ships) {
			if (!s.isSunk()) {
				zeroSunk = false;
				break;
			}
		}

		boolean oneSunk = true;
		for (Ship s : player[1].ships) {
			if (!s.isSunk()) {
				oneSunk = false;
				break;
			}
		}

		if (zeroSunk && oneSunk)
			return 2;
		else if (zeroSunk)
			return 1;
		else if (oneSunk)
			return 0;
		else
			return -1;
	}

}