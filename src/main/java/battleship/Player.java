package main.java.battleship;

public class Player {

	/**
	 * Ship 0: 
	 */
	Ship ships[];

	Player() {
		initShips();
	}

	private void initShips() {
		ships = new Ship[5];
		ships[0] = new Ship(2);
		ships[1] = new Ship(3);
		ships[2] = new Ship(3);
		ships[3] = new Ship(4);
		ships[4] = new Ship(5);
	}

	public boolean isSunk() {
		for (int i = 0; i < 5; ++i) {
			if (!ships[i].isSunk())
				return false;
		}
		return true;
	}
}
