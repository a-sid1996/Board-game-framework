package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import controller.gameScreenController.GameControlObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.BoardModel;
import model.Card;
import model.Dice;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Tile;
import model.Unit;

public class tournamentController {

    ObservableList<String> playerNum = FXCollections.observableArrayList("2", "3", "4", "5");
    ObservableList<String> gameNum = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> mapNum = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> playerStrategy = FXCollections.observableArrayList("Aggresive", "Conservative", "Random", "Cheater");

    @FXML
    private GridPane resultGrid;

    @FXML
    private Button exitBtn;

    @FXML
    private ComboBox<String> mapBox;

    @FXML
    private ComboBox<String> playerBox;

    @FXML
    private ComboBox<String> playerStrategyBox;

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

    public TextField[] mapL;
    public Button[] findMapBtn;
    public TextField[] maxMoveL;
    public ComboBox<String>[] pStrat;

    @SuppressWarnings("unchecked")
    private void initializeButtonArray() {
        // TODO Auto-generated method stub

        mapL = new TextField[5];
        mapL[0] = mapL1;
        mapL[1] = mapL2;
        mapL[2] = mapL3;
        mapL[3] = mapL4;
        mapL[4] = mapL5;

        findMapBtn = new Button[5];
        findMapBtn[0] = findMapBtn1;
        findMapBtn[1] = findMapBtn2;
        findMapBtn[2] = findMapBtn3;
        findMapBtn[3] = findMapBtn4;
        findMapBtn[4] = findMapBtn5;

        maxMoveL = new TextField[5];
        maxMoveL[0] = maxMoveL1;
        maxMoveL[1] = maxMoveL2;
        maxMoveL[2] = maxMoveL3;
        maxMoveL[3] = maxMoveL4;
        maxMoveL[4] = maxMoveL5;

        pStrat = new ComboBox[4];
        pStrat[0] = pStrat1;
        pStrat[1] = pStrat2;
        pStrat[2] = pStrat3;
        pStrat[3] = pStrat4;
    }

    @FXML
    void initialize() {
        playerBox.setItems(playerNum);
//        playerStrategyBox.setItems(playerStrategy);
        gameBox.setItems(gameNum);
        mapBox.setItems(mapNum);

        enterMax.setVisible(false);

        initializeButtonArray();

        for (int i = 0; i < 5; i++) {
            mapL[i].setVisible(false);
            maxMoveL[i].setVisible(false);
            findMapBtn[i].setVisible(false);
        }

        for (int i = 0; i < 4; i++) {
            pStrat[i].setVisible(false);
            pStrat[i].setItems(playerStrategy);
        }

    }

    @FXML
    void gameBoxClick(ActionEvent event) {
        int gameN = Integer.parseInt(gameBox.getValue());

        for (int i = 0; i < gameN; i++) {
            maxMoveL[i].setVisible(true);
        }
    }

    @FXML
    void mapBoxCLick(ActionEvent event) {
        int mapN = Integer.parseInt(mapBox.getValue());

        for (int i = 0; i < mapN; i++) {
            mapL[i].setVisible(true);
            findMapBtn[i].setVisible(true);
        }
    }

    @FXML
    void playerBoxClick(ActionEvent event) {
        int playerN = Integer.parseInt(playerBox.getValue());

        for (int i = 0; i < playerN; i++) {
            pStrat[i].setVisible(true);
        }
    }

