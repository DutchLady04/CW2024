package com.example.demo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Class representing the shield image in the game.
 * This class extends ImageView and provides functionality to show and hide the shield image.
 */
public class ShieldImage extends ImageView {

	private static final String IMAGE_NAME = "/images/shield.png";
	private static final int SHIELD_SIZE = 200;

	/**
	 * Constructor for the ShieldImage class.
	 *
	 * @param xPosition The initial X position of the shield image.
	 * @param yPosition The initial Y position of the shield image.
	 */
	public ShieldImage(double xPosition, double yPosition) {
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
		// this.setImage(new Image(IMAGE_NAME));
		this.setImage(new Image(getClass().getResource("/com/example/demo/images/shield.png").toExternalForm()));
		this.setVisible(false);
		this.setFitHeight(SHIELD_SIZE);
		this.setFitWidth(SHIELD_SIZE);
	}

	/**
	 * Shows the shield image by making it visible.
	 */
	public void showShield() {
		this.setVisible(true);
	}

	/**
	 * Hides the shield image by making it invisible.
	 */
	public void hideShield() {
		this.setVisible(false);
	}

}
