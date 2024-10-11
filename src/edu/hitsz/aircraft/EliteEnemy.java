package edu.hitsz.aircraft;

import edu.hitsz.PropFactory.*;
import edu.hitsz.ShootStrategy.LineShoot;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.BaseProp;

import java.util.*;

public class EliteEnemy extends BaseEnemy{



    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.shootStrategy=new LineShoot();
        this.shootNum=1;
    }

    @Override
    public void forward(){
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseProp> createProp() {
        PropFactory propFactory;
        List<BaseProp> l =new LinkedList<>();
        if (((int) (Math.random() * 101) % 2 == 0)) {
            if (((int) (Math.random() * 101) % 2 == 0)) {
                //生成道具
                propFactory = new BloodPropFactory();
                l.add(propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY()));
            } else if (((int) (Math.random() * 101) % 2 == 0)) {
                propFactory = new BombPropFactory();
                l.add(propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY()));
            } else if (((int) (Math.random() * 101) % 2 == 0)) {
                propFactory = new BulletPropFactory();
                l.add(propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY()));
            }
            else{
                propFactory = new BulletPropPlusFactory();
                l.add(propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY()));
            }
        }
        return l;
    }

    @Override
    public List<BaseBullet> shoot() {
        return shootStrategy.shoot(this);
    }

    @Override
    public void update() {
        this.decreaseHp(this.getHp());
    }
}
