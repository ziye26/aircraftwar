package edu.hitsz.swing;

import edu.hitsz.Dao.Player;
import edu.hitsz.Dao.PlayerDao;
import edu.hitsz.Dao.PlayerDaoImpl;
import edu.hitsz.application.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlayerTable {
    private JTable scoreTable;
    private JScrollPane tableScrollPanel;
    private JButton deleteButton;
    private JLabel headerLabel;
    private JLabel DifficultyLable;
    private JPanel mainPanel;


    public PlayerTable() {
        String [] difficulty={"难度：简单","难度：普通","难度：困难"};
        DifficultyLable.setText(difficulty[StartMenu.getDifficulty()]);

        String[] columnName = {"名次","玩家名","得分","记录时间"};
        PlayerDao playerDao=new PlayerDaoImpl();
        List<Player> players=playerDao.getAllPlayers();
        String[][]tableData=new String[players.size()][4];
        for(int i=0;i< players.size();i++){
            tableData[i][0]=Integer.toString(i+1);
            tableData[i][1]=players.get(i).getName();
            tableData[i][2]=Integer.toString(players.get(i).getScore());
            tableData[i][3]=players.get(i).getTime();
        }

        //表格模型
        DefaultTableModel model = new DefaultTableModel(tableData, columnName){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };

        //JTable并不存储自己的数据，而是从表格模型那里获取它的数据
        scoreTable.setModel(model);
        tableScrollPanel.setViewportView(scoreTable);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = scoreTable.getSelectedRow();
                System.out.println(row);
                int result = JOptionPane.showConfirmDialog(deleteButton,
                        "是否确定中删除？");
                if (JOptionPane.YES_OPTION == result && row != -1) {
                    model.removeRow(row);
                    PlayerDao playerDao1=new PlayerDaoImpl();
                    playerDao1.doDelete(row+1);
                }
                Main.cardPanel.add(new PlayerTable().getMainPanel());
                Main.cardLayout.last(Main.cardPanel);
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aircraft War");
        frame.setContentPane(new PlayerTable().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
