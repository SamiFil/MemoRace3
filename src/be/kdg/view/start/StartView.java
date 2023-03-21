package be.kdg.view.start;

import be.kdg.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class StartView extends VBox {
    private Button addPlayers;
    private Button start;
    private HBox hBox;
    public List<Player> playerNames;
    private Image achtergrond;
    private Image vulNamen;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    public List<Player> getPlayerNames() {
        return playerNames;
    }

    private void initialiseNodes() {
        addPlayers = new Button("Add Players");
        start = new Button("Start");
        hBox = new HBox();
        playerNames = new ArrayList<Player>();
        this.achtergrond = new Image("/mainmenubackground.png", true);
        vulNamen = new Image("vul_namen_in.png");
    }
    private void layoutNodes() {
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        setSpacing(10);
        ImageView imageView = new ImageView(vulNamen);
        imageView.setX(400);
        imageView.setY(150);
        imageView.setFitWidth(800);
        imageView.setFitHeight(520);
        getChildren().add(imageView);
        addPlayers.setId("button2");
        start.setId("button2");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addPlayers, start);
        setAlignment(Pos.TOP_CENTER);
        getChildren().add(hBox);
    }

    public Button getAddPlayers() {
        return addPlayers;
    }

    public Button getStart() {
        return start;
    }
}
