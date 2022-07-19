package main.java.battleship;

public class Ship {

	public final int size;
	protected final State slots[];

	Ship(int size) throws RuntimeException {
		if (size < 2 || size > 5)
			throw new RuntimeException("Attempting to create ship of illegal size " + size);
		this.size = size;
		this.slots = new State[this.size];
		for (int i = 0; i < size; ++i)
			slots[i] = new State();
	}

	public boolean isSunk() {
		for (int i = 0; i < size; ++i) {
			if (!slots[i].hit)
				return false;
		}
		return true;
	}

	// public boolean hit(int x, int y) {
	// 	// for (int i = 0; i < )

	// 	return false;
	// }

	/**
	 * Container for slot state boolean, used to pass slot state by reference
	 */
	protected class State {
		private boolean hit;

		State() {
			this.hit = false;
		}

		/**
		 * Hits ship slot
		 * 
		 * @return true if ship slot is newly hit, else false
		 */
		boolean hit() {
			if (hit) // already hit
				return false;
			hit = true;
			return true;
		}
	}
}