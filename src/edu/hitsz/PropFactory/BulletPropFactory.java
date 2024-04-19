package edu.hitsz.PropFactory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BulletProp;

public class BulletPropFactory implements PropFactory{

    @Override
    public BaseProp CreateProp(int locationX, int locationY, int speedX, int speedY) {
        return new BulletProp(locationX,locationY,speedX,speedY);
    }

    public BulletPropFactory() {
    }
}
