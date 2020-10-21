import java.util.Random;

import javax.xml.crypto.dsig.TransformService;

public class Spieler extends Person {
    public int staerke; // 1 - 10
    public int torschuss; // 1 - 10
    public int motivation; // 1 - 10
    public int tore;

    public Spieler(String n, int a, int s, int t, int m) {
        super(n, a);
        staerke = s;
        torschuss = t;
        motivation = m;
        tore = 0;
    }
}