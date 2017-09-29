package view;

import javafx.scene.layout.Pane;

import model.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public abstract class PlayerArea {

    private Pane pane;

    private Player player;

    private CardView c1;

    private CardView c2;

    private Label chip;

    private Label ofp;

    /**
     * PlayerArea's constructor
     * @param  pane   The Pane where all UI elements will be added. The type of
     * pane is decided by subclasses
     * @param  player The Player who's information will be tracked
     */
    public PlayerArea(Pane pane, Player player) {
        this.pane = pane;
        this.player = player;
        c1 = new CardView();
        c2 = new CardView();
        Label name = new Label(player.toString());
        chip = new Label("Chips: " + player.getMoney());
        ofp = new Label("Out of Play");
        ofp.setVisible(false);
        VBox v = new VBox();
        v.getChildren().addAll(name, chip, ofp);
        pane.getChildren().addAll(c1, c2, v);
    }

    /**
     * Getter for the Pane that contains all of the UI elements.
     * @return The Pane that contains all of the UI elements.
     */
    public Pane playerPane() {
        return pane;
    }

    /**
     * This method is called whenever an update to the UI needs to be made.
     * @param showDetails is true whenever the details of the front of the
     * cards are supposed to be shown false otherwise
     */
    public void update(boolean showDetails) {
        chip.setText("Chips: " + player.getMoney());

        if (player.getOutOfPlay()) {
            ofp.setVisible(true);
            c1.hide();
            c2.hide();
        } else {
            ofp.setVisible(false);
            c1.setCard(player.getCard(0));
            c2.setCard(player.getCard(1));
            if (showDetails) {
                c1.show();
                c2.show();
            } else {
                c1.hideDetails();
                c2.hideDetails();
            }
        }
    }

}