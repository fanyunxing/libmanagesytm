package main.mainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author : fancici
 * @Date : Create in 2018 03 2018/3/26 6:46
 * @Description : 实现版本说功能
 * @Paramter :
 **/
public class AboutListener extends JDialog implements ActionListener {

    protected JPanel secondPanel; // 第二层面板
    protected JScrollPane aboutScrollPanel;   //存放借阅信息的面板
    protected Container container;

    public void AboutListener(){

        container = this.getContentPane();
        secondPanel = new JPanel();
        secondPanel.setLayout( new BorderLayout());
        JLabel aboutcontent = new JLabel("<html><body>系统版本 1.0<br />由梵陨星负责开发维护，如有任何疑问，请联系" +
                "<br />微信 梵陨星</body></html> ",
                SwingConstants.CENTER );
        container.add( aboutcontent );
        setSize(600,450);
        this.show(true);

    }

    public void actionPerformed(ActionEvent e){
        this.AboutListener();
    }
}
