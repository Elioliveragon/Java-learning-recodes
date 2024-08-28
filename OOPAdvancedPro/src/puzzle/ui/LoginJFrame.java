package puzzle.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    /**1.创建用户登录界面*/
    public LoginJFrame(){
        this.setSize(488,430);
        this.setTitle("登录");
        //使界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
}
