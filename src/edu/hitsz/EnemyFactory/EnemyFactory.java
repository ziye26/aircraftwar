package edu.hitsz.EnemyFactory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BaseEnemy;

public interface EnemyFactory{
    public abstract BaseEnemy createEnemy();
}
