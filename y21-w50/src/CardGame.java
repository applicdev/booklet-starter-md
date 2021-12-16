public class CardGame {
    public static void main(String[] args) {
        Card myCard_green_8 = new Card("green", 8);
        Card myCard_blue_9 = new Card("blue", 9);

        myCard_green_8.pull();
        myCard_blue_9.deal();
    }
}
