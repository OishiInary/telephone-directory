package gunGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ShootingGamePanel extends JPanel {
    private Aim aim;
    private TargetManager targetManager;
    private GameController controller;
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;

    public ShootingGamePanel(Aim aim, TargetManager targetManager, GameController controller) {
        this.aim = aim;
        this.targetManager = targetManager;
        this.controller = controller;
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        // ゲームループを16msごとに実行 (約60FPS)
        Timer timer = new Timer(16, e -> gameLoop());
        timer.start();
    }

    // ゲームのロジックを処理
    private void gameLoop() {
        controller.update(); // 入力に基づいて照準を移動
        repaint(); // 再描画
    }

    // 画面描画処理
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 背景を黒に塗りつぶす
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // 照準を描画
        aim.draw(g);
        
        // 的を描画
        for (Target target : targetManager.getTargets()) {
            target.draw(g);
        }
    }
}
