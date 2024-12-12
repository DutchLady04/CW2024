package com.example.demo;

public class EnemyPlane extends FighterPlane {

	private static final String IMAGE_NAME = "enemyplane.png";
	private static final int IMAGE_HEIGHT = 150;
	private static final int HORIZONTAL_VELOCITY = -6;
	private static final double PROJECTILE_X_POSITION_OFFSET = -100.0;
	private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
	private static final int INITIAL_HEALTH = 1;
	private double fireRate; // Modify to allow dynamic fire rate

	public EnemyPlane(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
		this.fireRate = .01; // Set default fire rate
	}

	public double getFireRate() {
		return fireRate;
	}

	public void setFireRate(double fireRate) {
		this.fireRate = fireRate;
	}

	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	@Override
	public ActiveActorDestructible fireProjectile() {
		if (Math.random() < fireRate) { // Use dynamic fire rate
			double projectileXPosition = getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET);
			double projectileYPosition = getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET);
			return new EnemyProjectile(projectileXPosition, projectileYPosition);
		}
		return null;
	}

	@Override
	public void updateActor() {
		updatePosition();
	}
}
