package gunGame;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        int screenWidth = 800;  // 画面の幅を800に設定
        int screenHeight = 600; // 画面の高さを600に設定

        JFrame frame = new JFrame("Gun Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Aim aim = new Aim(screenWidth / 2, screenHeight / 2, 20);
        TargetManager targetManager = new TargetManager(screenWidth, screenHeight);
        GameController gameController = new GameController(aim, targetManager);

        ShootingGamePanel panel = new ShootingGamePanel(aim, targetManager, gameController);
        frame.add(panel);
        frame.setSize(screenWidth, screenHeight);
        frame.setVisible(true);

        // キーリスナーの追加
        panel.addKeyListener(gameController);
        panel.setFocusable(true); // フォーカスを設定

        // ゲームループ
        while (true) {
            gameController.update();
            panel.repaint();
            try {
                Thread.sleep(16); // 約60FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
