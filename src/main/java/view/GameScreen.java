package view;

import javafx.scene.layout.BorderPane;
import viewcontroller.PokerGameController;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class GameScreen extends BorderPane {

    private VerticalPlayer playerla;
    private HorizontalPlayer playerua;
    private VerticalPlayer playerra;
    private HorizontalPlayer playerda;
    private BoardArea ba;

    /**
     * GameScreen's constructor
     * @param controller The PokerGameController to interact with
     */
    public GameScreen(PokerGameController controller) {
        playerla = new VerticalPlayer(controller.getLeftPlayer());
        playerua = new HorizontalPlayer(controller.getTopPlayer());
        playerra = new VerticalPlayer(controller.getRightPlayer());
        playerda = new HorizontalPlayer(controller.getBottomPlayer());
        ba = new BoardArea(controller.getBoard());
        this.setLeft(playerla.playerPane());
        this.setTop(playerua.playerPane());
        this.setBottom(playerda.playerPane());
        this.setRight(playerra.playerPane());
        this.setCenter(ba.getPane());
    }

    /**
     * This method is called whenever normal updates to the UI need to be made.
     */
    public void updatesMade() {
        playerla.update(false);
        playerua.update(false);
        playerra.update(false);
        playerda.update(true);
        ba.update();
    }

    /**
     * This method is called whenever a round of poker ends
     */
    public void endOfRound() {
        playerla.update(true);
        playerua.update(true);
        playerra.update(true);
        playerda.update(true);
        ba.update();
    }

}