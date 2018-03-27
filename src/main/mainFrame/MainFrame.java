package main.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @Author : fancici
 * @Date : Create in 2018 03 2018/3/22 10:47
 * @Description : 开始写图书馆里系统的首页。系统采用的是C/S模式。时间紧迫，边学边写。参见Java程序设计使用教程P186
 * 管理系统设计的一部分
 * @Paramter : SimpleListener 监听器类 用来响应特殊的作用类
 **/
public class MainFrame extends JFrame {

    final static private JFrame mainframe = null;
    private Container container;

    public  MainFrame(){

        this.setTitle("欢迎使用图书管理系统");
        container = this.getContentPane();
        container.setLayout( new BorderLayout());
        JMenuBar menuBar = new JMenuBar();

        buildMainMenu(menuBar); //调用buildMainMenu成员方法
        this.setJMenuBar(menuBar);
        this.show(true);
        this.setSize(600,450);
    }

    protected void buildMainMenu(JMenuBar menuBar){
        //完成文件菜单的创建
        JMenu fileMenu = new JMenu("文件（F）");    //文件菜单的创建
        fileMenu.setMnemonic(java.awt.event.KeyEvent.VK_F);
        JMenuItem exitMenuItem = new JMenuItem("退出");
        exitMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_E);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        /*为事件注册，对Action Event事件做出处理*/
        ExitActionListener exitActionListener = new ExitActionListener();
        exitMenuItem.addActionListener( exitActionListener );
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        //完成馆藏检索菜单的创建
        JMenu libMenu = new JMenu("馆藏检索(R)");
        libMenu.setMnemonic(KeyEvent.VK_R);

        JMenuItem libeMenuItem = new JMenuItem("书目检索");
        libeMenuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, ActionEvent.CTRL_MASK));

        //为事件注册，BookInLibraryActionListener 为内部类
        libeMenuItem.addActionListener(  new BookRetrievalListener() );
        libMenu.add(libeMenuItem);
        menuBar.add(libMenu);

        //借书还书菜单的创建
        JMenu lendreturnMenu = new JMenu("借书还书(E)");
        lendreturnMenu.setMnemonic(java.awt.event.KeyEvent.VK_E);
        JMenuItem myBookMenuItem = new JMenuItem("我的借阅");
        JMenuItem lendMenuItem = new JMenuItem("借书");
        JMenuItem returnMenuItem = new JMenuItem("还书");

        myBookMenuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        myBookMenuItem.addActionListener( new MyBookInfoListener());    //跳到我的借阅页面

        lendMenuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        SimpleListener lendMenuItemListener = new SimpleListener();
        lendMenuItem.addActionListener(lendMenuItemListener);

        returnMenuItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        SimpleListener returnMenuItemListener = new SimpleListener();
        returnMenuItem.addActionListener( returnMenuItemListener );

        lendreturnMenu.add( myBookMenuItem );
        lendreturnMenu.add( lendMenuItem );
        lendreturnMenu.add( returnMenuItem );
        menuBar.add( lendreturnMenu );

        //完成系统维护菜单的创建
        JMenu sysmaintainMenu = new JMenu("系统维护(M)");
        sysmaintainMenu.setMnemonic(java.awt.event.KeyEvent.VK_M);
        JMenuItem bookMenuItem = new JMenuItem("图书维护");
        JMenuItem readerMenuItem = new JMenuItem("读者维护");
        JMenuItem librarianMenuItem = new JMenuItem("管理员维护");
        JMenuItem paraMenuItem = new JMenuItem("系统参数维护");

        SimpleListener bookMenuItemActionListener = new SimpleListener();
        bookMenuItem.addActionListener(bookMenuItemActionListener);

        SimpleListener readerMenuItemActionListener = new SimpleListener();
        readerMenuItem.addActionListener(readerMenuItemActionListener);

        SimpleListener librarianMenuItemActionListener = new SimpleListener();
        librarianMenuItem.addActionListener(librarianMenuItemActionListener);

        SimpleListener paraMenuItemActionListener = new SimpleListener();
        paraMenuItem.addActionListener(paraMenuItemActionListener);

        sysmaintainMenu.add(bookMenuItem);
        sysmaintainMenu.add(readerMenuItem);
        sysmaintainMenu.add(librarianMenuItem);
        sysmaintainMenu.add(paraMenuItem);
        menuBar.add(sysmaintainMenu);

        //完成注册菜单的创建
        JMenu registermenu = new JMenu("注册(R)");
        registermenu.setMnemonic(KeyEvent.VK_R);
        menuBar.add(registermenu);

        //完成登陆菜单的创建
        JMenu loginInMenu = new JMenu("登陆(L)");
        loginInMenu.setMnemonic(KeyEvent.VK_L);
        JMenuItem readerlogin = new JMenuItem("读者登陆");
        JMenuItem managerlogin = new JMenuItem("管理员登陆");
        LoginInListener demo = new LoginInListener();
        readerlogin.addActionListener( demo);
        loginInMenu.add(readerlogin);
        loginInMenu.add(managerlogin);
        menuBar.add(loginInMenu);

        //完成退出菜单的创建
        JMenu exitmenu = new JMenu("注销(Z)");
        exitmenu.setMnemonic(KeyEvent.VK_Z);
        menuBar.add(exitmenu);




        //完成帮助菜单的创建
        JMenu helpmenu = new JMenu("帮助(H)");
        libMenu.setMnemonic(java.awt.event.KeyEvent.VK_H);
        JMenuItem aboutMenuItem = new JMenuItem("关于");
        aboutMenuItem.setMnemonic(java.awt.event.KeyEvent.VK_A);

        AboutListener aboutListener = new AboutListener();
        aboutMenuItem.addActionListener( aboutListener );

        helpmenu.add(aboutMenuItem);
        menuBar.add(helpmenu);

    }

    class ExitActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    //所有界面功能预留接口
    class SimpleListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("我的借阅");
        }
    }
}
