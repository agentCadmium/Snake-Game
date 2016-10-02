package snakegame;

/**
 * Snake Game
 * 
 * @author Saverchenko
 *
 */
public class SnakeGameApplication {
	public static final int GRID_SIZE=20; // board size
	
	public static void main(String[] args) {
		// Create a game's model, a view model and call a controller to start a game
		new SnakeGameController(new SnakeGameModel(GRID_SIZE),
				new SnakeGameView(GRID_SIZE));

	}

}
