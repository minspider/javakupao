package com.zyy.swing;

import javax.swing.*;
import java.awt.*;

/**
 *  缓存加载界面:背景图片、进度条
 *  动态加载过程。（线程）
 */
public class WindowFrame extends JFrame implements Runnable{

    JLabel background;
    //进度条
    JProgressBar jdt;

    //创建一个线程并启动
    public void Start(){
        WindowFrame frame = new WindowFrame();
        Thread t = new Thread(frame);//t代表线程
        //启动线程
        t.start();
        dispose();
    }

    public WindowFrame() {
        background = new JLabel(new ImageIcon("Image/hbg.jpg"));
        this.add(BorderLayout.NORTH,background);//放在窗口上面

        jdt = new JProgressBar();
        jdt.setStringPainted(true);//加载以字符串形式呈现出来。0%
        jdt.setBackground(Color.ORANGE);
        this.add(BorderLayout.SOUTH,jdt);

        //大小 568 * 340
        this.setSize(568,340);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.setIconImage(new ImageIcon("Image/115.png").getImage());
        this.setVisible(true);
    }


    @Override
    public void run() {
        //启动线程后，线程具体执行的内容
        int [] values = {0,1,3,10,23,32,40,47,55,66,76,86,89,95,99,99,99,100};
        for(int i=0; i<values.length; i++){//循环遍历赋值
            jdt.setValue(values[i]);
            //线程休眠
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }//200毫秒
        }
        dispose();
        new GameFrame();
    }
}
