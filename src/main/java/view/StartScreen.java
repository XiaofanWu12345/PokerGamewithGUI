package view;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;


/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class StartScreen extends StackPane {

    // Path to the image file for the background
    private static final String BACK_LOCATION = "File:./src/main/res"
        + "/poker-game-background.png";

    /**
     * StartScreen's constructor
     * @param cont The PokerGame to interact with
     */
    public StartScreen(PokerGame cont) {
        ImageView imv = new ImageView(new Image(BACK_LOCATION));
        Button b = new Button("Start New Game");
        b.setTranslateX(-400);
        b.setTranslateY(200);
        b.setOnAction(e -> {
                TextInputDialog txtIn = new TextInputDialog();
                txtIn.setTitle("New Game");
                txtIn.setHeaderText("Confirmation");
                txtIn.setContentText("Enter your name:");
                if (txtIn.showAndWait().isPresent()) {
                    String name = txtIn.getEditor().getCharacters().toString();
                    cont.startGame(name);
                }
            });
        getChildren().addAll(imv, b);
    }

}