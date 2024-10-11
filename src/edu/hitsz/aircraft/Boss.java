package edu.hitsz.aircraft;

import edu.hitsz.PropFactory.*;
import edu.hitsz.ShootStrategy.CircleShoot;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.BaseProp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Boss extends BaseEnemy{


    //和游戏机相反
    private static int flag=0;//判断是否存在boss

    public Boss(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.shootNum=20;
        this.direction=1;
        this.shootStrategy=new CircleShoot();
        flag=1;
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
    public void vanish() {
        super.vanish();
        flag=0;


    }

    public static boolean getExistence(){
        return flag==1;
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
                            0, 5+2*i));
                } else if (((int) (Math.random() * 101) % 2 == 0)) {
                    propFactory = new BombPropFactory();
                    l.add(propFactory.CreateProp(this.getLocationX()+i*5, this.getLocationY()+i*5,
                            0, 5+2*i));
                } else if (((int) (Math.random() * 101) % 2 == 0)){
                    propFactory = new BulletPropFactory();
                    l.add(propFactory.CreateProp(this.getLocationX()+8*i, this.getLocationY()+8*i,
                            0, 5+2*i));
                }
                else{
                    propFactory = new BulletPropPlusFactory();
                    l.add(propFactory.CreateProp(this.getLocationX()+8*i, this.getLocationY()+8*i,
                            0, 5+2*i));
                }
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

    }
}
