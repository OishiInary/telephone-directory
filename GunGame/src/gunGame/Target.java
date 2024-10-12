package gunGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Target {
    private int x;
    private int y;
    private boolean visible; // 的の表示状態を管理するフラグ
    private final int WIDTH = 30; // 的の幅
    private final int HEIGHT = 30; // 的の高さ

    public Target(int x, int y) {
        this.x = x;
        this.y = y;
        this.visible = true; // 初期状態は表示
    }

    // 的の位置を取得するためのメソッド
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    // 的を描画するメソッド
    public void draw(Graphics g) {
        if (visible) { // 表示状態がtrueのときだけ描画
            g.setColor(Color.GREEN); // 的の色
            g.fillRect(x, y, WIDTH, HEIGHT);
        }
    }

    // setVisibleメソッド
    public void setVisible(boolean visible) {
        this.visible = visible; // 表示状態を設定
    }

    // 的が撃たれたときの処理
    public void hit() {
        setVisible(false); // 当たったら非表示にする
    }

    // 追加: 的の位置を取得するためのメソッド
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 的が表示されているかどうかを取得
    public boolean isVisible() {
        return visible;
    }
}
