package view;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

@SuppressWarnings("restriction")
public class Alerts {

	
	protected static Alert exitProgramAlert() {
		Alert alert = new Alert(AlertType.INFORMATION, "Are you sure that you want to quit?", ButtonType.YES,
				ButtonType.CANCEL);
		alert.setTitle("Closing Program");
		alert.setHeaderText("Information will not be saved automatically!");
		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.YES) {
			System.exit(0);
		}

		return alert;
	}
}
