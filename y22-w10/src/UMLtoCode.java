import java.time.LocalDateTime;
import java.util.List;

class Karte {
    private double grundPreis;
    private LocalDateTime spilTag;
    private LocalDateTime gekauftAm;

    Karte(double kartenPreis, LocalDateTime kaufTag, LocalDateTime spielTag) {
        // [...]
    }

    public double BerechneKartenPreis() {
        // [...]
        return 0d;
    }
}

abstract class Kunde {
    private String name;
    private Karte[] Karten;

    Kunde(String name) {
        // [...]
    }

    public double BerechneKartenPreis() {
        // [...]
        return 0d;
    }

    public void KaufeKarte(double grundPreis, LocalDateTime kaufTag, LocalDateTime spielTag) {
        // [...]
    }
}

class VIPKunde extends Kunde {
    private String telefonnummer;

    VIPKunde(String name, String telefonnummer) {
        super(name);
        // [...]
    }

    VIPKunde(String name, String telefonnummer, List<VIPKunde> freunde) {
        super(name);
        // [...]
    }

    @Override
    public double BerechneKartenPreis() {
        // [...]
        return 0d;
    }
}

class FanKunde extends Kunde {
    private String clubName;

    // ? "Kunde(...)" auf dem UML {
    FanKunde(String name, String clubName) {
        super(name);
        // [...]
    }

    @Override
    public double BerechneKartenPreis() {
        // [...]
        return 0d;
    }
}

class SpontanKunde extends Kunde {
    private String email;

    SpontanKunde(String name, String email) {
        super(name);
        // [...]
    }

    @Override
    public double BerechneKartenPreis() {
        // [...]
        return 0d;
    }
}

class Loge {
    private int nummer;
    private int anzahlSitzpleatze;
}
