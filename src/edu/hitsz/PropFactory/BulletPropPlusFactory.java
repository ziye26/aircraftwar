package edu.hitsz.PropFactory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BulletPlusProp;

public class BulletPropPlusFactory implements PropFactory{
    public BulletPropPlusFactory(){

    }

    @Override
    public BaseProp CreateProp(int locationX, int locationY, int speedX, int speedY) {
        return new BulletPlusProp(locationX, locationY, speedX, speedY);
    }
}
