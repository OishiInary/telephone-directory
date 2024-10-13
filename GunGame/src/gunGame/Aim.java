package gunGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Aim {
    private int x, y;
    private static final int SIZE = 20; // 照準のサイズ

    public Aim(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE); // 照準を中央に描画
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // 照準の境界を取得する
    public Rectangle getBounds() {
        return new Rectangle(x - SIZE / 2, y - SIZE / 2, SIZE, SIZE);
    }
}
