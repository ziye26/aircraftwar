package edu.hitsz.PropFactory;

import edu.hitsz.prop.BaseProp;

public interface PropFactory {
    public abstract BaseProp CreateProp(int locationX, int locationY, int speedX, int speedY);
}
