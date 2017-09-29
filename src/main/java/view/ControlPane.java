package view;

import javafx.scene.layout.HBox;
import viewcontroller.PokerGameController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class ControlPane extends HBox {

    private PokerGameController cont;
    private Button raise;
    private Button call;
    private Button fold;
    private Button sanr;

    /**
     * Constructor for ControlPane
     * @param  cont The PokerGameController to interact with
     */
    public ControlPane(PokerGameController cont) {
        this.cont = cont;
        TextField input = new TextField();
        raise = new Button("Raise");
        call = new Button("Call");
        fold = new Button("Fold");
        sanr = new Button("Start a new Round");
        raise.setOnAction(e -> {
                try {
                    int amount = Integer.parseInt((input.getText()));
                    cont.humanBet(amount);
                } catch (NumberFormatException ex) {
                    Console.putMessage("Please enter a valid value");
                }
                input.setText("");
                input.requestFocus();
            });
        call.setOnAction(e -> {
                cont.humanCall();
            });
        fold.setOnAction(e -> {
                cont.humanFold();
            });
        sanr.setOnAction(e -> {
                sanr.setVisible(false);
                cont.startNewPokerHand();
            });
        raise.setDisable(true);
        call.setDisable(true);
        fold.setDisable(true);
        sanr.setVisible(false);
        this.getChildren().addAll(input, raise, call, fold, sanr);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Called whenever it becomes the player's turn again
     */
    public void playerTurn() {
        raise.setDisable(false);
        call.setDisable(false);
        fold.setDisable(false);
    }

    /**
     * Called whenever it becomes the AI's turn again
     */
    public void aiTurn() {
        raise.setDisable(true);
        call.setDisable(true);
        fold.setDisable(true);
    }

    /**
     * Method called when the round ends.
     */
    public void endOfRound() {
        sanr.setVisible(true);
    }

}