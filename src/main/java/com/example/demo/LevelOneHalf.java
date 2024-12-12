package com.example.demo;

public class LevelOneHalf extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "/com/example/demo/images/background1.jpg"; // Ensure this path is correct
    private static final String NEXT_LEVEL = "com.example.demo.LevelTwo";
    private static final int TOTAL_ENEMIES = 10; // Double the total enemies compared to LevelOne
    private static final int KILLS_TO_ADVANCE = 20; // Double the kills to advance compared to LevelOne
    private static final double ENEMY_SPAWN_PROBABILITY = .40; // Double the spawn probability compared to LevelOne
    private static final int PLAYER_INITIAL_HEALTH = 5;

    public LevelOneHalf(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
        System.out.println("LevelOneHalf: Constructor called");
    }

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

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

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

    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
    }

    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }
}
