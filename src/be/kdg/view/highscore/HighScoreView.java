package be.kdg.view.highscore;

import be.kdg.model.player.Score;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.List;

/**
 * Sami Filjak
 * 15/02/2023
 */
public class HighScoreView extends VBox {
    private Button back;
    private Image achtergrond;

    public HighScoreView() {
        this.initialiseNodes();
        this.layoutNodes();}

    private void initialiseNodes() {
        back = new Button("Back");
        achtergrond = new Image("mainmenubackground.png");
    }

    public Button getBack() {return back;}

    private void layoutNodes() {
        this.achtergrond = new Image("/mainmenubackground.png", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        back.setPrefSize(50, 30);
        setAlignment(Pos.TOP_CENTER);}
}
