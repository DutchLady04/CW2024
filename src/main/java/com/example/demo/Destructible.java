package com.example.demo;

/**
 * Interface representing a destructible entity in the game.
 * Classes implementing this interface should provide functionality
 * to take damage and be destroyed.
 */
public interface Destructible {

	/**
	 * Method to handle the entity taking damage.
	 * Implementing classes should define the behavior when the entity takes damage.
	 */
	void takeDamage();

	/**
	 * Method to destroy the entity.
	 * Implementing classes should define the behavior when the entity is destroyed.
	 */
	void destroy();

}
