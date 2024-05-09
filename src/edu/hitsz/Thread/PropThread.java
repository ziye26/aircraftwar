package edu.hitsz.Thread;

import edu.hitsz.ShootStrategy.LineShoot;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BulletPlusProp;
import edu.hitsz.prop.BulletProp;

public class PropThread implements Runnable{
    private BaseProp prop;
    @Override
    public void run() {
        if(prop instanceof BulletPlusProp ||prop instanceof BulletProp){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            HeroAircraft.getInstance().setShootNum(1);
            HeroAircraft.getInstance().SetShootStrategy(new LineShoot());
        }

    }

    public  PropThread(BaseProp prop){
        this.prop=prop;
    }
}
