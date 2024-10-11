package edu.hitsz.application;

import edu.hitsz.EnemyFactory.BossFactory;
import edu.hitsz.EnemyFactory.EliteEnemyFactory;
import edu.hitsz.EnemyFactory.ElitePlusEnemyFactory;
import edu.hitsz.EnemyFactory.MobEnemyFactory;
import edu.hitsz.Thread.BossThread;
import edu.hitsz.Thread.MusicThread;
import edu.hitsz.aircraft.Boss;

import java.awt.image.BufferedImage;

public class EasyGame extends Game {
    public EasyGame(){
        super();
        BACKGROUND=ImageManager.BACKGROUND_IMAGE_EASY;
    }

    //简单模式不产生boss
    protected void EnemyCreate() {
        if (enemyAircrafts.size() < enemyMaxNumber) {
            if (time % 6000 == 0 && ((int) (Math.random() * 100)) % 3 != 0) {
                enemyFactory = new ElitePlusEnemyFactory();
                enemyAircrafts.add(enemyFactory.createEnemy());
            } else if (((int) (Math.random() * 100)) % 2 == 0) {
                enemyFactory = new EliteEnemyFactory();
                enemyAircrafts.add(enemyFactory.createEnemy());
            } else {
                enemyFactory = new MobEnemyFactory();
                enemyAircrafts.add(enemyFactory.createEnemy());
            }
        }
    }

    @Override
    protected void DifficultyUp() {
    }

    @Override
    protected void EnemyMaxNumUp() {
    }

    @Override
    protected void BossHpUp() {
    }

    @Override
    protected void ProbabilityOfEliteUp() {

    }

    @Override
    protected void BossThresholdDecrease() {

    }

    @Override
    protected void DurationDecrease() {

    }
}

