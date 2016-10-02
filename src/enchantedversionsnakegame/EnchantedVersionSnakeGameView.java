package enchantedversionsnakegame;

import datastructure.DoublyLinkedList;
import snakegame.SnakeGameView;
import snakegame.SnakeNode;

/**
 * MVC - PROGRAM'S GUI
 * 
 * @author Saverchenko
 * 
 */
@SuppressWarnings("serial")
public class EnchantedVersionSnakeGameView extends SnakeGameView{

	/**
	 * Constructor
	 * 
	 * @param gridSize grid size
	 */
	public EnchantedVersionSnakeGameView(int gridSize) {
        // call constructor from super class
		super(gridSize);
	}
	
	/**
	 * Creates game board
	 * @param gridSize grid size
	 */
	public void createGameBoard(int gridSize){
		gameBoard=new EnchantedVersionGameBoard(gridSize);
	}
	
	/**
	 * Returns link to the game board
	 * @return game board
	 */
	public EnchantedVersionGameBoard getGameBoard(){
		return (EnchantedVersionGameBoard) gameBoard;
	}
	
	/**
	 * Calls repaint our game board
	 */
	public void repaint(DoublyLinkedList<SnakeNode> snake, SnakeNode apple, SnakeNode enchantedApple, boolean isReverse) {
		getGameBoard().setItems(snake, apple, enchantedApple, isReverse);
		getGameBoard().repaint();
	}


}
