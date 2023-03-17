package be.kdg.view.game;

import be.kdg.model.board.GameTimer;
import be.kdg.model.board.Spel;
import be.kdg.model.player.Player;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
    private Random random;
    private VBox scoreboardPanel;
    private VBox vBox;
    private Label[] nameLabel;
    private Label[] scoreLabel;
    private ImageView[] avatarLabel;
    private StartPresenter startPresenter;
    private StartView startView;
    private GameTimer gametimer;
    private Label currentPlayerLabel;
    private GridPane outerGridPane;



    public GameView(Spel model) {
        this.model = model;
        this.initialiseNodes();
        updateScoreboard(model.getPlayers());
        this.layoutNodes();
    }

    public void initialiseNodes() {
        startView = new StartView();
        startPresenter = new StartPresenter(startView);
        this.achtergrond = new Image("/Background.jpg", true);
        this.setBackground(new Background(new BackgroundImage(achtergrond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        kaartMap = new HashMap<>();
        HBox hbox = new HBox();
        rollButton = new Button("Roll");
        diceImage = new ImageView();
        random = new Random();
        scoreboardPanel = new VBox();
        gametimer = new GameTimer();
        model = new Spel();
        gametimer.start();
        currentPlayerLabel = new Label();
        gridPane = new GridPane();
        vBox = new VBox();
        outerGridPane = new GridPane();
    }

    public void updateScoreboard(ArrayList<Player> players) {
        if(!scoreboardPanel.getChildren().isEmpty()){
        scoreboardPanel.getChildren().clear();}
        nameLabel = new Label[players.size()];
        scoreLabel = new Label[players.size()];
        avatarLabel = new ImageView[players.size()];
        for (int i = 0; i < players.size(); i++) {
            nameLabel[i] = new Label("");
            nameLabel[i].setFont(Font.font("Verdana", 20));
            nameLabel[i].setTextFill(Paint.valueOf("#ffffff"));
            scoreLabel[i] = new Label("");
            scoreLabel[i].setFont(Font.font("Verdana", 20));
            scoreLabel[i].setTextFill(Paint.valueOf("#ffffff"));
            avatarLabel[i] = new ImageView();
            avatarLabel[i].setFitHeight(100);
            avatarLabel[i].setFitWidth(100);
            scoreboardPanel.getChildren().addAll(nameLabel[i], scoreLabel[i], avatarLabel[i]);
        }
        for (int i = 0; i < players.size(); i++) {
            nameLabel[i].setText(players.get(i).getNaam());
            scoreLabel[i].setText("Geraden kaarten: " + Integer.toString(players.get(i).getScore()));
            Image avatarImage = players.get(i).getAvatar().getImage();
            ImageView avatarView = new ImageView(avatarImage);
            avatarView.setFitHeight(30);
            avatarView.setFitWidth(30);
            avatarLabel[i].setImage(avatarImage);
        }
    }
    public void setCurrentPlayerLabel(String playerName) {
        currentPlayerLabel.setText("Current Player: " + playerName);
        currentPlayerLabel.setFont(Font.font("Verdana", 20));
        currentPlayerLabel.setTextFill(Paint.valueOf("#ffffff"));
    }

    public void roll(ActionEvent actionEvent) {
        rollButton.setDisable(true);
        Thread thread = new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 15; i++) {
                        File file = new File((random.nextInt(6) + 1) + ".jpg");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                    }
                    rollButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }



    public void layoutNodes() {
        setMaxWidth(Double.MAX_VALUE);
        for (int a = 1; a <= model.getSpeelveld().getKaarten().size(); a++) {
            ImageView imagevwAchterkant = new ImageView(model.getSpeelveld().getKaarten().get(a - 1).getAchterkantKaart());
            imagevwAchterkant.setFitHeight(100);
            imagevwAchterkant.setFitWidth(100);
            kaartMap.put(imagevwAchterkant, a - 1);
            gridPane.add(imagevwAchterkant, kolom, rij);
            kolom = kolom + 1;
            if (a % 4 == 0 && a <= model.getSpeelveld().getKaarten().size()) {
                rij = rij + 1;
                kolom = 0;
            }
        }
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        diceImage.setFitHeight(200);
        diceImage.setFitWidth(200);
        rollButton.setMnemonicParsing(false);
        rollButton.setPrefSize(50, 30);
        updateScoreboard(model.getPlayers());
        vBox.getChildren().addAll(gametimer.getTimerTekst(), currentPlayerLabel,diceImage, rollButton);
        getChildren().addAll(scoreboardPanel,gridPane,vBox);

//        getChildren().addAll(gridPane,scoreboardPanel,vBox);
    }

    public HashMap<ImageView, Integer> getKaartMap() {
        return kaartMap;
    }

    public Button getRollButton() {
        return rollButton;
    }

    public GameTimer getGametimer() {
        return gametimer;
    }

    public ImageView getDiceImage() {
        return diceImage;
    }

    public Spel getModel() {
        return model;
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
