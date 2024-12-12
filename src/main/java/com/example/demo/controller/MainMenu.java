package com.example.demo.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMenu {

    private final Stage stage;

    public MainMenu(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        StackPane root = new StackPane();
        Button startButton = new Button("Start Game");
        startButton.setOnAction(event -> startGame());

        root.getChildren().add(startButton);
        Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }

    private void startGame() {
        Controller controller = new Controller(stage);
        controller.launchGame();
    }
}
