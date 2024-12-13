package com.example.demo.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * MainMenu class responsible for displaying the main menu of the game.
 */
public class MainMenu {

    private final Stage stage;

    /**
     * Constructor for the MainMenu class.
     *
     * @param stage The primary stage for the application.
     */
    public MainMenu(Stage stage) {
        this.stage = stage;
    }

    /**
     * Displays the main menu with a background image, title, and start button.
     */
    public void show() {
        StackPane root = new StackPane();

        // Add background image
        try {
            Image backgroundImage = new Image(getClass().getResource("/com/example/demo/images/backgroundmm.jpg").toExternalForm());
            BackgroundImage background = new BackgroundImage(backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));
            root.setBackground(new Background(background));
        } catch (NullPointerException e) {
            System.out.println("Background image not found: " + e.getMessage());
        }

        // Create title
        Label title = new Label("Sky Battle");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 150)); // Triple the font size
        title.setStyle("-fx-text-fill: #ffffff; -fx-effect: dropshadow(gaussian, black, 2, 1, 1, 1);");

        // Create start button
        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 20px; -fx-background-color: #ff6347; -fx-text-fill: white;");
        startButton.setOnAction(event -> startGame());

        // Use VBox to align title and button vertically
        VBox vbox = new VBox(20, title, startButton);
        vbox.setAlignment(Pos.CENTER);

        // Move title up by 100 units
        title.setTranslateY(-100);

        // Move start button down by 100 units
        startButton.setTranslateY(100);

        root.getChildren().add(vbox);
        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Starts the game by initializing the Controller and launching the game.
     */
    private void startGame() {
        Controller controller = new Controller(stage);
        controller.launchGame();
    }
}
