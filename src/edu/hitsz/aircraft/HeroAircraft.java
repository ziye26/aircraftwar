package edu.hitsz.aircraft;

import edu.hitsz.ShootStrategy.LineShoot;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import org.apache.commons.lang3.ObjectUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 英雄飞机，游戏玩家操控
 * @author hitsz
 */
public class HeroAircraft extends AbstractAircraft {
    private static HeroAircraft instance = null;

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */

    /**
     * 子弹伤害
     */

    /**
     * * 子弹射击方向 (向上发射：1，向下发射：-1)
     */

    /**
     * @param locationX 英雄机位置x坐标
     * @param locationY 英雄机位置y坐标
     * @param speedX 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param speedY 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param hp    初始生命值
     */
    private HeroAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.shootNum=1;
        this.direction=-1;
        this.power=30;
        this.shootStrategy=new LineShoot();
    }

    @Override
    public void forward() {
        // 英雄机由鼠标控制，不通过forward函数移动
    }

    public static synchronized HeroAircraft getInstance(){
        if(instance==null){
            instance=new HeroAircraft(Main.WINDOW_WIDTH / 2,
                    Main.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight() ,
                    0, 0, 500);
        }
        return instance;
    }
    @Override
    /**
     * 通过射击产生子弹
     * @return 射击出的子弹List
     */
    public List<BaseBullet> shoot() {

        return this.shootStrategy.shoot(this);
    }

}
