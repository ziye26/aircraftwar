package edu.hitsz.ShootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class LineShoot implements ShootStrategy{
    public LineShoot(){}
    @Override
    public List<BaseBullet> shoot(AbstractAircraft a) {
        List<BaseBullet> res = new LinkedList<>();
        int x = a.getLocationX();
        int y = a.getLocationY() + a.getDirection()*2;
        int speedX = 0;
        int speedY = a.getSpeedY() + a.getDirection()*5;
        BaseBullet bullet;
        for(int i=0; i<a.getShootNum(); i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(a instanceof HeroAircraft){
                bullet = new HeroBullet(x + (i*2 - a.getShootNum() + 1)*10, y, speedX, speedY, a.getPower());
            }
            else bullet=new EnemyBullet(x + (i*2 - a.getShootNum() + 1)*10, y, speedX, speedY, a.getPower());
            res.add(bullet);
        }
        return res;

    }
}
