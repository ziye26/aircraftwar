package edu.hitsz.PropFactory;

import edu.hitsz.prop.BaseProp;
import edu.hitsz.prop.BombProp;

public class BombPropFactory implements PropFactory{

    @Override
    public BaseProp CreateProp(int locationX, int locationY, int speedX, int speedY) {
        return new BombProp(locationX,locationY,speedX,speedY);
    }

    public BombPropFactory() {
    }
}
