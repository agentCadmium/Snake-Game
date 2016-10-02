package snakegame;

public class SnakeNode {
	private int x; // x coordinate of a snake node
	private int y; // y coordinate of a snake node

	/**
	 * Constructor
	 */
	public SnakeNode(){
		// set coordinates x&y equal one by default
		x=0;
		y=0;
	}
	
	/**
	 * Sets x coordinate of snake node
	 * 
	 * @param x
	 *            coordinate of snake node
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets y coordinate of snake node
	 * 
	 * @param y
	 *            coordinate of snake node
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Get x coordinate of snake node
	 * @return x coordinate of snake node
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Get y coordinate of snake node
	 * @return y coordinate of snake node
	 */
	public int getY() {
		return y;
	}
	
}
