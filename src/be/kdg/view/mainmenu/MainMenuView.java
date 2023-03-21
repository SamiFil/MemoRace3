package be.kdg.view.mainmenu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Image achtergrond;
    private Button exit;
    private Image memory;

    public MainMenuView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        start = new Button("Start");
        highScore = new Button("Highscore");
        exit = new Button("Exit");
        memory = new Image("memorace_logo.png");
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
        this.achtergrond = new Image("/mainmenubackground.png", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        ImageView imageView = new ImageView(memory);
        imageView.setX(400);
        imageView.setY(150);
        imageView.setFitWidth(400);
        imageView.setFitHeight(260);
        setSpacing(10);
        start.setPrefSize(160, 40);
        highScore.setPrefSize(160,40);
        exit.setPrefSize(160,40);
        setAlignment(Pos.CENTER);
        getChildren().add(imageView);
        getChildren().addAll(start, highScore, exit);
    }
}
