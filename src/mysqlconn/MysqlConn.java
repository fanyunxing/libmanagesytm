package mysqlconn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author : fancici
 * @Date : Create in 2018 03 2018/3/26 11:41
 * @Description : 创建数据库连接
 * @Paramter :
 **/
public class MysqlConn   {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://test.wkclz.com:3306/forhxq?useUnicode=true&useSSL=false";
    String user = "fanyunxing";
    String password ="Wzry*1020171421";
    public MysqlConn () {

        try{
            Class.forName(driver);      //加载驱动
            Connection con = DriverManager.getConnection( url, user,password);
            if(!con.isClosed()){    //判断数据库是否链接成功
                System.out.println("已成功链接数据库！");
                con.close();
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("网络连接错误");
        }
    }
}