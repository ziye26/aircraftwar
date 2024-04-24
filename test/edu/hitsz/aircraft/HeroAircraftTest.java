package edu.hitsz.aircraft;

import edu.hitsz.EnemyFactory.EnemyFactory;
import edu.hitsz.EnemyFactory.MobEnemyFactory;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {

    HeroAircraft instance;
    @BeforeEach
    void setUp() {
        System.out.println("**--- Begin ---**");
        instance=HeroAircraft.getInstance();
    }

    @AfterEach
    void tearDown() {
        System.out.println("**---End---**");
    }

    @Test
    void decreaseHp() {
        System.out.println("Test decreaseHp");
        int hp=instance.getHp();
        instance.decreaseHp(30);
        assertEquals(hp-30,instance.getHp());
    }


    @Test
    void crash() {
        System.out.println("Test crash");
        MobEnemy a=new MobEnemy(instance.getLocationX(),
                instance.getLocationY(),0,10,100);
        assertTrue(instance.crash(a));

    }

    @Test
    void setLocation() {
        instance.setLocation(2,2);
        assertEquals(instance.getLocationX(),2);
        assertEquals(instance.getLocationY(),2);
    }


    @Test
    void vanish() {
        System.out.println("Test vanish");
        instance.vanish();
        assertTrue(instance.notValid());


    }

    @Test
    void shoot() {
        List<BaseBullet> l=instance.shoot();
        for(var a:l){
            assertInstanceOf(HeroBullet.class, a);
        }

    }
}