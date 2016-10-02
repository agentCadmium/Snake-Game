package snakegame;

import java.util.Random;

import datastructure.DoublyLinkedList;
import datastructure.DoublyLinkedListNode;

/**
 * MVC - PROGRAM'S MODEL
 * 
 * @author Saverchenko
 */
public class SnakeGameModel {

	protected int gridSize; // grid size
	private DoublyLinkedList<SnakeNode> snake; // snake
	protected SnakeNode apple; // apple
	private SnakeNode snakeNodeCoordinates; // coordinates of a snake's node
	protected Boolean gameOver; // game over flag
	
	/**
	 * Constructor
	 * 
	 * @param gridSize grid size
	 */
	public SnakeGameModel(int gridSize){
		this.gridSize=gridSize;
		gameOver=false; // false by default
		
		// create an apple;
		placeApple();
		
		// create a snake
		snake=new DoublyLinkedList<SnakeNode>();
		snakeNodeCoordinates=new SnakeNode(); // by default coordinates equal [0,0]
		
		// insert a head
		snake.insertFirst(snakeNodeCoordinates);	
	}
	
	/**
	 * Return a link to the snake
	 * @return link to the snake
	 */
	public DoublyLinkedList<SnakeNode> getSnake(){
		return snake;
	}
	
	/**
	 * Return a link to the apple
	 * @return link to the apple
	 */
	public SnakeNode getApple(){
		return apple;
	}
	
	/**
	 * Places an apple on the board
	 */
	public void placeApple(){
		apple=new SnakeNode();
		Random randomNumber = new Random ();
		
		// generate a random number from 0 to gridSize-1 and set coordinates for an apple
		apple.setX(randomNumber.nextInt(gridSize));
		apple.setY(randomNumber.nextInt(gridSize));
	}
	
	
	/**
	 * Move the snake one position either left/right or up/down
	 * @param newX
	 * @param newY
	 */
	public void moveSnake(int newX, int newY) {
		DoublyLinkedListNode<SnakeNode> currentListNode;

		// If the head of the snake hits an apple, it eats it and the body
		// grows
		// by one segment
		if ((snake.getFirstNode().getData().getX() + newX == apple.getX())
				& snake.getFirstNode().getData().getY() + newY == apple.getY()) {
			// the body of the snake grows by one segment
			snake.insertFirst(apple);
			// create a new apple
			placeApple();
		} else {
			// if user tries to move the snake back then ignore this command
			if (snake.getFirstNode().getNext() != null
					&& (snake.getFirstNode().getData().getX() + newX == snake.getFirstNode().getNext().getData().getX())
							& snake.getFirstNode().getData().getY() + newY == snake.getFirstNode().getNext().getData()
									.getY()) {
			} else {
				currentListNode = snake.getLastNode();
				while (currentListNode != null) {
					// if this is a head of the snake then move it
					if (currentListNode == snake.getFirstNode()) {
						// if the head hits a wall, the game is over
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
					} else { // if this not a head of the snake then take
								// coordinates previous node
						currentListNode.getData().setY(currentListNode.getPrevious().getData().getY());
						currentListNode.getData().setX(currentListNode.getPrevious().getData().getX());
						// if the head hits any part of the snake, the game
						// is
						// over
						if (((currentListNode.getData().getX() == snake.getFirstNode().getData().getX() + newX)
								& (currentListNode.getData().getY() == snake.getFirstNode().getData().getY() + newY))) {
							gameOver = true;
							break; // terminate a while loop
						}
					}
					// get next node
					currentListNode = currentListNode.getPrevious();
				}

			}
		}

	}
	
	
	/**
	 * Invoked when the head hits a wall or any part of the snake
	 * @return true if game over
	 */
	public Boolean isGameOver(){
		return gameOver;
	}
	
}
