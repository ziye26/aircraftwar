package edu.hitsz.aircraft;

import edu.hitsz.ShootStrategy.NotShoot;
import edu.hitsz.ShootStrategy.ShootStrategy;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.prop.BaseProp;

import java.util.LinkedList;
import java.util.List;

/**
 * 普通敌机
 * 不可射击
 *
 * @author hitsz
 */
public class MobEnemy extends BaseEnemy {

    public MobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.shootStrategy=new NotShoot();
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseProp> createProp() {
        return super.createProp();
    }

    @Override
    public List<BaseBullet> shoot() {
        return this.shootStrategy.shoot(this);
    }

}
