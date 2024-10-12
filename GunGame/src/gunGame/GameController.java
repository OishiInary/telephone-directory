package gunGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class GameController implements KeyListener {
    private Aim aim;
    private TargetManager targetManager;

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
                // スコア加算処理などをここに追加
                break; // 一度に一つの的しか撃てないのでループを抜ける
            }
        }

        // 射撃音を再生する
        playShootSound();

        // 照準にアニメーションを再生する (実装は別途追加)
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
