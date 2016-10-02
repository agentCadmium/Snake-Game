package snakegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * MVC - PROGRAM'S CONTROLLER
 * 
 * @author Saverchenko
 *
 */
public class SnakeGameController implements KeyListener{

	protected SnakeGameModel snakeGameModel;
	protected SnakeGameView snakeGameView;
	
	/**
	 * Constructor
	 * @param snakeGameModel
	 *            program's model
	 * @param snakeGameView
	 *            program's GUI
	 */
	public SnakeGameController(SnakeGameModel snakeGameModel,
			SnakeGameView snakeGameView) {
		this.snakeGameModel=snakeGameModel;
		this.snakeGameView=snakeGameView;
		// add KeyListener in the JFrame of the View
		snakeGameView.addKeyListener(this); 
		
		// Call the program's GUI to show game's board and a snake
		repaint();
	}

	/**
	 * Calls the program's GUI to show game's board
	 */
	public void repaint() {
		// Call the program's GUI to show game's board and a snake
		snakeGameView.repaint(snakeGameModel.getSnake(), snakeGameModel.getApple());
	}

	@Override
	public void keyPressed(KeyEvent e) {
  		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : 
				//call a method to move left
				snakeGameModel.moveSnake(-1,0);
				break;
			case KeyEvent.VK_RIGHT: 
				// call a method to move right
				snakeGameModel.moveSnake(1,0);
				break;
			case KeyEvent.VK_UP :
				// call a method to move up
				snakeGameModel.moveSnake(0,-1);
				break;
			case KeyEvent.VK_DOWN :
				// call a method to move down
				snakeGameModel.moveSnake(0,1);
				break;		
			}
  		
  		
		if (snakeGameModel.isGameOver() == true) {
			// show the user a message that the game is over
			snakeGameView.showGameOverMessage(); 
			// exit from our app
			System.exit(0); 
		} else {
			// call View Model to update information on the screen
			repaint();
		}
				
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}
	
	
	
}
