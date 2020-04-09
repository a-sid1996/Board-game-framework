package controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class newGameController {

	ObservableList<String> number = FXCollections.observableArrayList("2","3","4","5");
	
	@FXML
	private TextField mapLocation;


	@FXML
	void findFileClick(ActionEvent event) throws NumberFormatException, IOException {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON file", "*.json"));
		File file = fc.showOpenDialog(null);
		
		if(file != null) {
			mapLocation.setText(file.getAbsolutePath());
		}
		
		

	}
		
	
	
}
