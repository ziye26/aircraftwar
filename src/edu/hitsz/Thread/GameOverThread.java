package edu.hitsz.Thread;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GameOverThread extends MusicThread{
    public GameOverThread(String filename){
        super(filename);
    }

    @Override
    public void run() {
        MainMusicThread.Ifpaused=true;
        super.run();
        MainMusicThread.Ifpaused=false;
        synchronized (lock){
            lock.notifyAll();
        }

    }
}
