package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class representing the win image displayed when the player wins the game.
 * This class extends ImageView and provides functionality to show the win image.
 */
public class WinImage extends ImageView {

	private static final String IMAGE_NAME = "/com/example/demo/images/youwin.png";
	private static final int HEIGHT = 500;
	private static final int WIDTH = 600;

	/**
	 * Constructor for the WinImage class.
	 *
	 * @param xPosition The initial X position of the win image.
	 * @param yPosition The initial Y position of the win image.
	 */
	public WinImage(double xPosition, double yPosition) {
		this.setImage(new Image(getClass().getResource(IMAGE_NAME).toExternalForm()));
		this.setVisible(false);
		this.setFitHeight(HEIGHT);
		this.setFitWidth(WIDTH);
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
	}

	/**
	 * Shows the win image by making it visible.
	 */
	public void showWinImage() {
		this.setVisible(true);
	}

}
