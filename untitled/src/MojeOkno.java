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

    public static void setWindowWidth(int windowWidth) {
        MojeOkno.windowWidth = windowWidth;

    }

    public static void setWindowHeight(int windowHeight) {
        MojeOkno.windowHeight = windowHeight;
    }

    public MojeOkno() {
        this.setVisible(true);
        this.setSize(200, 200);
    }
    public MojeOkno(int w, int h, ArrayList<Wojownik> wojownicy) {
        this.setSize(w, h);
        windowHeight = h;
        windowWidth = w;
        this.add(new MyPanel(wojownicy));
        this.setVisible(true);
    }
}
