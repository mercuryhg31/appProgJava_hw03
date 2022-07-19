package main.java.battleship;

public class Position {
	public final int x;
	public final int y;
	public final boolean horizontal;

	public Position(int x, int y, boolean horizontal) {
		this.x = x;
		this.y = y;
		this.horizontal = horizontal;
	}
}