package test.battleship;

import main.battleship.*;

public class GameTest {

	private static Game game1;

	/**
	 * Tests basic game functionalities for game starting like this:
	 *
	 * <pre>
	 * P0                         P1
	 *   0 1 2 3 4 5 6 7 8 9        0 1 2 3 4 5 6 7 8 9
	 * 0 . . . . . . . . . .      0 x . . . . . . . . .
	 * 1 . . x x . . . . . .      1 x . . . . . . . . .
	 * 2 . . . . . . . . . .      2 x . . . . . . . . .
	 * 3 . . x . . . x . . .      3 x̄|x x x x x|x x x x
	 * 4 . . x . . . x . . .      4 x|x̄ x̄ x̄ . . . . . .
	 * 5 . . x . . . x . . .      5 . . . . . . . . . .
	 * 6 . . x . . . . . . .      6 . . . . . . . . . .
	 * 7 . . x|x x x . . . .      7 . . . . . . . . . .
	 * 8 . . . . . . . . . .      8 . . . . . . . . . .
	 * 9 . . . . x x x x . .      9 . . . . . . . . . .
	 * </pre>
	 */
	private static Test playGame1 = new Test() {
		@Override
		public void test() {
			game1 = new Game();

		// P0 ships
		Position[] p0Pos = new Position[5];
		p0Pos[0] = new Position(2, 1, true);
		p0Pos[1] = new Position(6, 3, false);
		p0Pos[2] = new Position(3, 7, true);
		p0Pos[3] = new Position(4, 9, true);
		p0Pos[4] = new Position(2, 3, false);
		game1.placeShips(0, p0Pos);

		// P1 ships
		Position[] p1Pos = new Position[5];
		p1Pos[0] = new Position(0, 3, false);
		p1Pos[1] = new Position(0, 0, false);
		p1Pos[2] = new Position(1, 4, true);
		p1Pos[3] = new Position(6, 3, true);
		p1Pos[4] = new Position(1, 3, true);
		game1.placeShips(1, p1Pos);

		String p0Board =
			  "  0 1 2 3 4 5 6 7 8 9\n"
			+ "0 . . . . . . . . . . \n"
			+ "1 . . x x . . . . . . \n"
			+ "2 . . . . . . . . . . \n"
			+ "3 . . x . . . x . . . \n"
			+ "4 . . x . . . x . . . \n"
			+ "5 . . x . . . x . . . \n"
			+ "6 . . x . . . . . . . \n"
			+ "7 . . x x x x . . . . \n"
			+ "8 . . . . . . . . . . \n"
			+ "9 . . . . x x x x . . \n"
		;

		String p1Board =
			  "  0 1 2 3 4 5 6 7 8 9\n"
			+ "0 x . . . . . . . . . \n"
			+ "1 x . . . . . . . . . \n"
			+ "2 x . . . . . . . . . \n"
			+ "3 x x x x x x x x x x \n"
			+ "4 x x x x . . . . . . \n"
			+ "5 . . . . . . . . . . \n"
			+ "6 . . . . . . . . . . \n"
			+ "7 . . . . . . . . . . \n"
			+ "8 . . . . . . . . . . \n"
			+ "9 . . . . . . . . . . \n"
		;

		if (!p0Board.equals(game1.getBoardVisual(0)))
			throw new RuntimeException("Player 0 board initialization failed.");
		if (!p1Board.equals(game1.getBoardVisual(1)))
			throw new RuntimeException("Player 1 board initialization failed.");

		game1.hit(0, 6, 4);
		p1Board =
			  "  0 1 2 3 4 5 6 7 8 9\n"
			+ "0 x . . . . . . . . . \n"
			+ "1 x . . . . . . . . . \n"
			+ "2 x . . . . . . . . . \n"
			+ "3 x x x x x x x x x x \n"
			+ "4 x x x x . . * . . . \n"
			+ "5 . . . . . . . . . . \n"
			+ "6 . . . . . . . . . . \n"
			+ "7 . . . . . . . . . . \n"
			+ "8 . . . . . . . . . . \n"
			+ "9 . . . . . . . . . . \n"
		;
		if (!p1Board.equals(game1.getBoardVisual(1)))
			throw new RuntimeException("Player 0 move failed.");

		game1.hit(1, 6, 4);
		p0Board =
			  "  0 1 2 3 4 5 6 7 8 9\n"
			+ "0 . . . . . . . . . . \n"
			+ "1 . . x x . . . . . . \n"
			+ "2 . . . . . . . . . . \n"
			+ "3 . . x . . . x . . . \n"
			+ "4 . . x . . . % . . . \n"
			+ "5 . . x . . . x . . . \n"
			+ "6 . . x . . . . . . . \n"
			+ "7 . . x x x x . . . . \n"
			+ "8 . . . . . . . . . . \n"
			+ "9 . . . . x x x x . . \n"
		;
		if (!p0Board.equals(game1.getBoardVisual(0)))
			throw new RuntimeException("Player 1 move failed.");

		game1.hit(1, 2, 1);
		game1.hit(1, 3, 1);
		game1.hit(1, 0, 2);
		game1.hit(1, 0, 3);
		game1.hit(1, 0, 8);
		game1.hit(1, 0, 0);
		game1.hit(1, 9, 9);
		game1.hit(1, 0, 9);
		game1.hit(1, 9, 0);
		game1.hit(1, 9, 0);
		game1.hit(1, 9, 0);
		game1.hit(1, 6, 3);
		game1.hit(1, 6, 5);
		p0Board =
			  "  0 1 2 3 4 5 6 7 8 9\n"
			+ "0 * . . . . . . . . * \n"
			+ "1 . . % % . . . . . . \n"
			+ "2 * . . . . . . . . . \n"
			+ "3 * . x . . . % . . . \n"
			+ "4 . . x . . . % . . . \n"
			+ "5 . . x . . . % . . . \n"
			+ "6 . . x . . . . . . . \n"
			+ "7 . . x x x x . . . . \n"
			+ "8 * . . . . . . . . . \n"
			+ "9 * . . . x x x x . * \n"
		;

		game1.hit(0, 0, 0);
		game1.hit(0, 0, 9);
		game1.hit(0, 9, 9);
		game1.hit(0, 9, 0);
		game1.hit(0, 0, 1);
		game1.hit(0, 0, 2);
		game1.hit(0, 0, 3);
		game1.hit(0, 0, 4);
		game1.hit(0, 1, 3);
		game1.hit(0, 1, 4);
		game1.hit(0, 2, 3);
		game1.hit(0, 2, 4);
		game1.hit(0, 3, 3);
		game1.hit(0, 3, 4);
		game1.hit(0, 4, 3);
		game1.hit(0, 5, 3);
		game1.hit(0, 6, 3);
		game1.hit(0, 7, 3);
		game1.hit(0, 8, 3);
		game1.hit(0, 9, 3);
		p1Board =
			  "  0 1 2 3 4 5 6 7 8 9\n"
			+ "0 % . . . . . . . . * \n"
			+ "1 % . . . . . . . . . \n"
			+ "2 % . . . . . . . . . \n"
			+ "3 % % % % % % % % % % \n"
			+ "4 % % % % . . * . . . \n"
			+ "5 . . . . . . . . . . \n"
			+ "6 . . . . . . . . . . \n"
			+ "7 . . . . . . . . . . \n"
			+ "8 . . . . . . . . . . \n"
			+ "9 * . . . . . . . . * \n"
		;

		if (!p0Board.equals(game1.getBoardVisual(0)))
			throw new RuntimeException("Player 0 board gameplay failed.");
		if (!p1Board.equals(game1.getBoardVisual(1)))
			throw new RuntimeException("Player 1 board gameplay failed.");

		if (game1.won() != 0)
			throw new RuntimeException("Player 0 did not win game.");
		}
	};

	private static Test temp = new Test() {
		@Override
		public void test() {
			throw new RuntimeException("ksdjfdksfdskj skjfdslkf");
		}
	};
	
	private static void test(String name, Test test) {
		// System.out.println("Performing test \"" + name + "\"");
		try {
			test.test();
			// System.out.println("Test \"" + name + "\" was successful.");
		} catch (Exception e) {
			System.out.println("Test \"" + name + "\" failed with message:");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		test("Play Game 1", playGame1);
		test("temp", temp);
	}
}
