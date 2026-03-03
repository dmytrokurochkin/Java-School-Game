package drugaGrupa.Okna;
import drugaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyPanel extends JPanel {
    ArrayList<Wojownik> wojownicy;

    private final Set<Integer> pressedKeys = new HashSet<>();
    private static final int SPEED = 4;
    private Timer gameLoop;

    public MyPanel(ArrayList<Wojownik> wojownicy) {
        this.wojownicy = wojownicy;
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
            }
        });

        gameLoop = new Timer(16, e -> {
            update();
            repaint();
        });
        gameLoop.start();
    }

    private void update() {
        if (wojownicy.isEmpty()) return;
        Wojownik hero = wojownicy.get(0);
        Wojownik enemy = wojownicy.get(1);

        if (pressedKeys.contains(KeyEvent.VK_W)) {
            hero.setY(hero.getY() - SPEED);
        }
        if (pressedKeys.contains(KeyEvent.VK_S)) {
            hero.setY(hero.getY() + SPEED);
        }
        if (pressedKeys.contains(KeyEvent.VK_A)) {
            if (enemy.getX() + 50 != hero.getX()) {
                hero.setX(hero.getX() - SPEED);
            }
        }
        if (pressedKeys.contains(KeyEvent.VK_D)) {
            if (enemy.getX() != hero.getX() + 50 || enemy.getY() != hero.getY()) {
                hero.setX(hero.getX() + SPEED);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*g.drawString("Hello World", 100, 100);
        g.drawRect(100, 100, 200, 200);
        Image image = new ImageIcon("aaaaaa.png").getImage();
        g.drawImage(image, 100, 100, null);
        */
        for (Wojownik w : wojownicy) {
            g.drawString("hp: " + w.getHp(), w.getX(), w.getY());
            g.drawImage(w.getImg(), w.getX(), w.getY(), 50, 50, null);
        }
    }
}