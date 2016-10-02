package enchantedversionsnakegame;

import java.util.Random;

import datastructure.DoublyLinkedListNode;
import snakegame.SnakeGameModel;
import snakegame.SnakeNode;

/**
 * MVC - PROGRAM'S MODEL
 * 
 * @author Saverchenko
 */
public class EnchantedVersionSnakeGameModel extends SnakeGameModel{

	private SnakeNode enchantedApple; // enchanted apple
	private boolean reverse; // true if the snake eats an enchanted apple, it gets flipped around, following its tail instead
	private int newX; // direction snake moving (left or right). Use it with a timer
	private int newY; // direction snake moving (up or down). Use it with a timer
	
	/**
	 * Constructor
	 * 
	 * @param gridSize grid size
	 */
	EnchantedVersionSnakeGameModel(int gridSize) {
		super(gridSize);
		newX=0;
		newY=0;
		
		// original state
		reverse=false;
		// create an enchanted apple;
		placeEnchantedApple();
	}

	/**
	 * Return a link to the enchanted apple
	 * @return link to the enchanted apple
	 */
	public SnakeNode getEnchantedApple(){
		return enchantedApple;
	}
	
	/**
	 * Returns true when the snake eats an enchanted apple
	 */
	public boolean isReverse(){
		return reverse;
	}
	
	/**
	 * Places an apple on the board
	 */
	public void placeEnchantedApple(){
		enchantedApple=new SnakeNode();
		Random randomNumber = new Random ();

		
		do {
			// generate a random number from 0 to gridSize-1 and set coordinates for an enchanted apple
			enchantedApple.setX(randomNumber.nextInt(gridSize));
			enchantedApple.setY(randomNumber.nextInt(gridSize));

		} while (enchantedApple.getX() == apple.getX() & enchantedApple.getY() == apple.getY());
		
	}
	
	/**
	 * Move the snake automatically when use a timer
	 */
	public void moveSnake(){
		moveSnake(newX, newY);
	}
	
	/**
	 * Move the snake one position either left/right or up/down
	 */
	public void moveSnake(int newX, int newY) {
		this.newX=newX; // save moving direction for using it with a timer
		this.newY=newY; // save moving direction for using it with a timer
		
		if (!reverse){
			// call the original method from the super class
			super.moveSnake(newX, newY);
			// If the snake eats an enchanted apple, it gets flipped around,
			// following its tail instead
			if ((getSnake().getFirstNode().getData().getX() == enchantedApple.getX())
					& getSnake().getFirstNode().getData().getY() == enchantedApple.getY()) {
				// the snake gets flipped around
				reverse = !reverse;

				// create a new enchanted apple
				placeEnchantedApple();
			}
		} else {
			// call the method witch moves the snake following its tail
			moveSnakeBack(newX, newY);
			// If the tail hits another enchanted apple, then it returns to its original state
			if ((getSnake().getLastNode().getData().getX() == enchantedApple.getX())
					& getSnake().getLastNode().getData().getY() == enchantedApple.getY()) {
				// the snake gets flipped around
				reverse = !reverse;

				// create a new enchanted apple
				placeEnchantedApple();
			}
		}

	}
	
	/**
	 * Move the snake one position either left/right or up/down following its
	 * tail
	 */
	public void moveSnakeBack(int newX, int newY) {
		DoublyLinkedListNode<SnakeNode> currentListNode;

		// If the tail of the snake hits an apple, it eats it and the body grows
		// by one segment
		if ((getSnake().getLastNode().getData().getX() + newX == apple.getX())
				& getSnake().getLastNode().getData().getY() + newY == apple.getY()) {
			// the body of the snake grows by one segment
			getSnake().insertLast(apple);
			// create a new apple
			placeApple();
		} else {
			// if user tries to move the snake back then ignore this command
			if (getSnake().getLastNode().getPrevious() != null && (getSnake().getLastNode().getData().getX()
					+ newX == getSnake().getLastNode().getPrevious().getData().getX())
					& getSnake().getLastNode().getData().getY() + newY == getSnake().getLastNode().getPrevious()
							.getData().getY()) {
			} else {
				currentListNode = getSnake().getFirstNode();
				while (currentListNode != null) {
					// if this is a tail of the snake then move it
					if (currentListNode == getSnake().getLastNode()) {
						// if the tail hits a wall, the game is over
						if ((currentListNode.getData().getX() + newX < 0)
								| (currentListNode.getData().getX() + newX > gridSize - 1)
								| (currentListNode.getData().getY() + newY < 0)
								| (currentListNode.getData().getY() + newY > gridSize - 1)) {
							gameOver = true;
							break; // terminate a while loop
						} else {
							currentListNode.getData().setX(currentListNode.getData().getX() + newX);
							currentListNode.getData().setY(currentListNode.getData().getY() + newY);
						}
					} else { // if this not a tail of the snake then take
								// coordinates next node
						currentListNode.getData().setY(currentListNode.getNext().getData().getY());
						currentListNode.getData().setX(currentListNode.getNext().getData().getX());
						// if the tail hits any part of the snake, the game is
						// over
						if ((currentListNode.getData().getX() == getSnake().getLastNode().getData().getX() + newX)
								& (currentListNode.getData().getY() == getSnake().getLastNode().getData().getY()
										+ newY)) {
							gameOver = true;
							break; // terminate a while loop
						}
					}
					// get previous node
					currentListNode = currentListNode.getNext();
				}
			}
		}
	}

}
