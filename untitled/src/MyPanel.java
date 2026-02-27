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
                super.keyPressed(e);
                //wasd - 87 65 83 68
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    wojownicy.get(0).setY(wojownicy.get(0).getY() - 10);
                    System.out.println(wojownicy.get(0).getY());
                    repaint();
                    //System.out.println("w");
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    wojownicy.get(0).setX(wojownicy.get(0).getX() - 10);
                    repaint();
                    //System.out.println("a");
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    wojownicy.get(0).setY(wojownicy.get(0).getY() + 10);
                    repaint();
                    //System.out.println("s");
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    wojownicy.get(0).setX(wojownicy.get(0).getX() + 10);
                    repaint();
                    //System.out.println("d");
                }
                System.out.println(e.getKeyCode() + " key pressed");
            }
        });
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
