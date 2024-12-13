package com.example.demo.controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class that serves as the entry point for the application.
 */
public class Main extends Application {

	private static final int SCREEN_WIDTH = 1300;
	private static final int SCREEN_HEIGHT = 750;
	private static final String TITLE = "Sky Battle";

	/**
	 * The start method is called after the application is launched and is responsible
	 * for setting up the primary stage and displaying the main menu.
	 *
	 * @param stage The primary stage for this application.
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle(TITLE);
		stage.setResizable(false);
		stage.setHeight(SCREEN_HEIGHT);
		stage.setWidth(SCREEN_WIDTH);

		// Show the main menu first
		MainMenu mainMenu = new MainMenu(stage);
		mainMenu.show();
	}

	/**
	 * The main method serves as the entry point for the application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		launch();
	}
}
