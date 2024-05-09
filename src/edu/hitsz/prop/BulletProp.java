package edu.hitsz.prop;

import edu.hitsz.ShootStrategy.DividingShoot;
import edu.hitsz.ShootStrategy.ShootStrategy;
import edu.hitsz.aircraft.HeroAircraft;

public class BulletProp extends BaseProp {

    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void Active(HeroAircraft a) {
        System.out.println("FireSupply active!");
        ShootStrategy shootStrategy=new DividingShoot();
        a.setShootNum(3);
        a.SetShootStrategy(shootStrategy);
    }
}
