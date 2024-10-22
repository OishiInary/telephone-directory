package gunGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class GameController implements KeyListener, MouseMotionListener, MouseListener {
    private Aim aim;
    private TargetManager targetManager;
    private ShootingGamePanel gamePanel;

    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public GameController(Aim aim, TargetManager targetManager) {
        this.aim = aim;
        this.targetManager = targetManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:  // スペースキーで射撃アクション
                shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 何もしない
    }

    // マウスを動かしたときの処理
    @Override
    public void mouseMoved(MouseEvent e) {
        aim.setPosition(e.getX(), e.getY()); // マウスの座標に照準を移動
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // マウスドラッグ時の処理（必要であれば追加）
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        shoot(); // マウスクリック時に射撃
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    // 照準を移動させる処理
    public void update() {
        int moveSpeed = 5;
        if (upPressed) aim.move(0, -moveSpeed);
        if (downPressed) aim.move(0, moveSpeed);
        if (leftPressed) aim.move(-moveSpeed, 0);
        if (rightPressed) aim.move(moveSpeed, 0);
    }

    private void shoot() {
        List<Target> targets = targetManager.getTargets(); // すべての的を取得
        for (Target target : targets) {
            if (target.getBounds().intersects(aim.getBounds())) {
                target.hit(); // 照準と的が重なっていたら的を撃つ

                // 的を撃った後に画面をフラッシュさせる
                gamePanel.flashScreen();
                break; // 一度に一つの的しか撃てないのでループを抜ける
            }
        }

        // 射撃音を再生する
        playShootSound();

        // 照準にアニメーションを再生する
        playShootAnimation();
    }

    // 射撃音を再生するメソッド
    private void playShootSound() {
        // 射撃音の再生処理 (別途音声ファイルの配置場所を指定)
    }

    // 照準に射撃時のアニメーションを再生するメソッド
    private void playShootAnimation() {
        // 照準を中心にアニメーションを再生する処理 (例: 照準が一瞬大きくなるなど)
    }
}

