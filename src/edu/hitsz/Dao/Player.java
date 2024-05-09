package edu.hitsz.Dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Player implements Comparable<Player>, Serializable {
    private int score;
    private String name;
    private String time;

    public int getScore() {
        return score;
    }

    public Player(int score, String name){
        this.score=score;
        this.name=name;
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
        time=now.format(formatter);
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name+","+score+","+time;
    }

    //重写compareTo 使得后续可以直接进行类的比较
    @Override
    public int compareTo(Player player) {

        return -Integer.compare(this.score, player.score);
    }




}
