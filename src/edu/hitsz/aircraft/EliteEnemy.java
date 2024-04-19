package edu.hitsz.aircraft;

import edu.hitsz.PropFactory.BloodPropFactory;
import edu.hitsz.PropFactory.BombPropFactory;
import edu.hitsz.PropFactory.BulletPropFactory;
import edu.hitsz.PropFactory.PropFactory;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.prop.BaseProp;
import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

public class EliteEnemy extends BaseEnemy{
    private int shootNum = 1;
    private int power = 30;
    private int direction = 1;//和游戏机相反

    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
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
    public BaseProp createProp() {
        PropFactory propFactory;
        if (((int) (Math.random() * 101) % 2 == 0)){
            if (((int) (Math.random() * 101) % 2 == 0)) {
                //生成道具
                propFactory=new BloodPropFactory();
                return propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY());
            } else if (((int) (Math.random() * 101) % 2 == 0)) {
                propFactory=new BombPropFactory();
                return propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY());
            }
            else {
                propFactory=new BulletPropFactory();
                return propFactory.CreateProp(this.getLocationX(), this.getLocationY(),
                        0, this.getSpeedY());
            }
        }
        else return null;
    }

    @Override
    public List<BaseBullet> shoot() {
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = this.getSpeedY() + direction*5;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            bullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, speedX, speedY, power);
            res.add(bullet);
        }
        return res;
    }
}
