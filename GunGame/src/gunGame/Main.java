package gunGame;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shooting Game");
        Aim aim = new Aim(250, 250);
        TargetManager targetManager = new TargetManager();

        GameController controller = new GameController(aim, targetManager);
        ShootingGamePanel gamePanel = new ShootingGamePanel(aim, targetManager, controller);
        
        frame.add(gamePanel);
        frame.addKeyListener(controller); // キーイベントを受け取るようにする

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
