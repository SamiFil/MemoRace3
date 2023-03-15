package be.kdg.view.game;

import be.kdg.model.board.Spel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class GamePresenter {
    private GameView gameView;
    private Spel model;

    private Boolean disableKeys = false;

    public GamePresenter(Spel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.addEventHandlers();
    }
    public void addEventHandlers() {
        gameView.updateScoreboard(model.getPlayers());
        gameView.getRollButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameView.roll(actionEvent);
            }
        });
        gameView.getGridPane().getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ImageView currentImage = (ImageView) mouseEvent.getSource();
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        model.setMouseclicks();
                        model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).setIsOmgedraaid(true);
                        currentImage.setImage(model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).getVoorkantKaart());
                        new Thread(() -> {
                            if (model.getKeuze1() == 0) {
                                model.setKeuze1(gameView.getKaartMap().get(currentImage) + 1);
                            } else {
                                model.setKeuze2(gameView.getKaartMap().get(currentImage) + 1);
                                if (!model.paarGevonden()) {
                                    model.switchPlayer();
                                    Platform.runLater(() -> {
                                        gameView.setCurrentPlayerLabel(model.getCurrentPlayer().getNaam());
                                    });
                                    gameView.getGridPane().setDisable(true);
                                    disableKeys = true;
                                    long startTime = System.currentTimeMillis();
                                    long elapsedTime;
                                    do {
                                        elapsedTime = System.currentTimeMillis() - startTime;
                                    } while (elapsedTime < 1000);
                                    ImageView eersteKeuzeImage = (ImageView) gameView.getGridPane().getChildren().get(model.getKeuze1() - 1);
                                    eersteKeuzeImage.setImage(model.getSpeelveld().getKaarten().get(model.getKeuze1() - 1).getAchterkantKaart());
                                    model.getSpeelveld().getKaarten().get(model.getKeuze1() - 1).setIsOmgedraaid(false);
                                    eersteKeuzeImage.setMouseTransparent(false);
                                    currentImage.setImage(model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).getAchterkantKaart());
                                    model.getSpeelveld().getKaarten().get(gameView.getKaartMap().get(currentImage)).setIsOmgedraaid(false);
                                    currentImage.setMouseTransparent(false);
                                    gameView.getGridPane().setDisable(false);
                                    disableKeys = false;
                                } else {
                                    gameView.getGridPane().setDisable(true);
                                    disableKeys = true;
                                    Platform.runLater(() -> {
                                                model.getCurrentPlayer().setScore(model.getCurrentPlayer().getScore() + 1);
                                    gameView.updateScoreboard(model.getPlayers());
                                    });
                                    gameView.getGridPane().setDisable(false);
                                    disableKeys = false;
                                }
                                model.setKeuze2(0);
                                model.setKeuze1(0);
                                if (model.getGeradenKaarten().size() == 16) {
                                    gameView.getGametimer().stop();
                                    Platform.runLater(() -> {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setHeaderText(null);
                                    alert.setContentText("Gefeliciteerd, jullie hebben alle kaarten gevonden in " + gameView.getGametimer().getSecondsPassed() + " seconden!");
                                    ButtonType stop = new ButtonType("Exit");
                                    alert.getButtonTypes().setAll(stop);
                                    Optional<ButtonType> result = alert.showAndWait();
                                    if (result.get() == stop) {
                                        Platform.exit();
                                    }
                                    });
                                }
                            }
                        }).start();
                    }
                }
            });
        });
    }}
