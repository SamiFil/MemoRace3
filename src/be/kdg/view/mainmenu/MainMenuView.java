package be.kdg.view.mainmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * Sami Filjak
 * 30/01/2023
 */
public class MainMenuView extends VBox {
    private Button start;
    private Button highScore;
    private Label memoryGame;
    private Label madeBy;
    private Label sami;
    private Label haron;
    private Image achtergrond;
    private Button exit;

    public MainMenuView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        start = new Button("Start");
        memoryGame = new Label();
        madeBy = new Label();
        sami = new Label();
        haron = new Label();
        highScore = new Button("Highscore");
        exit = new Button("Exit");
    }

    public Button getStart() {
        return start;
    }

    public Button getHighScore() {
        return highScore;
    }

    public Button getExit() {
        return exit;
    }

    private void layoutNodes() {
        this.achtergrond = new Image("/mainmenu.jpg", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        setSpacing(10);
        start.setPrefSize(160, 40);
        memoryGame.setFont(Font.font("Verdana", 31));
        memoryGame.setTextFill((Paint.valueOf("#ffffff")));
        memoryGame.setText("MEMORACE");
        madeBy.setFont(Font.font("Verdana", 15));
        madeBy.setTextFill((Paint.valueOf("#ffffff")));
        madeBy.setText("Made by:");
        sami.setFont(Font.font("Verdana", 15));
        sami.setTextFill((Paint.valueOf("#ffffff")));
        sami.setText("Sami Filjak");
        haron.setFont(Font.font("Verdana", 15));
        haron.setTextFill((Paint.valueOf("#ffffff")));
        haron.setText("Haron Badaoui");
        highScore.setPrefSize(160,40);
        exit.setPrefSize(160,40);
        setAlignment(Pos.CENTER);
        getChildren().addAll(memoryGame, madeBy, sami, haron, start, highScore, exit);
    }
}
