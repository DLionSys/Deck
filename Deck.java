import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    String suit;
    String color;
    String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }
}

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = { "Tréboles", "Corazones", "Picas" };
        String[] colors = { "Negro", "Rojo" };
        String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K" };

        for (String suit : suits) {
            for (String color : colors) {
                for (String value : values) {
                    cards.add(new Card(suit, color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        Card firstCard = cards.remove(0);
        System.out.println(firstCard.suit + "," + firstCard.color + "," + firstCard.value);
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public void pick() {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        Card pickedCard = cards.remove(randomIndex);
        System.out.println(pickedCard.suit + "," + pickedCard.color + "," + pickedCard.value);
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public void hand() {
        for (int i = 0; i < 5; i++) {
            Card drawnCard = cards.remove(0);
            System.out.println(drawnCard.suit + "," + drawnCard.color + "," + drawnCard.value);
        }
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
