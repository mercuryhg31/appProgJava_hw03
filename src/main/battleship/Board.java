package main.battleship;

public class Board {

	private Slot slots[][];

	public Board() {
		slots = new Slot[10][10];
		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j)
				slots[i][j] = new Slot();
		}
	}

	private boolean get(int x, int y) {
		return slots[y][x].hit;
	}

	public boolean hit(int x, int y) {
		return slots[y][x].hit();
	}

	public void placeShip(Ship ship, int x, int y, boolean horizontal) throws IllegalArgumentException {
		int ex = x, why = y;
		// validate placement space first
		for (int i = 0; i < ship.size; ++i) {
			try {
				get(x, y);
			} catch (IndexOutOfBoundsException e) {
				throw new IllegalArgumentException("Attempting to place ship in invalid space.");
			}
			if (horizontal) ++ex; else ++why;
		}
		if (ex + why == 0) {} // just to get rid of warning

		// place
		for (int i = 0; i < ship.size; ++i) {
			slots[y][x].attachShip(ship.slots[i]);
			if (horizontal) ++x; else ++y;
		}
	}

	// public void removeShip(Ship ship, int x, int y, boolean horizontal) throws IllegalArgumentException {
	// 	int ex = x, why = y;
	// 	// validate that ship is in place
	// 	for (int i = 0; i < ship.size; ++i) {
	// 		try {
	// 			slots[y][x];
	// 		}
	// 	}
	// }

	@Override
	public String toString() { // for testing purposes
		String output = "";
		output += "  0 1 2 3 4 5 6 7 8 9\n";
		for (int i = 0; i < 10; ++i) {
			output += i + " ";
			for (int j = 0; j < 10; ++j) {
				/* % - hit ship slot
				 * x - unhit ship slot
				 * * - hit empty slot
				 * . - unhit empty slot */
				char s = (slots[i][j].ship != null) ? get(j, i) ? '%' : 'x' : get(j, i) ? '*' : '.'; 
				output += s + " ";
			}
			output += "\n";
		}
		return output;
	}

	private class Slot {
		private Ship.State ship;
		private boolean hit;

		Slot() {
			this.hit = false;
			this.ship = null;
		}

		void attachShip(Ship.State s) {
			this.ship = s;
		}

		void detachShip() {
			this.ship = null;
		}

		/**
		 * Hits this slot on the board
		 * 
		 * @return true if there was a ship on slot and is newly hit, else false
		 *         (no ship at slot or previously hit location)
		 */
		boolean hit() {
			if (hit) // already hit
				return false;
			hit = true;
			if (ship != null)
				return ship.hit();
			else return false; // no ship here to hit
		}
	}
}
