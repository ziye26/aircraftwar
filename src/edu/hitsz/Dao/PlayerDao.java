package edu.hitsz.Dao;

import java.util.List;

public interface PlayerDao {
    public abstract List<Player> getAllPlayers();
    public abstract void doAdd(Player player) ;
    public abstract void doDelete(int rank);

}
