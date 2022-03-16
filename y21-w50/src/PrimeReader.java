class PrimeReader {
    public static void main(String[] args) {
        /*
         * Objektorientierung - Aufgabe 3
         *
         * Entwerfen Sie eine Klasse, die Primzahlen erzeugen kann,
         * beginnend bei einem Startwert, welcher dem Konstruktor zu
         * übergeben ist. Mit Hilfe einer Methode generiere() wird
         * die jeweils nächste Primzahl zurückgegeben.
         */

        PrimeStepper create = new PrimeStepper(100_000, 23);
        PrimeStepper.Result result;

        // ~ yield until limit is reached
        System.out.format("\nStepping through %d primes following %d\n", (long) create.limit, (long) create.start);
        do {
            //        ...  .generiere();
            result = create.next();
            System.out.format("\n%d of %d : %d", (long) create.state, (long) create.limit, (long) result.value);
        } while (!result.done);
    }
}

class PrimeStepper {
    // ~ state
    public double start;
    public double value;
    public double state;
    public double limit;

    // ~ yield value
    private PrimeStepper.Result current;

    public static class Result {
        public double value;
        public boolean done;

        // ~ constructor
        Result(double value, boolean done) {
            this.value = value;
            this.done = done;
        }
    }

    // ~ constructor
    PrimeStepper(double start, double limit) {
        this.start = start;
        this.value = start % 2 == 0 ? start - 1 : start;
        this.limit = limit;
        this.state = 0;

        // ~ begin search for primes
        this.nextContinue();
    }

    // ~ actions
    //                     ... generiere() {
    public PrimeStepper.Result next() {
        // ~ limit was reached on a previous call
        if (this.current != null && this.current.done) return this.current;
        this.state += 1;

        // ~ read current and continue search
        this.current = new PrimeStepper.Result(this.value, this.state >= this.limit);
        if (!this.current.done) this.nextContinue();

        // ~ yield current
        return this.current;
    }

    private void nextContinue() {
        this.value += 2;
        while (this.isComposite(this.value)) {
            this.value += this.value % 10 == 3 ? 4 : 2; // skip multiples of 5
        }
    }

    private boolean isComposite(double n) {
         for (int i = 2; i < n / 2; ++i) if (n % i == 0) return true;
         return false;
    }
}
