package gunGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ShootingGamePanel extends JPanel {
    private Aim aim;
    private TargetManager targetManager;
    private GameController controller;
    private boolean shouldFlash = false;

    public ShootingGamePanel(Aim aim, TargetManager targetManager, GameController controller) {
        this.aim = aim;
        this.targetManager = targetManager;
        this.controller = controller;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 背景の描画
        if (shouldFlash) {
            g.setColor(new Color(255, 255, 255, 128)); // フラッシュ時の白い色 (半透明)
            g.fillRect(0, 0, getWidth(), getHeight());
            shouldFlash = false;
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // 照準を描画
        aim.draw(g);

        // 的を描画
        targetManager.drawTargets(g);
    }

    // 画面をフラッシュさせるメソッド
    public void flashScreen() {
        shouldFlash = true;
        repaint(); // 再描画してフラッシュを反映
    }
}
