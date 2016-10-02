package snakegame;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import datastructure.DoublyLinkedList;

/**
 * MVC - PROGRAM'S GUI
 * 
 * @author Saverchenko
 * 
 */
@SuppressWarnings("serial") // switch off the serialization warning message
public class SnakeGameView extends JFrame {
	
	protected GameBoard gameBoard; //instance of the Snake Game board
	
	/**
	 * Constructor
	 * 
	 * @param gridSize grid size
	 */
	public SnakeGameView(int gridSize) {
		
		// Useful link:
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

		// Create a JFrame
		super("Snake Game");

		
		// Set size of the frame
		setSize(400, 400);
		
        createGameBoard(gridSize);
        add(getGameBoard(), BorderLayout.CENTER);

		// Exit normally on closing the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The window is placed in the center of the screen
		setLocationRelativeTo(null); // if the component is null the window is
										// placed in the center of the screen
		
		// Show frame
		setVisible(true);
	}
	
	/**
	 * Constructor
	 * 
	 * @param title name of the game
	 */
	public SnakeGameView(String title) {
		
		// Useful link:
		// https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

		// Create a JFrame
		super(title);
	}
	
	/**
	 * Creates game board
	 * @param gridSize grid size
	 */
	public void createGameBoard(int gridSize){
		gameBoard=new GameBoard(gridSize);
	}
	
	/**
	 * Returns link to the game board
	 * @return game board
	 */
	public GameBoard getGameBoard(){
		return gameBoard;
	}
	
	/**
	 * Calls repaint our game board
	 */
	public void repaint (DoublyLinkedList<SnakeNode> snake, SnakeNode apple){
		getGameBoard().setItems(snake, apple);
		getGameBoard().repaint();
	}
	
	/**
	 * Shows the user a message that the game is over
	 */
	public void showGameOverMessage() {
		// Useful link:
		// https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		JOptionPane.showMessageDialog(this,
				"Sorry, you lost!",
				"Game Over", JOptionPane.INFORMATION_MESSAGE);
	}

}
