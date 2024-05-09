package edu.hitsz.aircraft;

import edu.hitsz.EnemyFactory.EnemyFactory;
import edu.hitsz.EnemyFactory.MobEnemyFactory;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {

    HeroAircraft instance;
    @BeforeEach
    void setUp() {
        System.out.println("**---Begin---**");
        instance=HeroAircraft.getInstance();
    }

    @AfterEach
    void tearDown() {
        System.out.println("**---End---**");
    }

    @DisplayName("Test getInstance method")

    @Test
    void getInstance() {
        System.out.println("Test getInstance");
        HeroAircraft a=HeroAircraft.getInstance();
        assertEquals(a,instance);
    }

    @DisplayName("Test decreaseHp method")

    @Test
    void decreaseHp() {
        System.out.println("Test decreaseHp");
        int hp=instance.getHp();
        instance.decreaseHp(30);
        assertEquals(Math.max(hp-30, 0),instance.getHp());
    }

    @DisplayName("Test crash method")
    @Test
    void crash() {
        System.out.println("Test crash");
        MobEnemy a=new MobEnemy(instance.getLocationX()+1,
                instance.getLocationY()+1,0,10,100);
        assertTrue(instance.crash(a));

    }

    @DisplayName("Test setLocation method")
    @Test
    void setLocation() {
        System.out.println("Test setLocation");
        instance.setLocation(2,2);
        assertEquals(instance.getLocationX(),2);
        assertEquals(instance.getLocationY(),2);
    }


}