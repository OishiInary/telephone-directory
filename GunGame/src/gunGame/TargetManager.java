package gunGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class TargetManager {
    private List<Target> targets; // 的のリスト
    private final int MAX_TARGETS = 3; // 最大的数
    private final int TARGET_LIFETIME = 10000; // 的の生存時間（ミリ秒）
    private final int BLINK_TIME = 2000; // 点滅する時間（ミリ秒）
    private Timer timer; // 的を生成するためのタイマー

    public TargetManager() {
        targets = new ArrayList<>(); // 的のリストを初期化
        startTargetGeneration(); // 的の生成を開始
    }

    // タイマーを使って的を生成する
    private void startTargetGeneration() {
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (targets.size() < MAX_TARGETS) {
                    addRandomTarget();
                }
            }
        });
        timer.start();
    }

    // ランダムな位置に的を追加
    private void addRandomTarget() {
        int x = (int) (Math.random() * (500 - 30)); // ウィンドウ幅に応じたランダムなX座標
        int y = (int) (Math.random() * (500 - 30)); // ウィンドウ高さに応じたランダムなY座標
        Target newTarget = new Target(x, y);
        targets.add(newTarget);
        
        // 的のライフタイム管理
        new Timer(TARGET_LIFETIME - BLINK_TIME, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Timer(BLINK_TIME / 200, new ActionListener() { // 点滅処理
                    private boolean isVisible = true;
                    private int blinkCount = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (blinkCount < (BLINK_TIME / 200)) {
                            newTarget.setVisible(isVisible); // 点滅
                            isVisible = !isVisible; // 表示状態を切り替え
                            blinkCount++;
                        } else {
                            targets.remove(newTarget); // 消滅
                            ((Timer) e.getSource()).stop(); // タイマー停止
                        }
                    }
                }).start();
                ((Timer) e.getSource()).stop(); // 元のタイマー停止
            }
        }).start();
    }

    public List<Target> getTargets() {
        return targets; // 的のリストを返す
    }

    public void addTarget(Target target) {
        targets.add(target); // 新しい的をリストに追加
    }

    public void removeTarget(Target target) {
        targets.remove(target); // 指定した的をリストから削除
    }
}
