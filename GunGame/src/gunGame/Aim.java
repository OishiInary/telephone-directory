package gunGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Aim {
    private int x, y;  // 照準の位置
    private int size;  // 照準のサイズ

    public Aim(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    // 照準の位置を移動するメソッド
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    // 照準を描画するメソッド
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x - size / 2, y - size / 2, size, size);
    }

    // 照準の位置を取得するメソッド
    public Rectangle getBounds() {
        return new Rectangle(x - size / 2, y - size / 2, size, size);
    }

    // 照準の位置を設定するメソッド
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
