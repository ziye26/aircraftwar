package edu.hitsz.EnemyFactory;

import edu.hitsz.aircraft.BaseEnemy;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class BossFactory implements EnemyFactory{

    @Override
    public BaseEnemy createEnemy() {
        return new Boss((int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                2,
                0,
                180);
    }
    public BossFactory(){}
}
