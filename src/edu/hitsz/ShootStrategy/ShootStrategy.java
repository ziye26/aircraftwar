package edu.hitsz.ShootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.List;

public interface ShootStrategy {
    public abstract List<BaseBullet> shoot(AbstractAircraft a);
}
