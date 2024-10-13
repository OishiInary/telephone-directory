package gunGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Target {
    private int x, y, size;
    private boolean visible;
    private long creationTime;
    private static final long LIFETIME = 10000; // ターゲットの寿命（10秒）
    private static final long BLINK_TIME = 2000; // 点滅を始める時間（残り2秒）

    public Target(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.visible = true;
        this.creationTime = System.currentTimeMillis(); // ターゲットが生成された時間を記録
    }

    // 的を描画
    public void draw(Graphics g) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - creationTime;

        if (elapsedTime >= LIFETIME) {
            visible = false; // 寿命が尽きたら非表示にする
        } else if (elapsedTime >= LIFETIME - BLINK_TIME) {
            // 残り2秒で点滅を開始
            if ((elapsedTime / 200) % 2 == 0) { // 0.2秒間隔で点滅
                g.setColor(Color.GREEN);
                g.fillOval(x - size / 2, y - size / 2, size, size);
            }
        } else if (visible) {
            g.setColor(Color.GREEN);
            g.fillOval(x - size / 2, y - size / 2, size, size);
        }
    }

    // 的が撃たれたときの処理
    public void hit() {
        visible = false; // 的を非表示にする
    }

    // 的の境界を取得
    public Rectangle getBounds() {
        return new Rectangle(x - size / 2, y - size / 2, size, size);
    }

    public boolean isVisible() {
        return visible;
    }

    // 寿命が過ぎているかどうかを確認するメソッド
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        return currentTime - creationTime > LIFETIME; // 生成からの時間が寿命を超えたかどうか
    }
}
