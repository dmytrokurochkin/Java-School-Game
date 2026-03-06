package drugaGrupa.Okna;
import drugaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    ArrayList<Wojownik> wojownicy;

    public MyPanel(ArrayList<Wojownik> wojownicy) {
        this.wojownicy = wojownicy;
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Wojownik gracz = wojownicy.get(0);

                if (e.getKeyCode() == KeyEvent.VK_W) {
                    gracz.setY(gracz.getY() - 10);
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    gracz.setX(gracz.getX() - 10);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    gracz.setY(gracz.getY() + 10);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    gracz.setX(gracz.getX() + 10);
                }

                // Kolizja
                for (int i = 1; i < wojownicy.size(); i++) {
                    if (koliduje(gracz, wojownicy.get(i))) {
                        // Cofnij ruch
                        if (e.getKeyCode() == KeyEvent.VK_W) {
                            gracz.setY(gracz.getY() + 10);
                        } else if (e.getKeyCode() == KeyEvent.VK_A) {
                            gracz.setX(gracz.getX() + 10);
                        } else if (e.getKeyCode() == KeyEvent.VK_S) {
                            gracz.setY(gracz.getY() - 10);
                        } else if (e.getKeyCode() == KeyEvent.VK_D) {
                            gracz.setX(gracz.getX() - 10);
                        }
                        break;
                    }
                }

                repaint();
            }
        });
    }

    private boolean koliduje(Wojownik a, Wojownik b) {
        return a.getX() < b.getX() + 50 &&
                a.getX() + 50 > b.getX() &&
                a.getY() < b.getY() + 50 &&
                a.getY() + 50 > b.getY();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Wojownik w : wojownicy) {
            g.drawString("hp: " + w.getHp(), w.getX(), w.getY());
            g.drawImage(w.getImg(), w.getX(), w.getY(), 50, 50, null);
        }
    }
}