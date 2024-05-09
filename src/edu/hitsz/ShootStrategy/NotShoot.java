package edu.hitsz.ShootStrategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.BaseBullet;

import java.util.LinkedList;
import java.util.List;

public class NotShoot implements ShootStrategy{

    @Override
    public List<BaseBullet> shoot(AbstractAircraft a) {
        return new LinkedList<>();
    }
}
