package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

import datastructure.DoublyLinkedList;
import datastructure.DoublyLinkedListNode;

/**
 * Represents the game board
 */
@SuppressWarnings("serial") // switch off the serialization warning message
public class GameBoard extends JComponent {

	protected int gridSize; // grid size
	protected int stepGrid; // step of a grid
	protected DoublyLinkedList<SnakeNode> snake; // snake
	protected SnakeNode apple; // apple

	/**
	 * Constructor
	 * 
	 * @param gridSize grid size
	 */
	public GameBoard(int gridSize) {
		this.gridSize = gridSize;
	}

	/**
	 * Represents the game board
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		int frameSize; // frame size

		// calculate square size witch will the boarder
		if (getWidth() < getHeight()) {
			frameSize = getWidth();
		} else {
			frameSize = getHeight();
		}

		stepGrid = ((int) frameSize / gridSize);
		frameSize = stepGrid * gridSize;
		
		// Useful link:
		// https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
		
		// draw a boarder of the game board
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, frameSize, frameSize);

		DoublyLinkedListNode<SnakeNode> currentListNode = snake.getFirstNode();
	
		// draw a snake
		while (currentListNode != null) {
			if (currentListNode==snake.getFirstNode()) {
				g.setColor(Color.YELLOW); // paint the snake's head in yellow
			} else {
				g.setColor(Color.GREEN); // rest part of the snake paint in green
			}
			g.fillRect(currentListNode.getData().getX() * stepGrid, currentListNode.getData().getY() * stepGrid,
					stepGrid, stepGrid);
			g.setColor(Color.BLACK);
			g.drawRect(currentListNode.getData().getX() * stepGrid, currentListNode.getData().getY() * stepGrid,
					stepGrid, stepGrid);

			// get next node
			currentListNode = currentListNode.getNext();
		}
		
		// draw an apple
		g.setColor(Color.RED);
		g.fillOval(apple.getX()* stepGrid, apple.getY()* stepGrid, stepGrid, stepGrid);

	}

	/**
	 * Set links to the snake and the apple
	 * 
	 * @param snake doubly linked list links to the snake
	 * @param apple - link to the apple
	 */
	public void setItems(DoublyLinkedList<SnakeNode> snake, SnakeNode apple) {
		this.snake = snake;
		this.apple = apple;
	}

}