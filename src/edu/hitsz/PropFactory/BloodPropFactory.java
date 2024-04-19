package edu.hitsz.PropFactory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BloodProp;

public class BloodPropFactory implements PropFactory{

    @Override
    public BaseProp CreateProp(int locationX, int locationY, int speedX, int speedY) {
        return new BloodProp(locationX, locationY, speedX, speedY);
    }

    public BloodPropFactory() {
    }
}
