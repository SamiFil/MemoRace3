package be.kdg.model.board;
import be.kdg.model.player.Player;
import javafx.scene.control.Label;
import java.util.ArrayList;

/**
 * Sami Filjak
 * 16/02/2023
 */
public class Spel {
    private ArrayList<Player> players;
    private int keuze1=0;
    private int keuze2=0;
    private Speelveld speelveld;
    private ArrayList<Integer> geradenKaarten;
    private int mouseclicks=0;
    private int currentPlayerIndex;

    public Spel() {
        this.speelveld = new Speelveld();
        this.geradenKaarten = new ArrayList<>();
        this.players = new ArrayList<Player>();
        this.currentPlayerIndex = 0;}

    public boolean paarGevonden() {
        if (speelveld.getKaarten().get(keuze1 - 1).getTypeCard().equals(speelveld.getKaarten().get(keuze2 - 1).getTypeCard())) {
            speelveld.getKaarten().get(keuze1 - 1).setIsGevondenToTrue();
            geradenKaarten.add(keuze1);
            geradenKaarten.add(keuze2);
            return true;
        }
        else {
            return false;
        }
    }
    public void setCurrentPlayerLabel(String playerName, Label currentPlayerLabel) {
        currentPlayerLabel.setText("Current Player: " + playerName);
        currentPlayerLabel.setId("playerLabel");
    }

    public ArrayList<Integer> getGeradenKaarten() {
        return geradenKaarten;
    }

    public void setMouseclicks() {
        mouseclicks = mouseclicks+1;
    }

    public void setKeuze1(int keuze1) {
        this.keuze1 = keuze1;
    }

    public void setKeuze2(int keuze2) {

        this.keuze2 = keuze2;
    }
    public int getKeuze1() {
        return keuze1;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Speelveld getSpeelveld() {
        return speelveld;
    }

    public void switchPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()) {
            currentPlayerIndex = 0;
        }
    }


    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

}
