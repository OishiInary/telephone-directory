package gunGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TargetManager {
    private List<Target> targets;
    private int screenWidth;
    private int screenHeight;
    private Random random;

    public TargetManager(int screenWidth, int screenHeight) {
        this.targets = new ArrayList<>();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.random = new Random();

        // 初期的の生成
        for (int i = 0; i < 5; i++) {
            addRandomTarget();
        }
    }

    // ランダムな位置に的を生成するメソッド
    public void addRandomTarget() {
        int size = 30;

        // 画面の幅や高さが的のサイズより小さい場合は生成しない
        if (screenWidth <= size * 2 || screenHeight <= size * 2) {
            throw new IllegalArgumentException("画面サイズが的の生成に必要なスペースより小さいです。");
        }

        // 的が画面端に出現しないように位置を調整
        int x = random.nextInt(screenWidth - size * 2) + size;
        int y = random.nextInt(screenHeight - size * 2) + size;
        targets.add(new Target(x, y, size, size));
    }

    // すべての的を描画するメソッド
    public void drawTargets(Graphics g) {
        for (Target target : targets) {
            target.draw(g);
        }
    }

    public List<Target> getTargets() {
        return targets;
    }
}
