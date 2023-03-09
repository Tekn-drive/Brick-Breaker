package brickBreaker;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Gameplay game = new Gameplay();
		//Setting up the frame for the game to run (not the level, just the frame)
		frame.setBounds(10,10,700,600);
		frame.setTitle("Brick Breaker");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Adds the game which already contains the level into the frame, the game is able to be executed at this point.
		frame.add(game);
	}

}
