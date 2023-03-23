package be.kdg.view.game;

import be.kdg.model.board.GameTimer;
import be.kdg.model.board.Spel;
import be.kdg.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GameView extends HBox {
    private Spel model;
    private Image achtergrond;
    private HashMap<ImageView, Integer> kaartMap;
    int rij = 0;
    int kolom = 0;
    private GridPane gridPane;
    private Button rollButton;
    private ImageView diceImage;
    private VBox scoreboardPanel;
    private VBox vBox;
    private Label[] nameLabel;
    private Label[] scoreLabel;
    private ImageView[] avatarLabel;
    private GameTimer gametimer;
    private Label currentPlayerLabel;
    private VBox vBox2;


    public GameView(Spel model) {
        this.model = model;
        this.initialiseNodes();
        updateScoreboard(model.getPlayers());
        this.layoutNodes();
    }

    public void initialiseNodes() {
        this.achtergrond = new Image("/mainmenubackground.png", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        rollButton = new Button("Roll");
        diceImage = new ImageView();
        scoreboardPanel = new VBox();
        gametimer = new GameTimer();
        model = new Spel();
        currentPlayerLabel = new Label();
        gridPane = new GridPane();
        vBox = new VBox();
        vBox2 = new VBox();
    }

    public void updateScoreboard(ArrayList<Player> players) {
        if(!scoreboardPanel.getChildren().isEmpty()){
        scoreboardPanel.getChildren().clear();}
        nameLabel = new Label[players.size()];
        scoreLabel = new Label[players.size()];
        avatarLabel = new ImageView[players.size()];
        for (int i = 0; i < players.size(); i++) {
            nameLabel[i] = new Label("");
            nameLabel[i].setTextFill(Paint.valueOf("#ffffff"));
            nameLabel[i].setId("playerLabel2");
            scoreLabel[i] = new Label("");
            scoreLabel[i].setTextFill(Paint.valueOf("#ffffff"));
            scoreLabel[i].setId("playerLabel2");
            avatarLabel[i] = new ImageView();
            avatarLabel[i].setFitHeight(200);
            avatarLabel[i].setFitWidth(200);
            scoreboardPanel.getChildren().addAll(nameLabel[i], scoreLabel[i], avatarLabel[i]);
        }
        for (int i = 0; i < players.size(); i++) {
            nameLabel[i].setText(players.get(i).getNaam());
            scoreLabel[i].setText("Geraden kaarten: " + players.get(i).getScore());
            Image avatarImage = players.get(i).getAvatar().getImage();
            ImageView avatarView = new ImageView(avatarImage);
            avatarView.setFitHeight(200);
            avatarView.setFitWidth(200);
            avatarLabel[i].setImage(avatarImage);
        }
    }

    public void layoutNodes() {
        setMaxWidth(Double.MAX_VALUE);
        for (int a = 1; a <= model.getSpeelveld().getKaarten().size(); a++) {
            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a - 1).getAchterkantKaart());
            imagevwAchterkant.setFitHeight(200);
            imagevwAchterkant.setFitWidth(200);
            kaartMap.put(imagevwAchterkant, a - 1);
            gridPane.add(imagevwAchterkant, kolom, rij);
            kolom = kolom + 1;
            if (a % 4 == 0 && a <= model.getSpeelveld().getKaarten().size()) {
                rij = rij + 1;
                kolom = 0;
            }
        }
        gametimer.setId("playerLabel");
        gridPane.setId("gridpane");
        gridPane.setAlignment(Pos.CENTER);
        diceImage.setFitHeight(200);
        diceImage.setFitWidth(200);
        rollButton.setMnemonicParsing(false);
        rollButton.setId("button");
        updateScoreboard(model.getPlayers());
        vBox.setSpacing(365);
        vBox2.getChildren().addAll(diceImage, rollButton);
        vBox.getChildren().addAll(gametimer, currentPlayerLabel,vBox2);
        setSpacing(300);
        getChildren().addAll(scoreboardPanel,gridPane,vBox);
    }

    public HashMap<ImageView, Integer> getKaartMap() {
        return kaartMap;
    }

    public Button getRollButton() {return rollButton;}

    public GameTimer getGametimer() {
        return gametimer;
    }

    public Spel getModel() {
        return model;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public Label getCurrentPlayerLabel() {
        return currentPlayerLabel;
    }

    public ImageView getDiceImage() {
        return diceImage;
    }
}