    private void findLocation(TextField mapL12) {
        //TODO Auto-generated method stub

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON file", "*.json"));
        File file = fc.showOpenDialog(null);

        if (file != null) {
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
    ArrayList<String> al = new ArrayList<String>();
    @FXML
    void pStrat1Click(ActionEvent event) {
        String playerType1 = (pStrat1.getValue());
        al.add(playerType1);
    }

    @FXML
    void pStrat2Click(ActionEvent event) {
        String playerType2 = (pStrat2.getValue());
        al.add(playerType2);
    }

    @FXML
    void pStrat3Click(ActionEvent event) {
        String playerType3 = (pStrat3.getValue());
        al.add(playerType3);
    }

    @FXML
    void pStrat4Click(ActionEvent event) {
        String playerType4 = (pStrat4.getValue());
        al.add(playerType4);
    }

    @FXML
    void startBtnClick(ActionEvent event) throws JSONException, IOException, InvalidMapException {

        if (checkError(mapBox, "Map")) {
            return;
        }

        if (checkError(playerBox, "Player")) {
            return;
        }

        if (checkError(gameBox, "Game")) {
            return;
        }

        for (int i = 0; i < Integer.parseInt(gameBox.getValue()); i++) {
            int max = Integer.parseInt(maxMoveL[i].getText()) - 1;

            for (int j = 0; j < Integer.parseInt(mapBox.getValue()); j++) {
                String location = mapL[j].getText();
                int numPLayers = Integer.valueOf(playerBox.getValue());
                BoardModel bc = new BoardModel();
                MapJsonParser m = new MapJsonParser();
                bc.setBoard(m.MapJsonParser1(location));


                Score score = new Score();
                Unit[] units = new Unit[2];
                units[0] = new Unit("money", 10000000);
                units[1] = new Unit("hotel", 1000);

                ArrayList<Tile> t = new ArrayList<Tile>();
                t.add(bc.getBoard().get(0));

                Player bank = new Player("bank", units, score, t);

                ArrayList<Player> players = new ArrayList<Player>();
                players.add(bank);

                for (i = 0; i < numPLayers; i++) {
                    Unit[] unitP = new Unit[2];
                    unitP[0] = new Unit("money", 1500);
                    unitP[1] = new Unit("hotel", 0);
                    ArrayList<Tile> t1 = new ArrayList<Tile>();
                    t1.add(bc.getBoard().get(0));
                    Player p = new Player("player" + i, unitP, score, t1,al.get(i));
                    System.out.println(p.getName() + " " +p.getPlayerType() +  " " +p.getCurrentTile());
                    players.add(p);
                }



                Card card = new Card(12);

                card.setDesc(1, "Move To Go");
                card.setDesc(2, "Bank error in your favor. Collect $125");
                card.setDesc(3, "You have won a CrossWord Competition. Collect $100");
                card.setDesc(4, "You have been elected as the Chairman of the Board. Pay each player $50");
                card.setDesc(5, "Building loan matures. Collect $150 from Bank");
                card.setDesc(6, "Go To Jail. Do not pass Go. Do not collect $100");
                card.setDesc(7, "You inherit $100");
                card.setDesc(8, "Hospital fees. Pay $50");
                card.setDesc(9, "Grand Opera Night. Collect $50 from every player for opening night seats");
                card.setDesc(10, "You are assessed for street repairs. Pay $40 per plot");
                card.setDesc(11, "Go to Jail. Pay $50 to the bank");
                card.setDesc(12, "Advance to go. Collect 200$ from bank");


                PlayerTurnModule<Player> ptm = new PlayerTurnModule<Player>(new ArrayList<>(players.subList(1, players.size())));
                GameController gc = new GameController(bc, card, players, score, ptm, false);

                String winner = "";

                for (int k = 0; k < max; k++) {

                    Player p = gc.nextPlayer();

                    if (p.getMoney() < 0) {
                        System.out.println("Since the user is already in debt he is eliminated.");
                        gc.removePlayer(p);
                    } else {
                        if (gc.list.size() <= 2) {
                            System.out.println(gc.list.get(1).getName() + " has won!!");
                            winner = gc.list.get(1).getName();
                            return;
                        }

                        Dice dice = new Dice(1);
                        int result = dice.diceroll();
                        System.out.println("User rolled a " + result);
                        gc.movePlayer(p, result, gc);

                    }

                }
                if (winner == "") {
                    winner = "Draw";
                }

                System.out.println(winner);
            }
        }
    }

    private boolean checkError(ComboBox<String> box, String string) {
        // TODO Auto-generated method stub

        if (box.getValue() == null) {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText(string + " box input is not valid.");
            errorAlert.showAndWait();
            return true;
        }

        for (int i = 0; i < Integer.parseInt(box.getValue()); i++) {
            if (string.equals("Map")) {
                if (mapL[i].getText().isEmpty()) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText(i + "th" + string + " box input is not valid.");
                    errorAlert.showAndWait();
                    return true;
                }
            } else if (string.equals("Game")) {
                if (maxMoveL[i].getText().isEmpty()) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText(i + "th" + string + " box input is not valid.");
                    errorAlert.showAndWait();
                    return true;
                }
            } else {
                if (pStrat[i].getValue() == null) {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("Input not valid");
                    errorAlert.setContentText(i + "th" + string + " box input is not valid.");
                    errorAlert.showAndWait();
                    return true;
                }
            }
        }
        return false;
    }

    @FXML
    void exitBtnClick(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}
