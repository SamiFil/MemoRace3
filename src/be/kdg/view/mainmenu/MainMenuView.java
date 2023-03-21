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
    private Font font;

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
        font = Font.loadFont(getClass().getResource("/LuckiestGuy-Regular.ttf").toExternalForm(), 15);
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
        start.setId("button");
        highScore.getStyleClass().add("button");
        highScore.setId("button");
        vBox.setSpacing(10);
        exit.getStyleClass().add("button");
        exit.setId("button");
        setAlignment(Pos.TOP_CENTER);
        getChildren().add(imageView);
        vBox.getStyleClass().add("btn-group");
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(start, highScore, exit);
        getChildren().add(vBox);
    }
}
