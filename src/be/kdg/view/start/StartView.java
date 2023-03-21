package be.kdg.view.start;

import be.kdg.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private Label naam;
    private Button start;
    private HBox hBox;
    public List<Player> playerNames;
    private Image achtergrond;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    public List<Player> getPlayerNames() {
        return playerNames;
    }

    private void initialiseNodes() {
        addPlayers = new Button("Add Players");
        naam = new Label("Voer namen in: ");
        start = new Button("Start");
        hBox = new HBox();
        playerNames = new ArrayList<Player>();
        this.achtergrond = new Image("/mainmenu.jpg", true);
    }
    private void layoutNodes() {
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        setSpacing(10);
        addPlayers.setPrefSize(100, 30);
        start.setPrefSize(100,30);
        naam.setFont(Font.font("Verdana", 31));
        naam.setTextFill((Paint.valueOf("#ffffff")));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addPlayers, start);
        setAlignment(Pos.CENTER);
        getChildren().addAll(naam, hBox);
    }

    public Button getAddPlayers() {
        return addPlayers;
    }

    public Label getNaam() {
        return naam;
    }

    public Button getStart() {
        return start;
    }
}
