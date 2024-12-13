package com.example.demo.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.LevelParent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Controller class responsible for managing the game levels and transitions.
 */
public class Controller {

	private static final String LEVEL_ONE_CLASS_NAME = "com.example.demo.LevelOne";
	private final Stage stage;

	/**
	 * Constructor for the Controller class.
	 *
	 * @param stage The primary stage for the application.
	 */
	public Controller(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Launches the game by transitioning to the first level.
	 */
	public void launchGame() {
		try {
			goToLevel(LEVEL_ONE_CLASS_NAME);
		} catch (Exception e) {
			showErrorAlert(e);
		}
	}

	/**
	 * Transitions to the specified level.
	 *
	 * @param className The fully qualified name of the level class.
	 */
	private void goToLevel(String className) {
		try {
			System.out.println("Controller: Transitioning to " + className);
			Class<?> myClass = Class.forName(className);
			Constructor<?> constructor = myClass.getConstructor(double.class, double.class);
			LevelParent myLevel = (LevelParent) constructor.newInstance(stage.getHeight(), stage.getWidth());
			myLevel.addObserver((observable, arg1) -> {
				try {
					goToLevel((String) arg1);
				} catch (Exception e) {
					showErrorAlert(e);
				}
			});
			Scene scene = myLevel.initializeScene();
			stage.setScene(scene);
			myLevel.startGame();
		} catch (Exception e) {
			showErrorAlert(e);
			e.printStackTrace(); // Print the stack trace for debugging
		}
	}

	/**
	 * Displays an error alert with the given exception's message.
	 *
	 * @param e The exception to display in the alert.
	 */
	private void showErrorAlert(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("An error occurred");
		alert.setContentText(e.getMessage());
		alert.show();
	}
}
