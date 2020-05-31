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
import javafx.scene.image.*;


@SuppressWarnings("restriction")
public class CharacterCreationGUI {
	
	Scene previousScene;
	Scene currentScreen;
	Stage stage;
	
	private int strength, dexterity, constitution, wisdom, intelligence, charisma;
	private String name, charClass;
	
	public CharacterCreationGUI(Stage stage) {
		this.stage = stage;
	}
	
	public void goToPreviousScene() {
		stage.setScene(previousScene);
	}
	
	public VBox createVBox() {
		VBox box = new VBox(10);
		box.setAlignment(Pos.CENTER);
		
		HBox title = new HBox();
		title.setAlignment(Pos.CENTER);
		Image titleImage = new Image("assets/knights2.png");
		ImageView titleImageView = new ImageView(titleImage);
		title.getChildren().add(titleImageView);
		
		HBox firstRow = createFirstRow();
		HBox secondRow = createSecondRow();
		
		
		box.getChildren().addAll(title, firstRow, secondRow);
		return box;
		
	}
		
	
	public HBox createFirstRow() {
		HBox firstRow = new HBox(10);
		firstRow.setAlignment(Pos.CENTER);
		Label nameLabel = new Label("Player Name:");
		TextField nameField = new TextField();
		nameField.setOnAction(e-> {
			name = nameField.getText();
			System.out.println(name);
		});
		Label classLabel = new Label("Player Class:");
		
		ChoiceBox classChoice = new ChoiceBox();
		classChoice.getItems().addAll("Archer", "Warrior", "Wizard");
		
		firstRow.getChildren().addAll(nameLabel, nameField, classLabel, classChoice);
		
		return firstRow;
	}
	
	public HBox createSecondRow() {
		
		HBox mainBox = new HBox(10);
		mainBox.setAlignment(Pos.CENTER);
		
		
		///// CREATING STRENGTH OBJECTS /////
		VBox strengthVBox = new VBox(10);
		strengthVBox.setAlignment(Pos.CENTER);
		HBox strengthHBox = new HBox(10);
		strengthHBox.setAlignment(Pos.CENTER);
		
		Label strengthLabel = new Label("STRENGTH");
		TextField strengthField = new TextField();
		strengthField.setMaxWidth(50);
		strengthField.setText("0");
		strengthField.setAlignment(Pos.CENTER);
		
		Button strengthPlus = new Button("+");
		strengthPlus.setOnAction(e -> {
			int amount = Integer.parseInt(strengthField.getText());
			amount++;
			strengthField.setText(String.valueOf(amount));
		});
		
		Button strengthMinus = new Button("-");
		strengthMinus.setOnAction(e -> {
			int amount = Integer.parseInt(strengthField.getText());
			amount--;
			strengthField.setText(String.valueOf(amount));
		});
		
		
		///// CREATING DEXTERITY OBJECTS /////
		VBox dexterityVBox = new VBox(10);
		dexterityVBox.setAlignment(Pos.CENTER);
		HBox dexterityHBox = new HBox(10);
		dexterityHBox.setAlignment(Pos.CENTER);

		Label dexterityLabel = new Label("DEXTERITY");
		TextField dexterityField = new TextField();
		dexterityField.setMaxWidth(50);
		dexterityField.setText("0");
		dexterityField.setAlignment(Pos.CENTER);
		
		Button dexterityPlus = new Button("+");
		dexterityPlus.setOnAction(e -> {
			int amount = Integer.parseInt(dexterityField.getText());
			amount++;
			dexterityField.setText(String.valueOf(amount));
		});
		
		Button dexterityMinus = new Button("-");
		dexterityMinus.setOnAction(e -> {
			int amount = Integer.parseInt(dexterityField.getText());
			amount--;
			dexterityField.setText(String.valueOf(amount));
		});
		
		dexterityHBox.getChildren().addAll(dexterityMinus, dexterityField, dexterityPlus);
		dexterityVBox.getChildren().addAll(dexterityLabel, dexterityHBox);
		
		strengthHBox.getChildren().addAll(strengthMinus, strengthField, strengthPlus);
		strengthVBox.getChildren().addAll(strengthLabel, strengthHBox);
		mainBox.getChildren().addAll(strengthVBox, dexterityVBox);
		
		return mainBox;
	}
	
	public Scene getCharacterCreationGUI(Scene previousScene) {
		this.previousScene = previousScene;
		this.currentScreen = new Scene(createVBox(), MainDisplayGUI.windowWidth, MainDisplayGUI.windowHeight);
		
		return this.currentScreen;
	}
	
	
}
