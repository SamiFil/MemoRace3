package be.kdg.model.board;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.util.Random;

/**
 * Sami Filjak
 * 8/03/2023
 */
public class Dice extends ImageView {
    private Random random = new Random();

    public void roll(ActionEvent actionEvent, Button rollButton, ImageView diceImage) {
        rollButton.setDisable(true);
        Thread thread = new Thread() {
            public void run() {
                try {
                    //For-loopt 15 keer willekeurig door de dobbelsteen ImageView's en stopt daarna bij een willekeurige foto
                    for (int i = 0; i < 15; i++) {
                        ImageView imageView = new ImageView("dice/" + (random.nextInt(6)+1) + ".jpg");
                        diceImage.setImage(imageView.getImage());
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

}
