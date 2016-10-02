package enchantedversionsnakegame;

/**
 * Snake Game
 * 
 * @author Saverchenko
 *
 */
public class EnchantedVersionSnakeGameApplication {
	public static final int GRID_SIZE=20; // board size

	public static void main(String[] args) {
		// Create a game's model, a view model and call a controller to start a game
		new EnchantedVersionSnakeGameController(new EnchantedVersionSnakeGameModel(GRID_SIZE),
				new EnchantedVersionSnakeGameView(GRID_SIZE));
	}
}
