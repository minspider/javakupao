package com.zyy.swing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.zyy.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * 这是我登录页面
 * 登录界面：用户名输入框  密码输入框  登录取消按钮 功能
 *
 * 功能模块：
 * 1、登录界面
 * 用户名（输入框，明文） 密码（输入框，密文） 登录、取消按钮
 * 2、菜单选择界面
 * 开始游戏按钮（图片按钮） 帮助按钮 退出按钮
 * 3、缓冲加载界面
 * 自动加载进度条，加载完毕之后，跳转到下一界面
 * 4、游戏主界面
 * 移动的背景图片、动态的玩家、五种障碍物持续出现、玩家和障碍物的碰撞、
 * 暂停、继续功能、玩家的移动功能
 * 5、结束界面
 * 获取玩家的得分、跑酷距离。继续游戏、返回主菜单的功能。
 */
public class LoginFrame extends JFrame {

    //用户名变量（文本）
    JLabel userLabel;
    //用户名输入框（文本输入框）
    JTextField userField;
    //密码变量（文本）
    JLabel userLabel2;
    //密码输入框（文本输入框）
    JPasswordField userField2;
    //登录按钮、取消按钮（按钮）
    JButton Login,register,Cancel;
    //注册按钮


    public LoginFrame() {//直接 alt / （无参构造）
        userLabel = new JLabel("用户名");
        //设置字体
        userLabel.setFont(new Font("微软雅黑", Font.BOLD,18));
        userLabel2 = new JLabel("密  码");
        userLabel2.setFont(new Font("微软雅黑",Font.BOLD,18));

        //布局方式：绝对布局
        userLabel.setBounds(20, 220, 100, 30);//x位置，y位置，所占显示空间的大小
        this.add(userLabel);//将用户名这三个字添加到登录界面上，以下同理
        userLabel2.setBounds(20, 280, 100, 30);
        this.add(userLabel2);

        //用户名输入框
        userField = new JTextField();
        userField.setBounds(80, 220, 100, 30);
        //设置输入框凹陷效果
        userField.setBorder(BorderFactory.createLoweredBevelBorder());
        //设置输入框背景透明
        userField.setOpaque(false);
        this.add(userField);

        userField2 = new JPasswordField();
        userField2.setBounds(80, 280, 100, 30);
        userField2.setBorder(BorderFactory.createLoweredBevelBorder());
        userField2.setOpaque(false);
        this.add(userField2);


        register = new JButton("注册");
        register.setBounds(45,350,60,36);
        this.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Register();
            }
        });



//登录按钮
        Login = new JButton("登录");
        Login.setBounds(135,350,60,36);
        //Login.setBackground(new Color(44,22,44));//背景色
        //Login.setForeground(Color.BLUE);//前景色
        //绑定登录按钮的事件监听
        Login.addActionListener(new ActionListener() {//ActionListener alt /

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("点击登录按钮");
                //获取用户名输入框的内容
                String userName = userField.getText();
                String passWord = userField2.getText();//横杠原因：方法太老了，不推荐用
                String s = HttpClientUtil.doGet("http://localhost:8080/test/user/name", "");
                Gson gson = new Gson();
                Map map = gson.fromJson(s,Map.class);
                System.out.println("****************"+map);
                if(userName.equals(map.get("name")) && map.get("pwd").equals(passWord)){
                    //登录成功
                    JOptionPane.showMessageDialog(null, "欢迎"+userName+"来到天天酷跑游戏");
                    //跳转到下一界面
                    new MainFrame();
                    //关闭当前界面
                    dispose();
                }else if("".equals(userName) || "".equals(passWord)){
                    //不能为空
                    JOptionPane.showMessageDialog(null, "用户名 / 密码不能为空，请重新输入！");
                }else{
                    JOptionPane.showMessageDialog(null, "用户名 / 密码输入错误，请重新输入！");
                }

            }
        });
        this.add(Login);

//取消按钮
        Cancel = new JButton("取消");
        Cancel.setBounds(225,350,60,36);
        this.add(Cancel);
        Cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
            }
        });



        //创建背景面板，并添加到窗体上去
        LoginPanel panel = new LoginPanel();
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

    public static void main(String[] args) {
        new LoginFrame();

    }

}
