package enchantedversionsnakegame;
import java.awt.Color;
import java.awt.Graphics;

import datastructure.DoublyLinkedList;
import snakegame.GameBoard;
import snakegame.SnakeNode;

/**
 * Represents the game board
 */
@SuppressWarnings("serial") // switch off the serialization warning message
public class EnchantedVersionGameBoard extends GameBoard{
	private SnakeNode enchantedApple; // enchanted apple
	private boolean isReverse; // true when the snake eats an enchanted apple
	
	/**
	 * Constructor
	 * 
	 * @param gridSize grid size
	 */
	EnchantedVersionGameBoard(int gridSize) {
		super(gridSize);
	}

	/**
	 * Represents the game board
	 */
	public void paint(Graphics g) {
		// call paint method from the super class
		super.paint(g);
		
		// repaint the head of the snake witch ate an enchanted apple
		if (isReverse) {	
			g.setColor(Color.ORANGE);
			g.fillRect(snake.getFirstNode().getData().getX() * stepGrid,
					snake.getFirstNode().getData().getY() * stepGrid, stepGrid, stepGrid);
			g.setColor(Color.BLACK);
			g.drawRect(snake.getFirstNode().getData().getX() * stepGrid,
					snake.getFirstNode().getData().getY() * stepGrid, stepGrid, stepGrid);
		}
		
		// draw an enchanted apple
		g.setColor(Color.PINK);
		g.fillOval(enchantedApple.getX()* stepGrid, enchantedApple.getY()* stepGrid, stepGrid, stepGrid);
	}
	
	/**
	 * Sets links to the snake and apples
	 * 
	 * @param snake doubly linked list links to the snake
	 * @param apple link to the apple
	 * @param enchantedApple link to the enchanted apple
	 */
	public void setItems(DoublyLinkedList<SnakeNode> snake, SnakeNode apple, SnakeNode enchantedApple, boolean isReverse) {
		// call setItens method from the super class
		super.setItems(snake, apple);

		this.enchantedApple = enchantedApple;
		this.isReverse = isReverse;
	}
}
