package edu.hitsz.prop;

import edu.hitsz.Observer.Observer;
import edu.hitsz.Thread.MusicThread;
import edu.hitsz.Thread.PropMusicThread;
import edu.hitsz.aircraft.BaseEnemy;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.VideoController;

import java.util.LinkedList;
import java.util.List;

public class BombProp extends BaseProp {
    private List<Observer> Observers=new LinkedList<>();
    public void addObserver(Observer observer){
        Observers.add(observer);
    }

    public void removeObserver(Observer observer){
        Observers.remove(observer);
    }

    public int getObserversDestroy(){
        int a=0;
        for(Observer observer:Observers){
            if(observer instanceof BaseEnemy &&((BaseEnemy) observer).notValid()) a++;
        }
        return a;
    }

    public void notifyall(){
        for (Observer observer: Observers){
            observer.update();
        }
    }

    public BombProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void Active(HeroAircraft a) {
        System.out.println("BombSupply active!");
        notifyall();
        MusicThread propThread=new PropMusicThread(VideoController.getBombVideo());
        propThread.start();
    }
}
