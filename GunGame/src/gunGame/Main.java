package gunGame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gun Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        Aim aim = new Aim(400, 300); // 照準の初期位置を中央に設定
        TargetManager targetManager = new TargetManager();
        GameController gameController = new GameController(aim, targetManager);
        
        ShootingGamePanel gamePanel = new ShootingGamePanel(aim, targetManager, gameController);
        frame.add(gamePanel, BorderLayout.CENTER);
        
        frame.addKeyListener(gameController); // キーボード操作を登録
        
        frame.setVisible(true);
        
        // メインループ（ゲームの更新と描画を行う）
        while (true) {
            gameController.update(); // 照準の移動更新
            targetManager.update();  // 的の更新
            gamePanel.repaint();     // ゲームの描画
            try {
                Thread.sleep(16); // フレームレートを約60fpsに維持
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
