package puzzle.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    public int[][] shuffle = new int[4][4];
    int x=0,y=0;
    /***
     * JFrame
     * */
    /**1.创建游戏界面*/
    public GameJFrame(){
        //1.游戏界面设计
        this.screen();
        //2.游戏菜单设计
        this.menu();
        //4.打乱图像顺序
        this.shuffle();
        //3.设置图像
        this.image();
        //使界面可见
        this.setVisible(true);
    }



    /**1.游戏界面设置*/
    public void screen(){
        //设置界面长宽
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图游戏1.0");
        //使界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认的居中设置
        this.setLayout(null);

        /***给整个窗体添加键盘监听*/
        /**addKeyListener表示给本界面添加监听器
         * this表示当事件触发后会执行本类中的对应代码*/
        this.addKeyListener(this);
    }

    /**2.游戏菜单设置*/
    public void menu(){
        //创建菜单对象
        JMenuBar menubar =  new JMenuBar();
        /**
         * JMenu
         * */
        //创建菜单栏选项
        JMenu function = new JMenu("功能");
        JMenu aboutUs = new JMenu("关于我们");
        //创建菜单条目
        JMenuItem replay = new JMenuItem("重新游戏");
        JMenuItem relogin = new JMenuItem("重新登录");
        JMenuItem close = new JMenuItem("关闭游戏");
        JMenuItem officialaccount = new JMenuItem("公众号");
        //将条目添加到菜单栏选项中
        function.add(replay);
        function.add(relogin);
        function.add(close);
        aboutUs.add(officialaccount);
        //给整个菜单栏设置选项
        menubar.add(function);
        menubar.add(aboutUs);
        //给整个界面设置菜单栏
        this.setJMenuBar(menubar);
    }
    /**3.游戏图片设置*/
    private void image() {
        this.getContentPane().removeAll();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个图片ImageIcon的对象
                //创建一个JLable的对象（管理容器）
                JLabel jlabel = new JLabel(new ImageIcon("D:\\Github\\Java-learning-recodes\\OOPAdvancedPro\\src\\puzzle\\ui\\image\\animal\\animal3\\" + shuffle[i][j] + ".jpg"));
                //指定图片位置
                jlabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jlabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                //this.add(jlabel);
                this.getContentPane().add(jlabel);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\Github\\Java-learning-recodes\\OOPAdvancedPro\\src\\puzzle\\ui\\image\\background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        this.getRootPane().repaint();
    }


    private void shuffle(){
        Random random = new Random();
        int[] temp = new int[16];
        int num = 0;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
        //打乱数组：遍历时生成 一个随机index 和 数组原本索引 进行元素互换，达到打乱的效果
        for (int i = 0; i < temp.length; i++) {
            int index = random.nextInt(temp.length);
            int tempe = temp[i];
            temp[i] = temp[index];
            temp[index] = tempe;
        }
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]==0){
                x = i/4;
                y = i%4;
            }
            shuffle[i / 4][i % 4] = temp[i];
        }
    }

    private void up(){
        if(x==3){
            System.out.print("Can't up");
            return;
        }
        shuffle[x][y] = shuffle[x+1][y];
        shuffle[x+1][y] = 0;
        x++;
        image();
    }

    private void down(){
        if(x==0){
            System.out.print("Can't down");
            return;
        }
        shuffle[x][y] = shuffle[x-1][y];
        shuffle[x-1][y] = 0;
        x--;
        image();
    }

    private void left(){
        if(y==3){
            System.out.print("Can't up");
            return;
        }
        shuffle[x][y] = shuffle[x][y+1];
        shuffle[x][y+1] = 0;
        y++;
        image();
    }

    private void right(){
        if(y==0){
            System.out.print("Can't up");
            return;
        }
        shuffle[x][y] = shuffle[x][y-1];
        shuffle[x][y-1] = 0;
        y--;
        image();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override//按压时
    public void keyPressed(KeyEvent e) {
        //System.out.print("正在按压");
    }

    @Override//松开时
    public void keyReleased(KeyEvent e) {
        //System.out.print("正在");
        int code = e.getKeyCode();
        if(code == 38){
            this.up();
        } else if (code == 40) {
            this.down();
        }else if (code == 37) {
            this.left();
        }else if (code == 39) {
            this.right();
        }
    }
}
