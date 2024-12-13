package com.example.demo;

/**
 * Abstract class representing a fighter plane in the game.
 * This class extends ActiveActorDestructible and provides additional
 * functionalities such as firing projectiles and taking damage.
 */
public abstract class FighterPlane extends ActiveActorDestructible {

	private int health;

	/**
	 * Constructor for the FighterPlane class.
	 *
	 * @param imageName    The name of the image file for the plane.
	 * @param imageHeight  The height to which the image should be scaled.
	 * @param initialXPos  The initial X position of the plane.
	 * @param initialYPos  The initial Y position of the plane.
	 * @param health       The initial health of the plane.
	 */
	public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		this.health = health;
	}

	/**
	 * Abstract method to fire a projectile from the fighter plane.
	 * This method should be implemented by subclasses to define
	 * the behavior when the plane fires a projectile.
	 *
	 * @return A new ActiveActorDestructible representing the fired projectile.
	 */
	public abstract ActiveActorDestructible fireProjectile();

	/**
	 * Handles the fighter plane taking damage, reducing its health.
	 * If the health reaches zero, the plane is destroyed.
	 */
	@Override
	public void takeDamage() {
		health--;
		if (healthAtZero()) {
			this.destroy();
		}
	}

	/**
	 * Calculates the X position for a projectile fired by the plane.
	 *
	 * @param xPositionOffset The offset to add to the plane's X position.
	 * @return The calculated X position for the projectile.
	 */
	protected double getProjectileXPosition(double xPositionOffset) {
		return getLayoutX() + getTranslateX() + xPositionOffset;
	}

	/**
	 * Calculates the Y position for a projectile fired by the plane.
	 *
	 * @param yPositionOffset The offset to add to the plane's Y position.
	 * @return The calculated Y position for the projectile.
	 */
	protected double getProjectileYPosition(double yPositionOffset) {
		return getLayoutY() + getTranslateY() + yPositionOffset;
	}

	/**
	 * Checks if the plane's health has reached zero.
	 *
	 * @return true if the health is zero, false otherwise.
	 */
	private boolean healthAtZero() {
		return health == 0;
	}

	/**
	 * Gets the current health of the plane.
	 *
	 * @return The current health.
	 */
	public int getHealth() {
		return health;
	}

}
