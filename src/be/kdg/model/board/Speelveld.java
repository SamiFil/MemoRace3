package be.kdg.model.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Sami Filjak
 * 23/12/2022
 */
public class Speelveld {
    private ArrayList<Card> cardArrayList;


    public Speelveld() {
        cardArrayList = new ArrayList<>();
        Card boston = new Card("Boston Celtics", "cards/1.png");
        Card nets = new Card("Brooklyn Nets", "cards/2.png");
        Card bulls = new Card("Chicago Bulls", "cards/3.png");
        Card cavs = new Card("Cleveland Caveliers", "cards/4.png");
        Card warriors = new Card("Golden States Warriors", "cards/5.png");
        Card rockets = new Card("Houston Rockets", "cards/6.png");
        Card lakers = new Card("LA Lakers", "cards/7.png");
        Card heat = new Card("Miami Heat", "cards/8.png");
        // Alle Cards dubbel toeveogen aan 'kaarten'
        Card[] kaarten = {boston, nets, bulls, cavs, warriors, rockets, lakers, heat, boston, nets, bulls, cavs, warriors, rockets, lakers, heat};
        // Voegt de eerste 16 kaarten van de kaartenlijst toe aan de cardArrayList
        cardArrayList.addAll(Arrays.asList(kaarten).subList(0, 16));
        // Schudt de kaarten in de cardArrayList om ze willekeurig te rangschikken
        Collections.shuffle(cardArrayList);
    }
    public ArrayList<Card> getKaarten() {
        return cardArrayList;
    }
}
