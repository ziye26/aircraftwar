package edu.hitsz.EnemyFactory;

import edu.hitsz.aircraft.BaseEnemy;
import edu.hitsz.aircraft.ElitePlusEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class ElitePlusEnemyFactory implements EnemyFactory{
    @Override
    public BaseEnemy createEnemy() {
        return new ElitePlusEnemy( (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                5,
                8,
                30);
    }
}
