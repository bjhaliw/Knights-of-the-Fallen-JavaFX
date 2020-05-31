package view;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MainMenuGUI  {
	
	Stage stage;
	VBox box;
	CharacterCreationGUI characterCreationGUI;
	Scene scene;
	
	public MainMenuGUI(Stage stage) {
		this.stage = stage;
		box = loadMenuInformation();
		characterCreationGUI = new CharacterCreationGUI(stage);
	}
	
	public VBox loadMenuInformation() {
		VBox box = new VBox(25);
		box.setAlignment(Pos.CENTER);
		
		Button newGame = new Button("New Game");
		newGame.setOnAction(e -> {
			box.setVisible(false);
			stage.setScene(characterCreationGUI.getCharacterCreationGUI(scene));	
		});
		
		
		Button loadGame = new Button("Load Game");
		loadGame.setOnAction(e -> {
			
		});
		
		Button options = new Button("Options");
		options.setOnAction(e -> {
			
		});
		
		Button quitGame = new Button("Quit Game");
		
		quitGame.setOnAction(e -> {
			Alerts.exitProgramAlert();			
		});
		
		box.getChildren().addAll(newGame, loadGame, options, quitGame);
		
		return box;
		
	}
	
	public Scene getMainMenuGUI() {	
		scene = new Scene(box, MainDisplayGUI.windowWidth, MainDisplayGUI.windowHeight);
		
		return scene;
	}

}
