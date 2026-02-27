package pierwszaGrupa.wojownicy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MojAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("nadpisana");
    }
}
