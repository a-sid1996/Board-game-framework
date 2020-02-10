import controller.BoardController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuScreenController {

	@FXML
	void boardBtnClick(ActionEvent event) {
		BoardController bc = new BoardController();
	}

	@FXML
	void cardsBtnClick(ActionEvent event) {

	}

	@FXML
	void exitBtnClick(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void playBtnClick(ActionEvent event) {

	}

	@FXML
	void playerBtnClick(ActionEvent event) {

	}

	@FXML
	void scoreBtnClick(ActionEvent event) {

	}

	@FXML
	void turnBtnClick(ActionEvent event) {

	}

	@FXML
	void unitBtnClick(ActionEvent event) {

	}

}
