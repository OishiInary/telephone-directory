package gunGame;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ShootingGamePanel extends JPanel {
    private Aim aim;
    private TargetManager targetManager;
    private GameController gameController;

    public ShootingGamePanel(Aim aim, TargetManager targetManager, GameController gameController) {
        this.aim = aim;
        this.targetManager = targetManager;
        this.gameController = gameController;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        aim.draw(g); // 照準の描画
        targetManager.drawTargets(g); // 的の描画
    }
}
