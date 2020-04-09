package resources;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controller.GameController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.BoardModel;
import model.Card;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;

public class MenuScreenController1 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Player> list = new ArrayList<Player>();
    BoardModel bc;
    Card cm;
    Score score;
    PlayerTurnModule<Player> turn;
    Unit[] units;
    boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;

    @FXML
    void boardBtnClick(ActionEvent event) throws NumberFormatException, IOException {

        System.out.println("Enter height of intended Board");
        int height = Integer.parseInt(br.readLine());
        System.out.println("Enter width of intended Board");
        int width = Integer.parseInt(br.readLine());
        bc = new BoardModel(height, width);

        System.out.println("Do you want custom names for Tiles? \n (Enter Y/N)");
        String resp = br.readLine();
        bc.populateBoard(resp);

        System.out.println("Do you want custom connections for Tiles? \n (Enter Y/N)");
        if (br.readLine().equals("Y")) {
            while (true) {
                System.out.println("Enter coordinate of tiles you want to connect? \n (Enter Done when done)");
                String first = br.readLine();
                if (first.equalsIgnoreCase("Done"))
                    break;
                int xSource = Integer.parseInt(first);
                int ySource = Integer.parseInt(br.readLine());
                int xDest = Integer.parseInt(br.readLine());
                int yDest = Integer.parseInt(br.readLine());
                bc.connectTiles(xSource, ySource, xDest, yDest);
                System.out.println("Tiles connected.");
            }
        } else {
            bc.setConnections();
        }
        System.out.println("Board created.");
        System.out.println(bc);
        b1 = true;
    }

    @FXML
    void cardsBtnClick(ActionEvent event) throws NumberFormatException, IOException {
        System.out.println("Enter number of cards");
        int num = Integer.parseInt(br.readLine());
        cm = new Card(num);
        System.out.println("Deck of cards created");
        b2 = true;

    }

    @FXML
    void exitBtnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void playBtnClick(ActionEvent event) {
        if (b1 && b2 && b3 && b4 && b5 && b6) {
            GameController gc = new GameController(bc, cm, list, score, turn, units);
        } else {
            System.out.println("Following frameworks have not been configured yet.");
            if (!b1) {
                System.out.println("Board");
            }
            if (!b2) {
                System.out.println("Cards");
            }
            if (!b3) {
                System.out.println("Player");
            }
            if (!b4) {
                System.out.println("Score");
            }
            if (!b5) {
                System.out.println("Turn");
            }
            if (!b6) {
                System.out.println("Unit");
            }
        }
    }

    @FXML
    void playerBtnClick(ActionEvent event) throws NumberFormatException, IOException {
        System.out.println("Enter number of players");
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            System.out.println("Enter name of player-");
            String name = br.readLine();
            Player player = new Player(name, this.units, this.score);
            list.add(player);
        }
        System.out.println("Players created.");
        b3 = true;

    }

    @FXML
    void scoreBtnClick(ActionEvent event) {
        score = new Score();
        System.out.println("Score Module initiated");
        b4 = true;
    }

    @FXML
    void turnBtnClick(ActionEvent event) {
        turn = new PlayerTurnModule<Player>(list);
        System.out.println("Turn Module initiated");
        b5 = true;
    }

    @FXML
    void unitBtnClick(ActionEvent event) throws IOException {
        System.out.println("Enter number of units");
        int num = Integer.parseInt(br.readLine());
        ;
        units = new Unit[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter name of this unit");
            String name = br.readLine();
            units[i] = new Unit(name);
            System.out.println("Enter amount for this unit " + name);
            int amt = Integer.parseInt(br.readLine());
            units[i].setAmount(amt);
            System.out.println("Are there any additional properties to this unit? \n (Enter Y/N)");
            String inp = br.readLine();
            if (inp.equalsIgnoreCase("Y")) {
                System.out.println("Enter number of properties.");
                int n = Integer.parseInt(br.readLine());
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter property name");
                    String prop = br.readLine();
                    System.out.println("Enter value");
                    String val = br.readLine();
                    units[i].setProperty(prop, val);
                }
            }
            System.out.println("Successfully created " + name + " unit!");
        }
        b6 = true;
    }
}
