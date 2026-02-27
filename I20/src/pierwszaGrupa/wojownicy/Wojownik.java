package pierwszaGrupa.wojownicy;
import pierwszaGrupa.okna.MojPanel;

import java.awt.*;
public class Wojownik {
    Image img;
    String name;
    int x, y, damage, hp;
    public Wojownik(Image img, String name, int x, int y, int damage, int hp) {
        this.img = img;
        this.name = name;
        this.x = x;
        this.y = y;
        this.damage = damage;
        this.hp = hp;





    }

    public Image getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
