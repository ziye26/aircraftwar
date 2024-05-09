package edu.hitsz.Dao;

import edu.hitsz.swing.StartMenu;

import java.io.*;
import java.util.*;

public class PlayerDaoImpl implements PlayerDao {
    private final String filename_easy="src\\edu\\hitsz\\Dao\\data_easy.dat";
    private final String filename_normal="src\\edu\\hitsz\\Dao\\data_normal.dat";
    private final String filename_difficult="src\\edu\\hitsz\\Dao\\data_difficult.dat";
    private String[] filename={filename_easy,filename_normal,filename_difficult};
    @Override
    public List<Player> getAllPlayers() {
        LinkedList<Player> players = new LinkedList<>();
        File file = new File(filename[StartMenu.getDifficulty()]);

        if (!file.exists())
            return players;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    players.add((Player) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(players);
        return players;
    }


    @Override
    public void doAdd(Player player) {
        File file = new File(filename[StartMenu.getDifficulty()]);
        boolean append = file.exists() && file.length() > 0;
        try {
            if (!file.exists()) {
                file.createNewFile();
                append = false;
            }
            ObjectOutputStream oos = append ?
                    new AppendableObjectOutputStream(new FileOutputStream(file, true)) :
                    new ObjectOutputStream(new FileOutputStream(file));
            try (oos) {
                oos.writeObject(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doDelete(int rank) {
        rank--;
        List<Player> players=getAllPlayers();
        players.remove(rank);
        try {
            // 创建File对象
            File file = new File(filename[StartMenu.getDifficulty()]);

            // 删除文件
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Player player:players){
            doAdd(player);

        }
    }
}
