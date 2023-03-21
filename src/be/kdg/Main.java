package be.kdg;

import be.kdg.view.mainmenu.MainMenuPresenter;
import be.kdg.view.mainmenu.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Sami Filjak
 * 10/02/2023
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainMenuView mainmenuview = new MainMenuView();
        MainMenuPresenter mainmenupresenter = new MainMenuPresenter(mainmenuview);
        Scene scene = new Scene(mainmenuview);
        scene.getStylesheets().add(getClass().getResource("MainMenuCSS.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setHeight(1920);
        primaryStage.setWidth(1980);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Memory Game");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}
