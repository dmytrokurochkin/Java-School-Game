package drugaGrupa;

import drugaGrupa.Okna.MojeOkno;
import drugaGrupa.wojownicy.Wojownik;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Wojownik> wojownicy = new ArrayList<>();
        Wojownik woj1 = new Wojownik(10, 10, 100, 20);
        Wojownik woj2 = new Wojownik(100, 100, 100, 20);
        wojownicy.add(woj1);
        wojownicy.add(woj2);
        new MojeOkno(600, 600, wojownicy);
    }
}
