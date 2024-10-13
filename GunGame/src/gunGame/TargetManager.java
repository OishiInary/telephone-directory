package gunGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TargetManager {
    private List<Target> targets = new ArrayList<>();
    private Random random = new Random();
    private static final int MAX_TARGETS = 3; // 最大ターゲット数

    // ターゲットを更新
    public void update() {
        // 寿命が切れたターゲットや撃たれたターゲットを削除
        Iterator<Target> iterator = targets.iterator();
        while (iterator.hasNext()) {
            Target target = iterator.next();
            if (!target.isVisible() || target.isExpired()) {
                iterator.remove(); // 寿命が切れたか、ヒットされたターゲットを削除
            }
        }

        // ターゲットの数が少ない場合、新たに生成
        if (targets.size() < MAX_TARGETS) {
            int x = random.nextInt(800);  // ウィンドウの幅に合わせたランダムなX位置
            int y = random.nextInt(600);  // ウィンドウの高さに合わせたランダムなY位置
            int size = 40 + random.nextInt(20); // ターゲットのサイズ
            targets.add(new Target(x, y, size));
        }
    }

    // すべてのターゲットを描画
    public void drawTargets(Graphics g) {
        for (Target target : targets) {
            target.draw(g);
        }
    }

    // すべての的を取得
    public List<Target> getTargets() {
        return targets;
    }
}
