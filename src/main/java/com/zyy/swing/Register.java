package com.zyy.swing;

import com.mysql.jdbc.JDBC4CallableStatement;
import com.mysql.jdbc.JDBC4ClientInfoProvider;
import com.mysql.jdbc.JDBC4Connection;
import com.mysql.jdbc.JDBC4MySQLConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.security.auth.login.Configuration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.security.PrivateKey;

public class Register extends JFrame {
    public static void main(String[] args) {
        new Register();
    }
    JLabel userLabel;
    JTextField userField;
    JLabel userLabel1;
    JPasswordField userField1;
    JButton register,cancel;
    public Register(){

        userLabel = new JLabel("新用户");
        userLabel.setFont(new Font("微软雅黑", Font.BOLD,18));
        userLabel1 = new JLabel("密  码");
        userLabel1.setFont(new Font("微软雅黑",Font.BOLD,18));

        userLabel.setBounds(20, 220, 100, 30);//x位置，y位置，所占显示空间的大小
        this.add(userLabel);//将用户名这三个字添加到登录界面上，以下同理
        userLabel1.setBounds(20, 280, 100, 30);
        this.add(userLabel1);

        userField = new JTextField();
        userField.setBounds(80, 220, 100, 30);
        //设置输入框凹陷效果
        userField.setBorder(BorderFactory.createLoweredBevelBorder());
        //设置输入框背景透明
        userField.setOpaque(false);
        this.add(userField);

        userField1 = new JPasswordField();
        userField1.setBounds(80, 280, 100, 30);
        userField1.setBorder(BorderFactory.createLoweredBevelBorder());
        userField1.setOpaque(false);
        this.add(userField1);

        register = new JButton("注册");
        register.setBounds(45,350,60,36);
        cancel = new JButton("取消");
        cancel.setBounds(135,350,60,36);
        this.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userField.getText();
                String passWord = userField1.getText();



                JOptionPane.showMessageDialog(null,"注册成功");
                new LoginFrame();
            }
        });
        this.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });





        RegisterPanel panel = new RegisterPanel();
        this.add(panel);

        //设置登录界面的基本属性
        this.setSize(900,530);
        this.setLocationRelativeTo(null);//位置居中
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(false);

        //设置窗体的Logo图标
        this.setIconImage(new ImageIcon("Image/115.png").getImage());//存储图片
        this.setVisible(true);
    }


    }

