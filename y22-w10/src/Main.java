public class Main {
    public static void main(String[] args) {
        Zahlenspeicher z = new Zahlenspeicher(100); // Anzahl der Elemente des Zahlenspeichers

        z.hinzufügen(7);
        z.hinzufügen(14);
        z.hinzufügen(21);
        z.hinzufügen(12);

        z.löscheLetzteZahl(); // 12 wieder löschen
//
//        if (z.finden(21)) {
//            System.out.println("Die 21 befindet sich im Zahlenspeicher");
//        }

        z.fülleMitZufallssahlen();
        z.augabeAlleZahlen(); // schreibt alle Zahlen im Zahlenspeicher in System.out

        z.sortiereZahlen();

        z.augabeAlleZahlen(); // schreibt alle Zahlen im Zahlenspeicher in System.out
        System.out.println(z.sindZahlenSortiert()
                ? "Zahlenspeicher ist sortiert"
                : "Zahlenspeicher ist nicht sortiert"
        );

        if (z.binäreSuche(14)) {
            System.out.println("Die 14 befindet sich im Zahlenspeicher");
        }
    }
}

class Zahlenspeicher {
    private int index;
    private int[] stack;

    Zahlenspeicher(int length) {
        this.index = 0;
        this.stack = new int[length];
    }

    public void hinzufügen(int n) {
        this.stack[this.index] = n;
        this.index++;
    }

    public void löscheLetzteZahl() {
        this.index--;
        this.stack[this.index] = 0;
    }

    public boolean binäreSuche(int n) {
        int ent = 0;
        int out = this.index - 1;

        while (ent < out) {
            int i = (ent + out) / 2;

            if (this.stack[i] == n) return true;
            if (this.stack[i] > n) out = i + 1;
            else ent = i + 1;
        }

        return false;
    }

    public boolean finden(int n) {
        for (int i = 0; i < this.index; i++)
            if (this.stack[i] == n) return true;

        return false;
    }

    public void augabeAlleZahlen() {
        System.out.print("[");
        for (int i = 0; i < this.index; i++)
            System.out.print((i != 0 ? ", " : "") + this.stack[i]);
        System.out.println("]");
    }

    public void fülleMitZufallssahlen() {
        // this.index = 0;

        while (this.index < this.stack.length)
            this.hinzufügen((int) Math.floor(Math.random() * 200 - 100));
    }

    public boolean sindZahlenSortiert() {
        for (int i = 1; i < this.index; i++)
            if (this.stack[i] < this.stack[i - 1]) return false;

        return true;
    }

    public void sortiereZahlen() {
        for (boolean fau = true; fau; ) {
            fau = false;

            for (int j = 1; j < this.index; j++) {
                if (this.stack[j] < this.stack[j - 1]) {
                    fau = true;

                    int n = this.stack[j];
                    this.stack[j] = this.stack[j - 1];
                    this.stack[j - 1] = n;
                }
            }
        }

    }
}