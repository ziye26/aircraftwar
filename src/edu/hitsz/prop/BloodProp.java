package edu.hitsz.prop;

import edu.hitsz.Thread.MusicThread;
import edu.hitsz.Thread.PropMusicThread;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.VideoController;

import static java.lang.Math.min;

public class BloodProp extends BaseProp {
    private int AddHp = 30;

    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }
    public int getAddHp(){
        return AddHp;
    }

    @Override
    public void Active(HeroAircraft heroAircraft) {
        heroAircraft.decreaseHp(-min(500-heroAircraft.getHp(),this.getAddHp()));
        MusicThread a=new PropMusicThread(VideoController.getGetSupplyVideo());
        a.start();
    }
}
