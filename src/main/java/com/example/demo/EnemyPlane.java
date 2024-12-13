package com.example.demo;

/**
 * Class representing an enemy plane in the game.
 * The enemy plane can move horizontally and fire projectiles.
 */
public class EnemyPlane extends FighterPlane {

	private static final String IMAGE_NAME = "enemyplane.png";
	private static final int IMAGE_HEIGHT = 150;
	private static final int HORIZONTAL_VELOCITY = -6;
	private static final double PROJECTILE_X_POSITION_OFFSET = -100.0;
	private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
	private static final int INITIAL_HEALTH = 1;
	private double fireRate; // Modify to allow dynamic fire rate

	/**
	 * Constructor for the EnemyPlane class.
	 *
	 * @param initialXPos The initial X position of the enemy plane.
	 * @param initialYPos The initial Y position of the enemy plane.
	 */
	public EnemyPlane(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
		this.fireRate = .01; // Set default fire rate
	}

	/**
	 * Gets the current fire rate of the enemy plane.
	 *
	 * @return The fire rate.
	 */
	public double getFireRate() {
		return fireRate;
	}

	/**
	 * Sets the fire rate of the enemy plane.
	 *
	 * @param fireRate The new fire rate.
	 */
	public void setFireRate(double fireRate) {
		this.fireRate = fireRate;
	}

	/**
	 * Updates the position of the enemy plane by moving it horizontally.
	 */
	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	/**
	 * Fires a projectile from the enemy plane if it decides to fire in the current frame.
	 *
	 * @return A new EnemyProjectile if the enemy plane fires, otherwise null.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		if (Math.random() < fireRate) { // Use dynamic fire rate
			double projectileXPosition = getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET);
			double projectileYPosition = getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET);
			return new EnemyProjectile(projectileXPosition, projectileYPosition);
		}
		return null;
	}

	/**
	 * Updates the state of the enemy plane.
	 * This method calls updatePosition to move the enemy plane.
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}
}
