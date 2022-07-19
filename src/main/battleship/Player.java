package main.battleship;

public class Player {

	/**
	 * Ship 0: 2
	 * Ship 1: 3
	 * Ship 2: 3
	 * Ship 3: 4
	 * Ship 4: 5
	 */
	protected final Ship ships[];

	public Player() {
		ships = new Ship[5];
		initShips();
	}

	private void initShips() {
		ships[0] = new Ship(2); // fc1a0a
		ships[1] = new Ship(3); // fc0aec
		ships[2] = new Ship(3); // fc930a
		ships[3] = new Ship(4); // 930afc
		ships[4] = new Ship(5); // fc0a73
	}

	public boolean isSunk() {
		for (int i = 0; i < 5; ++i) {
			if (!ships[i].isSunk())
				return false;
		}
		return true;
	}
}
