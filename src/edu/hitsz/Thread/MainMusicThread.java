package edu.hitsz.Thread;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.DataLine.Info;

import java.io.InputStream;

public class MainMusicThread extends MusicThread{
    public MainMusicThread(String Filename){
        super(Filename);
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
        try {
            int numBytesRead = 0;
            while (ifOpen) {
                numBytesRead = source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1 ) {
                    dataLine.write(buffer, 0, numBytesRead);
                } else {
                    source.reset(); // 重置输入流的位置
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        dataLine.drain();
        dataLine.close();
    }
}
