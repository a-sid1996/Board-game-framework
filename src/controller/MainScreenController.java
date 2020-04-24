package controller;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;


/**
* This class is the main controller class of the main screen
*/
public class MainScreenController  {
	
	/**
	* This method is called when new game button is clicked
	*@param new game button clicking event
	*/
	@FXML
	 void newGameClick(ActionEvent event) throws NumberFormatException, IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/newGame.fxml"));
            Parent root = (Parent) loader.load();
            Scene newScene = new Scene(root);
            Stage newStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	 }
	
	/**
	* This method is called when user clicks on map edit button to change values of existing map files
	*@param Map edit button clicking even
	*/
	@FXML
	 void mapEditorClick(ActionEvent event) throws NumberFormatException, IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MapEdit.fxml"));
            Parent root = (Parent) loader.load();
            Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
	 }
	
	/**
	* Helper method that prints message on the screen and calls another method
	*@param even type
	*/
	@FXML
	 void helpClick(ActionEvent event) throws NumberFormatException, IOException{
		System.out.println("Coming soon!");
//		new ViewerCtrl();
	 }
	
	@FXML
	public Button exitBtn;
	
	@FXML
	public Button loadBtn;
	
	/**
	*This method is called after user clicks exit game button
	*@param even object used above
	*/
	@FXML
	 void exitClick(ActionEvent event) throws NumberFormatException, IOException{
	    Stage stage = (Stage) exitBtn.getScene().getWindow();
	    stage.close();
	 }
	
	@FXML
	void tournamentBtnClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TournamentScreen.fxml"));
            Parent root = (Parent) loader.load();
            Scene newScene = new Scene(root);
            Stage newStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            newStage.setScene(newScene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	@FXML
    void loadBtnCLick(ActionEvent event) throws IOException, ClassNotFoundException {
		SaveAndLoad saveAndLoad = new SaveAndLoad();
		GameController gc = saveAndLoad.loadGame();
		newGameController.startGame(gc, event);
	}
	
//    @FXML
//    void loadBtnCLick(ActionEvent event) {
//
//    	//Your code here
//
//
//    	GameController gc = new GameController(bc, card, players, score, ptm);
//
//	    try {
//	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameScreen.fxml"));
//	        Parent root = (Parent) loader.load();
//	        Scene newScene = new Scene(root);
//	        Stage newStage = (Stage)((Node)event.getSource()).getScene().getWindow();
//	        newStage.setScene(newScene);
//	        newStage.show();
//	        gameScreenController controller = loader.getController();
//	        controller.setGameController(gc);
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//    }
	
}
