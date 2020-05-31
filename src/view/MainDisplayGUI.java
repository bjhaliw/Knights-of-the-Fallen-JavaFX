package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MainDisplayGUI extends Application {
	
	static int windowWidth = 700;
	static int windowHeight = 720;
	
	MainMenuGUI mainMenuGUI;
	CharacterCreationGUI characterCreationGUI;


	@Override
	public void start(Stage primaryStage) throws Exception {
		mainMenuGUI = new MainMenuGUI(primaryStage);
		characterCreationGUI = new CharacterCreationGUI(primaryStage);
		Scene scene = mainMenuGUI.getMainMenuGUI();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main Menu");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
