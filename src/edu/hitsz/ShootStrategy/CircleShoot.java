package edu.hitsz.ShootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class CircleShoot implements ShootStrategy{

    @Override
    public List<BaseBullet> shoot(AbstractAircraft a) {
        List<BaseBullet> res = new LinkedList<>();
        int x = a.getLocationX();
        int y = a.getLocationY() + a.getDirection()*2;
        int speedX = 0;
        int speedY = a.getSpeedY() + a.getDirection()*5;
        BaseBullet bullet = null;
        for (int i = 0; i < 20; i++) {
            double angle = 2 * Math.PI * i / 20; // 计算每颗子弹在环形轨道上的角度
            double radius=2;
            double offsetX = Math.cos(angle) * radius; // 计算子弹在x方向上的偏移量
            double offsetY = Math.sin(angle) * radius; // 计算子弹在y方向上的偏移量

            if(a instanceof HeroAircraft){
                bullet = new HeroBullet((int) (x + offsetX), (int) (y + offsetY), (int) (Math.cos(angle) * 10), (int) (Math.sin(angle) * 10), a.getPower());
            }
            else bullet=new EnemyBullet((int) (x + offsetX), (int) (y + offsetY), (int) (Math.cos(angle) * 10), (int) (Math.sin(angle) * 10), a.getPower());

            res.add(bullet);
        }

        return res;
    }
}
