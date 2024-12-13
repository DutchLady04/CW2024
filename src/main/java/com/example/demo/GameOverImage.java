package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class representing the game over image displayed when the game ends.
 * This class extends ImageView and sets up the game over image with specified positions.
 */
public class GameOverImage extends ImageView {

	private static final String IMAGE_NAME = "/com/example/demo/images/gameover.png";

	/**
	 * Constructor for the GameOverImage class.
	 *
	 * @param xPosition The initial X position of the game over image.
	 * @param yPosition The initial Y position of the game over image.
	 */
	public GameOverImage(double xPosition, double yPosition) {
		setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
		setLayoutX(xPosition);
		setLayoutY(yPosition);
	}

}
