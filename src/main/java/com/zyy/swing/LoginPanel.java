package com.zyy.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 登录面板
 */
public class LoginPanel extends JPanel {

    //背景图片变量
    Image background;//------ctr shift + o 导包
    public LoginPanel() {//-----alt / 回车 构造方法    在{后双击,显示作用域
        //读取图片文件，赋值给background变量
        try {//-----虽然不大可能，但也做好吃饭噎死的准备
            background = ImageIO.read(new File("Image/login.jpg"));//----read参数为File类型
        } catch (IOException e) {//-------捕获异常信息
            // 打印异常日志信息
            e.printStackTrace();
        }
    }
    //绘制方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制背景图片
        g.drawImage(background, 0, 0,900,530, null);//900,530为宽高
    }
}
