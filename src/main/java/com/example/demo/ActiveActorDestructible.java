package com.example.demo;

/**
 * Abstract class representing a destructible active actor in the game.
 * This class extends ActiveActor and implements the Destructible interface,
 * providing basic functionalities for destruction and damage.
 */
public abstract class ActiveActorDestructible extends ActiveActor implements Destructible {

	private boolean isDestroyed;

	/**
	 * Constructor for the ActiveActorDestructible class.
	 *
	 * @param imageName    The name of the image file for the actor.
	 * @param imageHeight  The height to which the image should be scaled.
	 * @param initialXPos  The initial X position of the actor.
	 * @param initialYPos  The initial Y position of the actor.
	 */
	public ActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		isDestroyed = false;
	}

	/**
	 * Abstract method to update the position of the actor.
	 * This method should be implemented by subclasses to define
	 * how the actor's position changes over time.
	 */
	@Override
	public abstract void updatePosition();

	/**
	 * Abstract method to update the actor's state.
	 * This method should be implemented by subclasses to define
	 * how the actor's state changes over time.
	 */
	public abstract void updateActor();

	/**
	 * Abstract method to handle the actor taking damage.
	 * This method should be implemented by subclasses to define
	 * the behavior when the actor takes damage.
	 */
	@Override
	public abstract void takeDamage();

	/**
	 * Destroys the actor by setting its destroyed state to true.
	 */
	@Override
	public void destroy() {
		setDestroyed(true);
	}

	/**
	 * Sets the destroyed state of the actor.
	 *
	 * @param isDestroyed The new destroyed state of the actor.
	 */
	protected void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	/**
	 * Checks if the actor is destroyed.
	 *
	 * @return true if the actor is destroyed, false otherwise.
	 */
	public boolean isDestroyed() {
		return isDestroyed;
	}

}
