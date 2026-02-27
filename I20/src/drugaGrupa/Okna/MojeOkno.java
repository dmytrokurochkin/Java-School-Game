package drugaGrupa.Okna;

import drugaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.util.ArrayList;

public class MojeOkno extends JFrame {
    private static int windowWidth, windowHeight;
    public static int getWindowWidth() {
        return windowWidth;
    }
    public static int getWindowHeight() {
        return windowHeight;
    }
    public MojeOkno(int w, int h, ArrayList<Wojownik> wojownicy) {
        this.setSize(w, h);
        windowHeight = h;
        windowWidth = w;
        this.add(new MyPanel(wojownicy));
        this.setVisible(true);
    }
    public MojeOkno() {
        this.setVisible(true);
        this.setSize(200, 200);
    }
}
