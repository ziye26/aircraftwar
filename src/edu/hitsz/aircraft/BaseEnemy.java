package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.prop.BaseProp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseEnemy extends AbstractAircraft{

    public BaseEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public List<BaseBullet> shoot() {
        return null;
    }

    public List<BaseProp> createProp(){return new LinkedList<BaseProp>();}
}
