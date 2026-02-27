import pierwszaGrupa.okna.MojeOkno;
import pierwszaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.util.ArrayList;

public class фMain {
    public static void main(String[] args) {
        ArrayList<Wojownik> wojownicy = new ArrayList<>();
        wojownicy.add(
                new Wojownik(
                        new ImageIcon("a.png").getImage(),
                        "Aragorn",
                        0,
                        0,
                        50,
                        100
                ));
        wojownicy.add(
                new Wojownik(
                        new ImageIcon("a.png").getImage(),
                        "Legolas",
                        150,
                        150,
                        50,
                        100
                ));
        new MojeOkno(300, 300, wojownicy);
    }
}