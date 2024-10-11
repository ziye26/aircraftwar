package edu.hitsz.application;

import edu.hitsz.EnemyFactory.BossFactory;
import edu.hitsz.EnemyFactory.EliteEnemyFactory;
import edu.hitsz.EnemyFactory.ElitePlusEnemyFactory;
import edu.hitsz.EnemyFactory.MobEnemyFactory;
import edu.hitsz.Thread.BossThread;
import edu.hitsz.Thread.MusicThread;
import edu.hitsz.aircraft.BaseEnemy;
import edu.hitsz.aircraft.Boss;

public class DifficultGame extends Game{
    private int ProbabilityOfElite=40;
    private int bossThreshold = 300;
    private int bossHp =150;
    private int pretime=0;
    private int prescore=0;
    private int elitePretime=0;
    public DifficultGame(){
        super();
        BACKGROUND=ImageManager.BACKGROUND_IMAGE_DIFFICULT;
    }
    protected void EnemyCreate(){
        //此处是为了防止若同一时间两颗子弹打掉敌机加20分跳过阈值，故采用差值
        if((score-prescore)>= bossThreshold &&!Boss.getExistence()){
            prescore=score;
            enemyFactory = new BossFactory();
            BaseEnemy boss=enemyFactory.createEnemy();
            boss.setHp(bossHp);
            enemyAircrafts.add(boss);
            MusicThread a=new BossThread(VideoController.getBossVideo());
            a.start();
        }
        if (enemyAircrafts.size() < enemyMaxNumber) {
            if ((time-elitePretime)>=6000&&((int)(Math.random()*100))%3!=0){
                elitePretime=time;
                enemyFactory=new ElitePlusEnemyFactory();
                enemyAircrafts.add(enemyFactory.createEnemy());
            }
            else if (((int)(Math.random()*100))<=ProbabilityOfElite) {
                enemyFactory= new EliteEnemyFactory();
                enemyAircrafts.add(enemyFactory.createEnemy());
            }
            else {
                enemyFactory=new MobEnemyFactory();
                enemyAircrafts.add(enemyFactory.createEnemy());
            }
        }

    }

    @Override
    protected void DifficultyUp() {
        if(time>20000&&(time-pretime)>12000){
            pretime=time;
            DurationDecrease();
            EnemyMaxNumUp();
            ProbabilityOfEliteUp();
            BossThresholdDecrease();
            BossHpUp();
            System.out.println("难度上升，最大敌机数加2,精英机概率"+(float)ProbabilityOfElite/100+",boss产生阈值降低"
            +",boss生命值上升30，现生命值为:"+bossHp+"，射击周期缩短,射击间隔："+cycleDuration+"ms");
        }
    }

    @Override
    protected void EnemyMaxNumUp() {
        enemyMaxNumber = enemyMaxNumber + 2;
    }

    @Override
    protected void BossHpUp() {
        bossHp+=30;
    }

    @Override
    protected void ProbabilityOfEliteUp() {
        ProbabilityOfElite=Math.min(ProbabilityOfElite+5,80);
    }

    @Override
    protected void BossThresholdDecrease() {
        bossThreshold =Math.max(200, bossThreshold -10);
    }

    @Override
    protected void DurationDecrease() {
        cycleDuration = Math.max(cycleDuration - 40, 300);
    }
}
