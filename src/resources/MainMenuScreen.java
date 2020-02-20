package resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuScreen extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("Start Screen");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
			Parent root = (Parent) loader.load();
			Scene newScene = new Scene(root);
			Stage newStage = new Stage();
			newStage.setScene(newScene);
			newStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}