package gunGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Target {
    private int x, y, width, height;
    private boolean isHit;

    public Target(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isHit = false;
    }

    public void draw(Graphics g) {
        if (!isHit) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
    }

    public void hit() {
        isHit = true;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
