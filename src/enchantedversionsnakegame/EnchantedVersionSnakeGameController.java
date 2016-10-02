/**
 * 
 */
package enchantedversionsnakegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import snakegame.SnakeGameController;

/**
 * MVC - PROGRAM'S CONTROLLER
 * 
 * @author Saverchenko
 *
 */
public class EnchantedVersionSnakeGameController extends SnakeGameController {

	Timer timer; // timer witch helps to move the snake automatically
	int speed=700; // make a step in 0.7 sec.
	
	/**
	 * Constructor
	 * 
	 * @param snakeGameModel
	 *            program's model
	 * @param snakeGameView
	 *            program's GUI
	 */
	public EnchantedVersionSnakeGameController(EnchantedVersionSnakeGameModel snakeGameModel,
			EnchantedVersionSnakeGameView snakeGameView) {
		super(snakeGameModel, snakeGameView);

		// Call the program's GUI to show game's board and a snake
		repaint();
		
		//Use a Timer to add orders to the queue.
		startTimer();
	}
	
	/**
	 * Uses a Timer to move the snake
	 */
	public void startTimer(){
		timer = new Timer(speed, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {		    	
		    	getSnakeGameModel().moveSnake();
		    	
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
		});
		timer.start();
	}

	/**
	 * Returns link to the program's model
	 * 
	 * @return program's model
	 */
	public EnchantedVersionSnakeGameModel getSnakeGameModel() {
		return (EnchantedVersionSnakeGameModel) snakeGameModel;
	}

	/**
	 * Returns link to the program's GUI
	 * 
	 * @return program's GUI
	 */
	public EnchantedVersionSnakeGameView getSnakeGameView() {
		return (EnchantedVersionSnakeGameView) snakeGameView;
	}

	/**
	 * Calls the program's GUI to show game's board
	 */
	public void repaint() {
		// Call the program's GUI to show game's board and a snake
		getSnakeGameView().repaint(getSnakeGameModel().getSnake(), getSnakeGameModel().getApple(),
				getSnakeGameModel().getEnchantedApple(), getSnakeGameModel().isReverse());
	}

}
