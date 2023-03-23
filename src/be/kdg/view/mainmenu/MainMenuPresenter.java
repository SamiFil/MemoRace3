package be.kdg.view.mainmenu;
import be.kdg.view.highscore.HighScorePresenter;
import be.kdg.view.highscore.HighScoreView;
import be.kdg.view.start.StartPresenter;
import be.kdg.view.start.StartView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Sami Filjak
 * 30/01/2023
 */

public class MainMenuPresenter {
    private MainMenuView mainMenuView;

    public MainMenuPresenter(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
        addEventHandlers();

    }

    private void addEventHandlers() {
        mainMenuView.getStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartView startView = new StartView();

                    StartPresenter startPresenter = new StartPresenter(startView);
                mainMenuView.getScene().setRoot(startView);

            }
        });
        mainMenuView.getHighScore().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HighScoreView highScoreView = new HighScoreView();
                HighScorePresenter highScorePresenter = new HighScorePresenter(highScoreView);
                mainMenuView.getScene().setRoot(highScoreView);

            }
        });
        mainMenuView.getExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
    }
}
