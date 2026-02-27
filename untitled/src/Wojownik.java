import javax.swing.*;
import java.awt.*;

public class Wojownik {
    int x, y, hp, damage;
    Image img = new ImageIcon("C:\\Users\\MrMozozavr\\Documents\\Main_Folder\\My_Images\\sbushnyk.jpg").getImage() ;
    public Wojownik(int x, int y, int hp, int damage) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public Image getImg() {
        return img;
    }

    public void setX(int x) {
        this.x = this.x = x % MojeOkno.getWindowWidth();;
        if (this.x < 0){
            this.x = MojeOkno.getWindowWidth() + this.x;
        }
    }

    public void setY(int y) {
        this.y = this.y = y % MojeOkno.getWindowWidth();;
        if (this.y < 0){
            this.y = MojeOkno.getWindowWidth() + this.y;
        }
    }
}
