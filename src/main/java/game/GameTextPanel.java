package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameTextPanel extends JPanel implements MouseListener{
    private static final long serialVersionUID = 1L;

    public boolean textPanelFadeBoolean = false;
    public int panelAlpha = 0;
    public int textNum = 0;
    public String textBaseBox = "";
    public int textLength = 0;
    public JLabel textLabel;
    public JLabel nameLable;

    //ゲームテキストパネルの設定
    GameTextPanel(){
        this.setBackground(new Color(0, 0, 0, 0));
        this.setOpaque(false);
        this.setLayout(null);
        this.addMouseListener(this);
    }

    public void prepareComponents(){
        textLabel = new JLabel();
        textLabel.setBounds(100, -20, 1620, 340);
        textLabel.setFont(new Font("ＭＳ 明朝", Font.BOLD, Main.textSize * 10));
        textLabel.setForeground(Color.WHITE);
        add(textLabel);

        nameLable = new JLabel();
        nameLable.setBounds(125, -125, 1620, 340);
        nameLable.setFont(new Font("ＭＳ 明朝", Font.BOLD, Main.textSize * 10));
        nameLable.setForeground(Color.WHITE);
        add(nameLable);
    }


    //テキストを一文字ずつ表示するアニメーション テスト実行のために設定のloadラベルで実行
    Timer textAnimation = new Timer(300 - Main.textSpeed * 30, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(textNum < Data.textBox.length()){
                textBaseBox += Data.textBox.charAt(textNum);
                textLabel.setText(textBaseBox);
                repaint();
            }else{
                textAnimation.stop();
            }
            textNum++;
        }
    });

    //アニメーションの設定、アルファ値を設定してテキストを貼るパネルをフェードインする。
    Timer fadeIn = new Timer(0, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(panelAlpha > 200){
                panelAlpha = 210;
                repaint();
                fadeIn.stop();
            }
            panelAlpha += 5;
            repaint();
            revalidate();
        }
    });

    //fadeInと同様
    Timer fadeOut = new Timer(0, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(panelAlpha < 20){
                panelAlpha = 10;
                repaint();
                revalidate();
                fadeOut.stop();
            }
            panelAlpha -=10;
            repaint();
            revalidate();
        }
    });

    public void textPanelFade(){
        //trueの状態であれば可視状態でfalseであれば不可視状態、textPanelFadeを実行することで逆の状態にしてbooleanを反対にする
        if(textPanelFadeBoolean == false){
            fadeOut.stop();
            fadeIn.start();
            textPanelFadeBoolean = true;
        }else{
            fadeIn.stop();
            fadeOut.start();
            textPanelFadeBoolean = false;
        }
    }



    //パネルの描画
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(30, 30, 30, panelAlpha));
        g2.fillRoundRect(0, 0, 1720, 340, 300, 300);
        g2.setColor(new Color(220, 220, 220, panelAlpha));
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(100, 80, 1620, 80);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this){
            Main.mainWindow.gamePanel.goNextScenario();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}