package main.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author : fancici
 * @Date : Create in 2018 03 2018/3/25 14:48
 * @Description :
 * @Paramter :
 **/

public class LoginInListener extends JDialog implements ActionListener{

    protected JPanel selectionLabel;    // 第二层面板
    JDialog dialog = new JDialog();
    Container container;
    public void LoginInListener(){

        container = this.getContentPane();
        container.setLayout( new GridLayout(2,3));
        JPanel selectionLabel = new JPanel();
        JLabel readerIdLabel = new JLabel("账号",JLabel.RIGHT);
        selectionLabel.add(readerIdLabel);
        JTextField readerFieldText = new JTextField(10);
        selectionLabel.add(readerFieldText);
        selectionLabel.add( new JLabel());
        selectionLabel.add( new JLabel("密码",JLabel.RIGHT));
        JPasswordField pswdText = new JPasswordField(10);
        selectionLabel.add(pswdText);
        JButton okButton = new JButton("确定");
        //为okbutton注册事件
        okButton.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AboutListener().setVisible(true);
            }
        });
        selectionLabel.add(okButton);
        this.add(selectionLabel);
        this.setTitle("我的借阅");
        this.setSize(600, 450);
        this.setVisible(true);
    }
    public void actionPerformed( ActionEvent Event ){
        this.LoginInListener();
    }
}