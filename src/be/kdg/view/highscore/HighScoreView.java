package be.kdg.view.highscore;

import be.kdg.model.player.HighScore;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;

/**
 * Sami Filjak
 * 15/02/2023
 */
public class HighScoreView extends VBox {
    private Button back;
    private Image achtergrond;
    private HighScore highScore = new HighScore("highscores.txt");
    private VBox vBox;
    private Image highScoreslogo;

    public HighScoreView() throws IOException {
        this.initialiseNodes();
        this.layoutNodes();}

    private void initialiseNodes() {
        back = new Button("Back");
        achtergrond = new Image("mainmenubackground.png");
        vBox = new VBox();
        highScoreslogo = new Image("highscores.png");
    }

    public Button getBack() {return back;}

    private void layoutNodes() throws IOException {
        highScore.loadHighScores();
        highScore.showHighScores(vBox);
        this.achtergrond = new Image("/mainmenubackground.png", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        ImageView imageView = new ImageView(highScoreslogo);
        imageView.setX(400);
        imageView.setY(150);
        imageView.setFitWidth(800);
        imageView.setFitHeight(520);
        back.setId("button");
        setAlignment(Pos.TOP_CENTER);
        setSpacing(20);
        getChildren().addAll(imageView,vBox, back);
    }

}
