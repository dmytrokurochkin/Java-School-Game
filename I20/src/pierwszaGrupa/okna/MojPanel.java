package pierwszaGrupa.okna;
import pierwszaGrupa.utils.Utils;
import pierwszaGrupa.wojownicy.Wojownik;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MojPanel extends JPanel {
    static int imgSize = 50; // do zmiany
    static int stepValue = 50;
    private static int[][] mapaKolizji;
    ArrayList<Wojownik> wojownicy;
    public MojPanel() {
        setBackground(Color.red);
    }
    private boolean checkOcupied(int x, int y) {
        return mapaKolizji[y][x] == 1;
    }
    public MojPanel(ArrayList<Wojownik> wojownicy, int width, int height) {
        mapaKolizji = new int[width/imgSize][height/imgSize];
        setBackground(Color.red);
        this.wojownicy = wojownicy;
        for(Wojownik w : wojownicy) {
            MojPanel.setMapaKolizji(w.getX()/MojPanel.getImgSize(),w.getY()/MojPanel.getImgSize(),1);
        }
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    if (!checkOcupied(wojownicy.get(0).getX()/MojPanel.getImgSize() + 1,wojownicy.get(0).getY()/MojPanel.getImgSize())) {
                        setMapaKolizji(wojownicy.get(0).getX()/MojPanel.getImgSize(),wojownicy.get(0).getY()/MojPanel.getImgSize(), 0);
                        wojownicy.get(0).setX(wojownicy.get(0).getX() + stepValue);
                        repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    if (!checkOcupied(wojownicy.get(0).getX()/MojPanel.getImgSize() - 1,wojownicy.get(0).getY()/MojPanel.getImgSize())) {
                        setMapaKolizji(wojownicy.get(0).getX()/MojPanel.getImgSize(),wojownicy.get(0).getY()/MojPanel.getImgSize(), 0);
                        wojownicy.get(0).setX(wojownicy.get(0).getX() - stepValue);
                        repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    if (!checkOcupied(wojownicy.get(0).getX()/MojPanel.getImgSize(),wojownicy.get(0).getY()/MojPanel.getImgSize() - 1)) {
                        setMapaKolizji(wojownicy.get(0).getX()/MojPanel.getImgSize(),wojownicy.get(0).getY()/MojPanel.getImgSize(), 0);
                        wojownicy.get(0).setY(wojownicy.get(0).getY() - stepValue);
                        repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (!checkOcupied(wojownicy.get(0).getX()/MojPanel.getImgSize(),wojownicy.get(0).getY()/MojPanel.getImgSize() + 1)) {
                        setMapaKolizji(wojownicy.get(0).getX()/MojPanel.getImgSize(),wojownicy.get(0).getY()/MojPanel.getImgSize(), 0);
                        wojownicy.get(0).setY(wojownicy.get(0).getY() + stepValue);
                        repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    wojownicy.get(1).setX(wojownicy.get(1).getX() + stepValue);
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    wojownicy.get(1).setX(wojownicy.get(1).getX() - stepValue);
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    wojownicy.get(1).setY(wojownicy.get(1).getY() - stepValue);
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    wojownicy.get(1).setY(wojownicy.get(1).getY() + stepValue);
                    repaint();
                }
                Utils.printMap(mapaKolizji);
            }
        });
    }

    private void clearPosition(int x, int y) {
        for (int i = x; i < x+5; i++) {
            for (int j = y; j < y+5; j++) {
                MojPanel.mapaKolizji[j/10][i/10] = 0;
                System.out.println(j + " " + i);
            }
        }
    }

    public static int[][] getMapaKolizji() {
        return mapaKolizji;
    }

    public static void setMapaKolizji(int x, int y,int value) {
        MojPanel.mapaKolizji[y][x] = value;
    }

    public static int getImgSize() {
        return imgSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Wojownik w : wojownicy) {
            mapaKolizji[w.getY()/imgSize][w.getX()/imgSize] = 1;
            g.drawImage(w.getImg(), w.getX(), w.getY(), 50, 50, this);
            g.drawString(w.getName(), w.getX() + 10, w.getY() + 10);
        }
    }
}
