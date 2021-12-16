public class Card {
    String color; // red, green, blue, yellow
    Integer value; // number 0 - 9

    // ~ constructor
    Card(String col, Integer val) {
        this.color = col != null ? col : "red";
        this.value = val != null ? val : 0;
    }

    // ~ actions
    void pull() {
        System.out.format("Pulled card is \"%s %d\"\n", this.color, this.value);
    }

    void deal() {
        System.out.format("Dealt card is \"%s %d\"\n", this.color, this.value);
    }

}


