package com.example.demo;

/**
 * Class representing the intermediate level (Level One and a Half) of the game.
 * This class extends LevelParent and manages the specific behaviors and transitions for this level.
 */
public class LevelOneHalf extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background1.jpg"; // Ensure this path is correct
    private static final String NEXT_LEVEL = "com.example.demo.LevelTwo";
    private static final int TOTAL_ENEMIES = 10; // Double the total enemies compared to LevelOne
    private static final int KILLS_TO_ADVANCE = 30; // Triple the kills to advance compared to LevelOne
    private static final double ENEMY_SPAWN_PROBABILITY = .70; // Double the spawn probability compared to LevelOne
    private static final int PLAYER_INITIAL_HEALTH = 5;

    /**
     * Constructor for the LevelOneHalf class.
     *
     * @param screenHeight The height of the game screen.
     * @param screenWidth  The width of the game screen.
     */
    public LevelOneHalf(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
        System.out.println("LevelOneHalf: Constructor called");
    }

    /**
     * Checks if the game is over by either the user being destroyed or reaching the kill target.
     */
    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            System.out.println("LevelOneHalf: Game Over - User destroyed");
            loseGame();
        } else if (userHasReachedKillTarget()) {
            System.out.println("LevelOneHalf: Kill target reached, transitioning to next level");
            timeline.stop();
            goToNextLevel(NEXT_LEVEL);
        }
    }

    /**
     * Initializes friendly units by adding the user plane to the root.
     */
    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    /**
     * Spawns enemy units based on the spawn probability.
     */
    @Override
    protected void spawnEnemyUnits() {
        int currentNumberOfEnemies = getCurrentNumberOfEnemies();
        for (int i = 0; i < TOTAL_ENEMIES - currentNumberOfEnemies; i++) {
            if (Math.random() < ENEMY_SPAWN_PROBABILITY) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                EnemyPlane newEnemy = new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
                newEnemy.setFireRate(newEnemy.getFireRate() / 2); // Double the fire rate
                addEnemyUnit(newEnemy);
            }
        }
    }

    /**
     * Instantiates and returns a new LevelView for this level.
     *
     * @return The LevelView instance for this level.
     */
    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
    }

    /**
     * Checks if the user has reached the kill target required to advance to the next level.
     *
     * @return true if the user has reached the kill target, false otherwise.
     */
    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }
}
