package main.mainFrame;

import mysqlconn.MysqlConn;

//图书馆管理系统主类入口
public class Library {
    public static void main( String[] args){
        MainFrame myFrame = new MainFrame();
        myFrame.setVisible(true);
        new MysqlConn();
    }
}
