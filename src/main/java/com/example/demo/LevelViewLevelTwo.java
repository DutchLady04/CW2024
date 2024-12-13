package com.example.demo;

import javafx.scene.Group;

/**
 * Class representing the view for the second level of the game.
 * This class extends LevelView and adds specific visual elements for Level Two, such as a shield image.
 */
public class LevelViewLevelTwo extends LevelView {

	private static final int SHIELD_X_POSITION = 1150;
	private static final int SHIELD_Y_POSITION = 500;
	private final Group root;
	private final ShieldImage shieldImage;

	/**
	 * Constructor for the LevelViewLevelTwo class.
	 *
	 * @param root            The root group to which visual elements are added.
	 * @param heartsToDisplay The initial number of hearts to display for the player.
	 */
	public LevelViewLevelTwo(Group root, int heartsToDisplay) {
		super(root, heartsToDisplay);
		this.root = root;
		this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
		addImagesToRoot();
	}

	/**
	 * Adds visual elements such as the shield image to the root.
	 */
	private void addImagesToRoot() {
		root.getChildren().addAll(shieldImage);
	}

	/**
	 * Displays the shield image in the game view.
	 */
	public void showShield() {
		shieldImage.showShield();
	}

	/**
	 * Hides the shield image in the game view.
	 */
	public void hideShield() {
		shieldImage.hideShield();
	}

}
