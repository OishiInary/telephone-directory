package gunGame;

import java.awt.Color;
import java.awt.Graphics;

public class Aim {
    private int x;
    private int y;

    public Aim(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - 10, y - 10, 20, 20);
    }
}
