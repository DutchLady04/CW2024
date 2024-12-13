package com.example.demo;

/**
 * Abstract class representing a projectile in the game.
 * This class extends ActiveActorDestructible and provides basic functionality
 * for initializing and handling damage for projectiles.
 */
public abstract class Projectile extends ActiveActorDestructible {

	/**
	 * Constructor for the Projectile class.
	 *
	 * @param imageName    The name of the image file for the projectile.
	 * @param imageHeight  The height to which the image should be scaled.
	 * @param initialXPos  The initial X position of the projectile.
	 * @param initialYPos  The initial Y position of the projectile.
	 */
	public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
	}

	/**
	 * Handles the projectile taking damage, which results in its destruction.
	 */
	@Override
	public void takeDamage() {
		this.destroy();
	}

	/**
	 * Abstract method to update the position of the projectile.
	 * This method should be implemented by subclasses to define
	 * how the projectile's position changes over time.
	 */
	@Override
	public abstract void updatePosition();

}
