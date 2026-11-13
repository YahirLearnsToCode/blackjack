public class Card {
    private String suit;
    private String value;
    private boolean faceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
    }

    public String getSuit() {
        // only return the suit if the card is face up
        if (faceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        // only return the value if the card is face up
        if (faceUp) {
            // this is the string value of the card
            // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        // only return the value if the card is face up
        if (faceUp) {

            switch (this.value) {
                case "2", "3", "4", "5", "6", "7", "8", "9", "10" -> {
                    return Integer.parseInt(this.value);
                }
                case "J", "Q", "K" -> {
                    return 10;
                }
                case "A" -> {
                    return 11;
                }
                default -> throw new RuntimeException("No Valid case");
            }
        } else return 0;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }
}

