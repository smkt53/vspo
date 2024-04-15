package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameTextPanel extends JPanel implements MouseListener{
    private static final long serialVersionUID = 1L;

    private int panelAlpha = 0;
    private JLabel textLabel;

    //ゲームテキストパネルの設定
    GameTextPanel(){
        this.setBackground(new Color(0, 0, 0, 0));
        this.setOpaque(false);
        this.setLayout(null);
        this.addMouseListener(this);
    }

    public void prepareComponents(){
        textLabel = new JLabel();
        textLabel.setBounds(100, 100, 1620, 340);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(textLabel);
    }

    //アニメーションの設定、アルファ値を設定してテキストを貼るパネルをフェードインする。fadeIn.start()でアニメーションを開始 別クラスから実行する場合はMain.mainWindow.gameTextPanel.fadeIn.start()で実行
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
            if(panelAlpha < 10){
                System.out.println("stop timer");
                panelAlpha = 5;
                repaint();
                revalidate();
                fadeOut.stop();
            }
            panelAlpha -= 5;
            repaint();
            revalidate();
        }
    });



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
    public void mouseClicked(MouseEvent e){
        fadeIn.start();
        textLabel.setText(Data.text);

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