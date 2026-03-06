package drugaGrupa.Okna;
import drugaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    ArrayList<Wojownik> wojownicy;

    private boolean up, down, left, right;

    public MyPanel(ArrayList<Wojownik> wojownicy) {
        this.wojownicy = wojownicy;
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) up = true;
                if (e.getKeyCode() == KeyEvent.VK_S) down = true;
                if (e.getKeyCode() == KeyEvent.VK_A) left = true;
                if (e.getKeyCode() == KeyEvent.VK_D) right = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) up = false;
                if (e.getKeyCode() == KeyEvent.VK_S) down = false;
                if (e.getKeyCode() == KeyEvent.VK_A) left = false;
                if (e.getKeyCode() == KeyEvent.VK_D) right = false;
            }
        });

        Timer timer = new Timer(16, e -> updateGame());
        timer.start();
    }

    private void updateGame() {
        if (!wojownicy.isEmpty()) {
            Wojownik player = wojownicy.get(0);
            int speed = 5; // Скорость движения

            int oldX = player.getX();
            int oldY = player.getY();

            if (left) player.setX(player.getX() - speed);
            if (right) player.setX(player.getX() + speed);

            if (checkCollision(player)) {
                player.setX(oldX);
            }

            if (up) player.setY(player.getY() - speed);
            if (down) player.setY(player.getY() + speed);

            if (checkCollision(player)) {
                player.setY(oldY);
            }
        }

        repaint();
    }

    private boolean checkCollision(Wojownik player) {
        for (int i = 1; i < wojownicy.size(); i++) {
            if (koliduje(player, wojownicy.get(i))) {
                return true; // Найдено столкновение!
            }
        }
        return false;
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
            // Рисуем текст чуть выше картинки
            g.drawString("hp: " + w.getHp(), w.getX(), w.getY() - 5);
            g.drawImage(w.getImg(), w.getX(), w.getY(), 50, 50, null);
        }
    }
}