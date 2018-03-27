package main.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @Author : fancici
 * @Date : Create in 2018 03 2018/3/25 7:48
 * @Description : 馆藏检索——图书检索 功能界面
 * @Paramter :
 **/
public class BookRetrievalListener extends JFrame implements ActionListener {

    protected JLabel selectionLabel;
    protected JComboBox fieldComboBox;
    protected JPanel secondPanel;
    protected JButton retrievalButton;
    protected JTextField keywordText;
    private Container container;
    protected String fieldSelected;

    public void BookRetrievalListener() {

        container = this.getContentPane();
        selectionLabel = new JLabel("检索方式");

        String[] list ={"11","22","33","44","55"};
        fieldComboBox = new JComboBox(list);    //分类检索下拉列表

        //注册事件监听者FieldSelectedListener为内部类
        fieldComboBox.addItemListener(new FieldSelectedListener());

        keywordText = new JTextField("java", 20);  //显示关键字文本框
        retrievalButton = new JButton("检索");    //提交命令按钮
        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        keywordText.setSize(secondPanel.getWidth() / 2, secondPanel.getWidth());
        secondPanel.add(selectionLabel);
        secondPanel.add(fieldComboBox);
        secondPanel.add(keywordText);
        secondPanel.add(retrievalButton);
        this.add(secondPanel);
        // 添加后面的JList显示检索内容

        this.setTitle("书目检索");
        this.setSize(600, 450);
        this.setVisible(true);
    }

    class FieldSelectedListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                fieldSelected = (String) fieldComboBox.getSelectedItem();
            }
        }
    }

    public void actionPerformed(ActionEvent event) {
        BookRetrievalListener bookRetrievalListener = new BookRetrievalListener();
        bookRetrievalListener.BookRetrievalListener();
    }
}