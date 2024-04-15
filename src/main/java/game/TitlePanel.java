package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TitlePanel extends JPanel implements MouseListener{

    private static final long serialVersionUID = 1L;
    
    JLabel textlabel1 = new JLabel();
    JLabel textlabel2 = new JLabel();
    JLabel textlabel3 = new JLabel();
    JLabel textlabel4 = new JLabel();    

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();


    TitlePanel(){
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        g.drawString("START", 10, 10);
    }

    public void preapreComponents(){
        setBounds(0, 0, 1920, 1080);

        //テスト実装.
        //画像を取得してサイズを変更
        //背景画像
        ImageIcon test3 = new ImageIcon("./test3.png");
        Image res = test3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon tests3 = new ImageIcon(res);
        //アイコン画像
        ImageIcon emas = new ImageIcon("./emas.png");
        Image resemas = emas.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon emass = new ImageIcon(resemas);

        //背景画像を表示
        JLabel titleBackLabel = new JLabel(emass);
        titleBackLabel.setBounds(0, 0, 1920, 1080);
        this.add(titleBackLabel);

        //ラベル４枚の設定
        textlabel1.setOpaque(true);
        textlabel1.setBackground(Color.GRAY);
        textlabel1.setHorizontalAlignment(SwingConstants.CENTER);;
        textlabel1.setText("NEW GAME");
        Font ftl1 = textlabel1.getFont();
        textlabel1.setFont(new Font(ftl1.getName(), ftl1.getStyle(), 60));
        textlabel1.setBounds(300, 250, 600, 80);
        label1.setIcon(tests3);
        label1.setBounds(300, 250, 600, 80);
        this.add(label1);
        this.add(textlabel1);

        textlabel2.setText("CONTINUE");
        textlabel2.setOpaque(true);
        textlabel2.setBackground(Color.GRAY);
        textlabel2.setHorizontalAlignment(SwingConstants.CENTER);
        Font ftl2 = textlabel2.getFont();
        textlabel2.setFont(new Font(ftl2.getName(), ftl2.getStyle(), 60));
        textlabel2.setBounds(300, 400, 600, 80);
        textlabel2.addMouseListener(this);
        label2.setIcon(tests3);
        label2.setBounds(300, 400, 600, 80);
        this.add(label2);
        this.add(textlabel2);
        
        textlabel3.setText("SETTING");
        textlabel3.setOpaque(true);
        textlabel3.setBackground(Color.GRAY);
        textlabel3.setHorizontalAlignment(SwingConstants.CENTER);
        Font ftl3 = textlabel3.getFont();
        textlabel3.setFont(new Font(ftl3.getName(), ftl3.getStyle(), 60));
        textlabel3.setBounds(300, 550, 600, 80);
        textlabel3.addMouseListener(this);
        label3.setIcon(tests3);
        label3.setBounds(300, 550, 600, 80);
        this.add(label3);
        this.add(textlabel3);

        textlabel4.setText("EXIT");
        textlabel4.setOpaque(true);
        textlabel4.setBackground(Color.GRAY);
        textlabel4.setHorizontalAlignment(SwingConstants.CENTER);
        Font ftl4 = textlabel4.getFont();
        textlabel4.setFont(new Font(ftl4.getName(), ftl4.getStyle(), 60));
        textlabel4.setBounds(300, 700, 600, 80);
        textlabel4.addMouseListener(this);
        label4.setIcon(tests3);
        label4.setBounds(300, 700, 600, 80);
        this.add(label4);
        this.add(textlabel4);
    }

    @Override
    //マウスクリック時の処理
    public void mouseClicked(MouseEvent e){
        if(e.getSource() == textlabel1){
            //一枚目のラベルをクリックした場合、セーブデータ画面を飛ばし、最初のゲーム画面に遷移
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.GAME);
        }

        if(e.getSource() == textlabel2){
            //二枚目のラベルをクリックした場合、セーブデータ画面に遷移（未実装）
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.GAME);
        }

        if(e.getSource() == textlabel3){
            //三枚目のラベルをクリックした場合、設定画面に遷移
            Main.str = "TITLE";
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.SETTING);
        }

        if(e.getSource() == textlabel4){
            //四枚目のラベルをクリックした場合、ゲームを終了
            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }
}
