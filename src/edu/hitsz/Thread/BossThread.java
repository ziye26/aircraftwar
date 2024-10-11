package edu.hitsz.Thread;

import edu.hitsz.aircraft.Boss;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.IOException;
import java.io.InputStream;

public class BossThread extends MusicThread{
    public static boolean Iffinished=false;

    public BossThread(String filename){
        super(filename);
    }

    @Override
    public void play(InputStream source) {
        int size = (int) (audioFormat.getFrameSize() * audioFormat.getSampleRate());
        byte[] buffer = new byte[size];
        SourceDataLine dataLine = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            dataLine = (SourceDataLine) AudioSystem.getLine(info);
            dataLine.open(audioFormat, size);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        dataLine.start();
        synchronized (lock){
            try {
                int numBytesRead = 0;
                while (ifOpen && Boss.getExistence() && !Iffinished) {
                    numBytesRead = source.read(buffer, 0, buffer.length);
                    if (numBytesRead != -1) {
                        dataLine.write(buffer, 0, numBytesRead);
                    } else {
                        source.reset(); // 重置输入流的位置
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //dataLine.drain();
        dataLine.close();
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
