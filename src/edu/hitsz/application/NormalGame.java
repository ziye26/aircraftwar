package edu.hitsz.application;

import edu.hitsz.EnemyFactory.BossFactory;
import edu.hitsz.EnemyFactory.EliteEnemyFactory;
import edu.hitsz.EnemyFactory.ElitePlusEnemyFactory;
import edu.hitsz.EnemyFactory.MobEnemyFactory;
import edu.hitsz.Thread.BossThread;
import edu.hitsz.Thread.MusicThread;
import edu.hitsz.aircraft.BaseEnemy;
import edu.hitsz.aircraft.Boss;

public class NormalGame extends Game{
    private int ProbabilityOfElite=28;
    private int bossThreshold = 400;
    private int bossHp =120;
    private int pretime = 0;
    private int prescore = 0;
    public NormalGame(){
        super();
        BACKGROUND=ImageManager.BACKGROUND_IMAGE_NORMAL;
    }
    protected void EnemyCreate(){
        //此处是为了防止若同一时间两颗子弹打掉敌机加20分跳过阈值，故采用差值
        if((score-prescore)> bossThreshold &&!Boss.getExistence()){
            prescore=score;
            enemyFactory = new BossFactory();
            BaseEnemy boss=enemyFactory.createEnemy();
            boss.setHp(bossHp);
            enemyAircrafts.add(boss);
            MusicThread a=new BossThread(VideoController.getBossVideo());
            a.start();
        }
        if (enemyAircrafts.size() < enemyMaxNumber) {
            if (time%6000==0&&((int)(Math.random()*100))%3!=0){
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
            System.out.println("难度上升，最大敌机数加1,精英机概率"+(float)ProbabilityOfElite/100+",boss产生阈值降低"
                    +",boss生命值上升30，现生命值为:"+bossHp+"，敌机射速加快,射击间隔："+cycleDuration+"ms");
        }
    }

    @Override
    protected void EnemyMaxNumUp() {
        enemyMaxNumber = enemyMaxNumber + 1;
    }

    @Override
    protected void BossHpUp() {
        bossHp+=20;
    }

    @Override
    protected void ProbabilityOfEliteUp() {
        ProbabilityOfElite=Math.min(ProbabilityOfElite+5,60);
    }

    @Override
    protected void BossThresholdDecrease() {
        bossThreshold =Math.max(300, bossThreshold -10);
    }

    @Override
    protected void DurationDecrease() {
        cycleDuration = Math.max(cycleDuration - 40, 300);
    }
}
