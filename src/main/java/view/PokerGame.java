package view;
import viewcontroller.PokerGameController;
import viewcontroller.GameState;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class PokerGame extends Application {
    private GameScreen gs;
    private ControlPane cp;
    private Console cs;
    private PokerGameController pgc;

    private static Stage primaryStage;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     * @param ps The primary Stage
     */
    public void start(Stage ps) {
        primaryStage = ps;
        Scene sc = new Scene(new StartScreen(this));
        primaryStage.setScene(sc);
        primaryStage.setTitle("Extreme Poker");
        primaryStage.show();
    }

    /**
     * Starts the Game
     * This is called by StartScreen whenever it is done and the GameScreen,
     * ControlPane, and Console should be displayed
     * @param name The name of the human player
     */
    public void startGame(String name) {
        pgc = new PokerGameController(this, name);
        gs = new GameScreen(pgc);
        cp = new ControlPane(pgc);
        cs = new Console();
        VBox vb = new VBox(3);
        vb.getChildren().addAll(gs, cp, cs);
        Scene sc = new Scene(vb);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Extreme Poker");
        primaryStage.show();
        pgc.start();
    }

    /**
     * This is called by PokerGameController whenever updates are made. You
     * must handle updating the UI here.
     */
    public void updatesMade() {
        if ((pgc.getState()).equals(GameState.DONE)) {
            gs.endOfRound();
            cp.endOfRound();
        } else if ((pgc.getState()).equals(GameState.AI_BET)) {
            gs.updatesMade();
            cp.aiTurn();
        } else if ((pgc.getState()).equals(GameState.HUMAN_BET)) {
            gs.updatesMade();
            cp.playerTurn();
        } else {
            gs.updatesMade();
        }
    }

    /**
     * This is the main method that launches the javafx application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}