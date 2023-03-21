package be.kdg.view.highscore;

import be.kdg.model.player.Score;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * Sami Filjak
 * 15/02/2023
 */
public class HighScoreView extends VBox {
    private Button back;

    public HighScoreView() {
        this.initialiseNodes();
        this.layoutNodes();}

    private void initialiseNodes() {
        back = new Button("Back");

    }

    public Button getBack() {return back;}

    private void layoutNodes() {
        back.setPrefSize(50, 30);
        setAlignment(Pos.TOP_CENTER);
        setLayoutY(40);
        setSpacing(20);

    }
}
