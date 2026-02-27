package pierwszaGrupa.okna;
import pierwszaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.util.ArrayList;

public class MojeOkno extends JFrame {
    public MojeOkno() {
        this.setSize(200, 200);
        this.setVisible(true);
    }
    public MojeOkno(int width, int height) {
        this.setSize(width, height);
        add(new MojPanel());
        this.setVisible(true);
    }
    public MojeOkno(int width, int height, ArrayList<Wojownik> wojownicy) {
        this.setSize(width, height);
        add(new MojPanel(wojownicy, width, height));
        this.setVisible(true);
    }
}
