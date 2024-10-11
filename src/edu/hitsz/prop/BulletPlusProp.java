package edu.hitsz.prop;

import edu.hitsz.ShootStrategy.CircleShoot;
import edu.hitsz.ShootStrategy.ShootStrategy;
import edu.hitsz.Thread.MusicThread;
import edu.hitsz.Thread.PropMusicThread;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.VideoController;

public class BulletPlusProp extends BaseProp{

    public BulletPlusProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    @Override
    public void Active(HeroAircraft a){
        ShootStrategy shootStrategy=new CircleShoot();
        a.setShootNum(20);
        a.SetShootStrategy(shootStrategy);
        MusicThread b=new PropMusicThread(VideoController.getGetSupplyVideo());
        b.start();
    }
}
