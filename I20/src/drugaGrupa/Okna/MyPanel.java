package drugaGrupa.Okna;
import drugaGrupa.wojownicy.Wojownik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    ArrayList<Wojownik> wojownicy;

    // Флаги зажатых клавиш
    private boolean up, down, left, right;

    public MyPanel(ArrayList<Wojownik> wojownicy) {
        this.wojownicy = wojownicy;
        setFocusable(true);

        // Обработчик нажатий и отпусканий
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

        // Создаем таймер (Игровой цикл), который срабатывает каждые 16 миллисекунд (~60 FPS)
        Timer timer = new Timer(16, e -> updateGame());
        timer.start();
    }

    // Метод для обновления логики игры
    private void updateGame() {
        if (!wojownicy.isEmpty()) {
            Wojownik player = wojownicy.get(0);
            int speed = 5; // Скорость движения. Можно изменить.

            // Двигаем в зависимости от зажатых кнопок
            if (up) player.setY(player.getY() - speed);
            if (down) player.setY(player.getY() + speed);
            if (left) player.setX(player.getX() - speed);
            if (right) player.setX(player.getX() + speed);
        }

        // Даем команду Swing перерисовать этот компонент
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Wojownik w : wojownicy) {
            // Рисуем текст чуть выше картинки, чтобы они не слипались
            g.drawString("hp: " + w.getHp(), w.getX(), w.getY() - 5);
            g.drawImage(w.getImg(), w.getX(), w.getY(), 50, 50, null);
        }
    }
}