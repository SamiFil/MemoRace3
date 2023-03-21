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
    private VBox vBox;

    public MainMenuView() {
        this.initialiseNodes();
        this.layoutNodes();
//        getStylesheets().add(getClass().getResource("/MainMenuCSS.css").toExternalForm());
    }

    private void initialiseNodes() {
        start = new Button("Start");
        highScore = new Button("Highscore");
        exit = new Button("Exit");
        memory = new Image("memorace_logo.png");
        vBox = new VBox();
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
        imageView.setY(0);
        imageView.setFitWidth(800);
        imageView.setFitHeight(520);
        setSpacing(10);
//        start.setPrefSize(160, 40);
        start.getStyleClass().add("button");
//        highScore.setPrefSize(160,40);
        highScore.getStyleClass().add("button");
//        exit.setPrefSize(160,40);
        vBox.setSpacing(10);
        exit.getStyleClass().add("button");
        setAlignment(Pos.TOP_CENTER);
        getChildren().add(imageView);
        vBox.getStyleClass().add("btn-group");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(start, highScore, exit);
        getChildren().add(vBox);
    }
}
