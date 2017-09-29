package view;

import javafx.scene.layout.HBox;
import model.Board;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class BoardArea {

    private HBox pane;

    private Board board;

    private CardView c1;

    private CardView c2;

    private CardView c3;

    private CardView c4;

    private CardView c5;

    private Label pot;

    /**
     * Constructor for the board's display
     * @param  board The Board object that contains data associated with the
     * board
     */
    public BoardArea(Board board) {
        this.board = board;
        pane = new HBox();
        c1 = new CardView();
        c2 = new CardView();
        c3 = new CardView();
        c4 = new CardView();
        c5 = new CardView();
        pot = new Label("Pot: " + board.getPot());
        pane.getChildren().addAll(c1, c2, c3, c4, c5, pot);
        pane.setAlignment(Pos.CENTER);
    }

    /**
     * Getter for the HBox that all UI elements are on
     * @return the HBox that all Board UI elements are on
     */
    public HBox getPane() {
        return pane;
    }

    /**
     * Updates UI elements
     */
    public void update() {
        CardView[] carray = {c1, c2, c3, c4, c5};
        for (int i = 0; i < 5; i++) {
            carray[i].hide();
        }
        for (int i = 0; i < board.getNumCards(); i++) {
            carray[i].setCard(board.getTableCard(i));
            carray[i].show();
        }
        pot.setText("Pot: " + board.getPot());
    }

}