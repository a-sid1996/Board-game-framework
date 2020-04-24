package controller;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class tournamentController {

	ObservableList<String> playerNum = FXCollections.observableArrayList("2","3","4","5");
	ObservableList<String> gameNum = FXCollections.observableArrayList("1","2","3","4","5");
	ObservableList<String> mapNum = FXCollections.observableArrayList("1","2","3","4","5");
	ObservableList<String> playerStrategy = FXCollections.observableArrayList("Aggresive", "Conservative", "Random", "Cheater");

    @FXML
    private ComboBox<String> mapBox;

    @FXML
    private ComboBox<String> playerBox;

    @FXML
    private ComboBox<String> gameBox;

    @FXML
    private Button startBtn;

    @FXML
    private TextField mapL1;

    @FXML
    private Button findMapBtn1;

    @FXML
    private TextField mapL2;

    @FXML
    private Button findMapBtn2;

    @FXML
    private TextField mapL3;

    @FXML
    private Button findMapBtn3;

    @FXML
    private TextField mapL4;

    @FXML
    private Button findMapBtn4;

    @FXML
    private TextField mapL5;

    @FXML
    private Button findMapBtn5;

    @FXML
    private ComboBox<String> pStrat1;

    @FXML
    private ComboBox<String> pStrat2;

    @FXML
    private ComboBox<String> pStrat3;

    @FXML
    private ComboBox<String> pStrat4;

    @FXML
    private TextField maxMoveL1;

    @FXML
    private TextField maxMoveL2;

    @FXML
    private TextField maxMoveL3;

    @FXML
    private TextField maxMoveL4;

    @FXML
    private TextField maxMoveL5;

    @FXML
    private Text enterMax;
    
	@FXML
	void initialize() {
		playerBox.setItems(playerNum);
		gameBox.setItems(gameNum);
		mapBox.setItems(mapNum);
		
		enterMax.setVisible(false);
		
		mapL1.setVisible(false);
		mapL2.setVisible(false);
		mapL3.setVisible(false);
		mapL4.setVisible(false);
		mapL5.setVisible(false);
				
		maxMoveL1.setVisible(false);
		maxMoveL2.setVisible(false);
		maxMoveL3.setVisible(false);
		maxMoveL4.setVisible(false);
		maxMoveL5.setVisible(false);
		
		pStrat1.setVisible(false);
		pStrat2.setVisible(false);
		pStrat3.setVisible(false);
		pStrat4.setVisible(false);
		
		findMapBtn1.setVisible(false);
		findMapBtn2.setVisible(false);
		findMapBtn3.setVisible(false);
		findMapBtn4.setVisible(false);
		findMapBtn5.setVisible(false);

	}

    @FXML
    void gameBoxClick(ActionEvent event) {
		int gameN = Integer.parseInt(gameBox.getValue());
		switch(gameN) {
			case (1):
				maxMoveL1.setVisible(true);
				break;
			case (2):
				maxMoveL1.setVisible(true);
				maxMoveL2.setVisible(true);
				break;
			case (3):
				maxMoveL1.setVisible(true);
				maxMoveL2.setVisible(true);
				maxMoveL3.setVisible(true);
				break;
			case (4):
				maxMoveL1.setVisible(true);
				maxMoveL2.setVisible(true);
				maxMoveL3.setVisible(true);
				maxMoveL4.setVisible(true);
				break;
			case (5):
				maxMoveL1.setVisible(true);
				maxMoveL2.setVisible(true);
				maxMoveL3.setVisible(true);
				maxMoveL4.setVisible(true);
				maxMoveL5.setVisible(true);
				break;
		}
    }

    @FXML
    void mapBoxCLick(ActionEvent event) {
		int mapN = Integer.parseInt(mapBox.getValue());
		switch(mapN) {
			case (1):
				mapL1.setVisible(true);
				findMapBtn1.setVisible(true);
				break;
			case (2):
				mapL1.setVisible(true);
				findMapBtn1.setVisible(true);
				mapL2.setVisible(true);
				findMapBtn2.setVisible(true);
				break;
			case (3):
				mapL1.setVisible(true);
				findMapBtn1.setVisible(true);
				mapL2.setVisible(true);
				findMapBtn2.setVisible(true);
				mapL3.setVisible(true);
				findMapBtn3.setVisible(true);
				break;
			case (4):
				mapL1.setVisible(true);
				findMapBtn1.setVisible(true);
				mapL2.setVisible(true);
				findMapBtn2.setVisible(true);
				mapL3.setVisible(true);
				findMapBtn3.setVisible(true);
				mapL4.setVisible(true);
				findMapBtn4.setVisible(true);
				break;
			case (5):
				mapL1.setVisible(true);
				findMapBtn1.setVisible(true);
				mapL2.setVisible(true);
				findMapBtn2.setVisible(true);
				mapL3.setVisible(true);
				findMapBtn3.setVisible(true);
				mapL4.setVisible(true);
				findMapBtn4.setVisible(true);
				mapL5.setVisible(true);
				findMapBtn5.setVisible(true);
				break;
			}
    }
    
    @FXML
    void playerBoxClick(ActionEvent event) {
    	int playerN = Integer.parseInt(playerBox.getValue());
		switch(playerN) {
			case (1):
				pStrat1.setVisible(true);
				break;
			case (2):
				pStrat1.setVisible(true);
				pStrat2.setVisible(true);
				break;
			case (3):
				pStrat1.setVisible(true);
				pStrat2.setVisible(true);
				pStrat3.setVisible(true);
				break;
			case (4):
				pStrat1.setVisible(true);
				pStrat2.setVisible(true);
				pStrat3.setVisible(true);
				pStrat4.setVisible(true);
				break;
		}
    }

    private void findLocation(TextField mapL12) {
		// TODO Auto-generated method stub
		
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON file", "*.json"));
		File file = fc.showOpenDialog(null);
		
		if(file != null) {
			mapL12.setText(file.getAbsolutePath());
		}    	
	}
    
    @FXML
    void findMapBtn1Click(ActionEvent event) {
    	findLocation(mapL1);
    }

	@FXML
    void findMapBtn2Click(ActionEvent event) {
    	findLocation(mapL2);
    }

    @FXML
    void findMapBtn3Click(ActionEvent event) {
    	findLocation(mapL3);
    }

    @FXML
    void findMapBtn4Click(ActionEvent event) {
    	findLocation(mapL4);
    }

    @FXML
    void findMapBtn5Click(ActionEvent event) {
    	findLocation(mapL5);
    }

//    @FXML
//    void pStrat1Click(ActionEvent event) {
//
//    }
//
//    @FXML
//    void pStrat2Click(ActionEvent event) {
//
//    }
//
//    @FXML
//    void pStrat3Click(ActionEvent event) {
//
//    }
//
//    @FXML
//    void pStrat4Click(ActionEvent event) {
//
//    }
//
    
    @FXML
    void startBtnClick(ActionEvent event) {
    	
    }

}
