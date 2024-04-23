package edu.hitsz.aircraft;

import edu.hitsz.PropFactory.BloodPropFactory;
import edu.hitsz.PropFactory.BombPropFactory;
import edu.hitsz.PropFactory.BulletPropFactory;
import edu.hitsz.PropFactory.PropFactory;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.BaseProp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Boss extends BaseEnemy{
    private int shootNum = 20;
    private int power = 30;
    private int direction = 1;//和游戏机相反

    public Boss(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
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
        List<BaseProp> l =new LinkedList<>();
        PropFactory propFactory;
        for(int i=0;i<3;i++) {
            if (((int) (Math.random() * 101) % 2 == 0)) {
                if (((int) (Math.random() * 101) % 2 == 0)) {
                    //生成道具
                    propFactory = new BloodPropFactory();
                    l.add(propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                            0, 10));
                } else if (((int) (Math.random() * 101) % 2 == 0)) {
                    propFactory = new BombPropFactory();
                    l.add(propFactory.CreateProp(this.getLocationX()+i*5, this.getLocationY()+i*5,
                            0, 10));
                } else {
                    propFactory = new BulletPropFactory();
                    l.add(propFactory.CreateProp(this.getLocationX()+8*i, this.getLocationY()+8*i,
                            0, 10));

                }
            }
        }
        return l;

    }

    @Override
    public List<BaseBullet> shoot() {
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = this.getSpeedY() + direction*5;
        BaseBullet bullet;
        for (int i = 0; i < 20; i++) {
            double angle = 2 * Math.PI * i / 20; // 计算每颗子弹在环形轨道上的角度
            double radius=2;
            double offsetX = Math.cos(angle) * radius; // 计算子弹在x方向上的偏移量
            double offsetY = Math.sin(angle) * radius; // 计算子弹在y方向上的偏移量

            bullet = new EnemyBullet((int)(x + offsetX), (int)(y + offsetY),(int)(Math.cos(angle)*10)  , (int)(Math.sin(angle)*10), power);
            res.add(bullet);
        }

        return res;
    }

}
