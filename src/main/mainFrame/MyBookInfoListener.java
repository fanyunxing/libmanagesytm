package main.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * @Author : fancici
 * @Date : Create in 2018 03 2018/3/23 17:05
 * @Description : 借书还书--我的借阅 功能实现 能够查阅 当前借阅 和 历史借阅两个记录， 使用的是JRadioButton类；
 *                  成员变量单独空出来
 * @Paramter :
 **/
public class MyBookInfoListener extends JFrame implements ActionListener {

    protected JPanel secondPanel; // 第二层面板
    protected JScrollPane bookLibScrollPanel;   //存放借阅信息的面板

    //JTable 测试内容。
    protected JTable borrowInfoTable;   //显示借阅信息的表格
    Vector allBorrowInfoVector = new Vector();   //存放所有的行的内容向量

    private Container container;

    public void MyBookInfoListener() {

        //JTable 测试内容，可以删除
        Vector rowVector_1 = new Vector();  //存放第一行内容的向量

        container = this.getContentPane();  //主窗口
        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //JTable 测试内容，可以删除
        rowVector_1.add("Java程序设计");
        rowVector_1.add("耿祥义");
        rowVector_1.add("清华大学出版社");
        //存在bug 下面一栏会使系统崩溃
        //rowVector_1.add("09-09-08");
        //rowVector_1.add("09-12-08");
        rowVector_1.add("");
        rowVector_1.add("0");
        rowVector_1.add("0");
        allBorrowInfoVector.add(rowVector_1);
        rowVector_1 = new Vector();
        rowVector_1.add("C++从入门到放弃");
        rowVector_1.add("梵陨星");
        rowVector_1.add("华南理工大学出版社");
        //rowVector_1.add("18-07-08");
        //rowVector_1.add("18-10-08");
        rowVector_1.add("");
        rowVector_1.add("0");
        rowVector_1.add("0");
        allBorrowInfoVector.add(rowVector_1);
        Vector borrowHead = new Vector();
        borrowHead.add("书名");
        borrowHead.add("作者");
        borrowHead.add("出版");
        borrowHead.add("借阅日期");
        borrowHead.add("应还日期");
        borrowHead.add("归还日期");
        borrowHead.add("超期天数");
        borrowHead.add("罚款金额");

        //生成具有内容和表头的表格
        borrowInfoTable = new JTable( allBorrowInfoVector, borrowHead );      //以数组数据生成表格
        borrowInfoTable.setEnabled(false);  //设置表格是不可编辑的，只显示信息
        borrowInfoTable.setPreferredScrollableViewportSize( new Dimension(0,20));
        bookLibScrollPanel = new JScrollPane();
        bookLibScrollPanel.setViewportView(borrowInfoTable);    //放到滚动面板上
        //设置提醒信息
        bookLibScrollPanel.setBorder(BorderFactory.createTitledBorder("借阅信息"));
        add(BorderLayout.CENTER,bookLibScrollPanel);
        validate();

        //设置文本框提示信息
        secondPanel.setBorder(BorderFactory.createTitledBorder("借阅查询选项"));
        JRadioButton currBorrowButton = new JRadioButton("当前借阅");
        JRadioButton historyBorrowButton = new JRadioButton("历史借阅");
        secondPanel.add(currBorrowButton);
        secondPanel.add(historyBorrowButton);

        //注册事件监听程序，对ActionListener做出处理
        currBorrowButton.addActionListener(new currBorrowInfoListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("当前借阅需要补充数据");
            }
        });

        historyBorrowButton.addActionListener(new historyBorrowInfoListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("历史借阅需要补充数据");
            }
        });


        ButtonGroup buttonGroup_1 = new ButtonGroup();
        buttonGroup_1.add(currBorrowButton);
        buttonGroup_1.add(historyBorrowButton);
        this.add(BorderLayout.NORTH, secondPanel);
        this.setTitle("我的借阅");
        this.setSize(600, 450);
        this.setVisible(true);

        //创建我的查询列表

    }
        //菜单项窗口
        public void actionPerformed(ActionEvent e) {
        this.MyBookInfoListener();
    }

    class currBorrowInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("当前借阅需要补充数据");
        }
    }

    class historyBorrowInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("历史借阅需要补充数据");
        }
    }
}
