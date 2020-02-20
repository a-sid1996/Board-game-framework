
import java.util.ArrayList;
import java.util.Scanner;

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

public class MenuScreenController {

    ArrayList<Player> list = new ArrayList<Player>();
    BoardModel bc;
    Card cm;
    Score score;
    PlayerTurnModule<Player> turn;
    Unit[] units;
    boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;

    @FXML
    void boardBtnClick(ActionEvent event) {

        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter height and width of intended Board");
        int height = s1.nextInt();
        int width = s1.nextInt();
        bc = new BoardModel(height, width);

        System.out.println("Do you want custom names for Tiles? \n (Enter Y/N)");
        bc.populateBoard(s1.next());

        System.out.println("Do you want custom connections for Tiles? \n (Enter Y/N)");
        if (s1.next().equals("Y")) {
            while (true) {
                System.out.println("Enter coordinate of tiles you want to connect? \n (Enter Y/N) \n (Enter Done when done)");
                if (s1.next().equalsIgnoreCase("Done"))
                    break;
                int xSource = s1.nextInt();
                int ySource = s1.nextInt();
                int xDest = s1.nextInt();
                int yDest = s1.nextInt();
                bc.tileConnectCoordinate(xSource, ySource, xDest, yDest);
            }
        } else {
            bc.setConnections();
        }

        System.out.println("Board created.");
        b1 = true;
        s1.close();

    }

    @FXML
    void cardsBtnClick(ActionEvent event) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of cards");
        int num = s.nextInt();
        cm = new Card(num);
        System.out.println("Deck of cards created");
        b2 = true;
        s.close();

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
    void playerBtnClick(ActionEvent event) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of players");
        int num = s.nextInt();
        s.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter name of player-");
            String name = s.nextLine();
            Player player = new Player(name);
            list.add(player);
        }
        System.out.println("Players created.");
        b3 = true;
        s.close();

    }

    @FXML
    void scoreBtnClick(ActionEvent event) {
        score = new Score();
        b4 = true;
    }

    @FXML
    void turnBtnClick(ActionEvent event) {
        turn = new PlayerTurnModule<Player>(list);
        b5 = true;
    }

    @FXML
    void unitBtnClick(ActionEvent event) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of units");
        int num = s.nextInt();
        s.nextLine();
        units = new Unit[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter name of this unit");
            String name = s.next();
            units[i] = new Unit(name);
            System.out.println("Enter amount for this unit " + name);
            int amt = s.nextInt();
            units[i].setAmount(amt);
            System.out.println("Are there any additional properties to this unit? \n (Enter Y/N)");
            String inp = s.next();
            if (inp.equalsIgnoreCase("Y")) {
                System.out.println("Enter number of properties.");
                int n = s.nextInt();
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter property name");
                    String prop = s.next();
                    System.out.println("Enter value");
                    String val = s.next();
                }
                System.out.println("Successfully created " + name + " unit!");
            }
        }
        b6 = true;
        s.close();
    }
}
