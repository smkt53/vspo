package game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuPanel extends JPanel implements MouseListener{
    private static final long serialVersionUID = 1L;

    private int width = 620;
    private int height = 680;

    private JLabel settingLabel;
    private JLabel saveLabel;
    private JLabel loadLabel;
    private JLabel returnLabel;

    //メニューパネルの設定
    MenuPanel(){
        this.setLayout(null);
        this.setBounds(650, 200, width, height);
        this.setOpaque(true);
        this.setBackground(new Color(30, 30, 30, 0));

        //4つのラベルを設定
        settingLabel = new JLabel("SETTING");
        settingLabel.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 50));
        settingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingLabel.setBounds(100, 67, 420, 93);

        add(settingLabel);

        saveLabel = new JLabel("SAVE");
        saveLabel.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 50));
        saveLabel.setHorizontalAlignment(SwingConstants.CENTER);
        saveLabel.setBounds(100, 218, 420, 93);
        add(saveLabel);

        loadLabel = new JLabel("LOAD");
        loadLabel.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 50));
        loadLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadLabel.setBounds(100, 369, 420, 93);
        add(loadLabel);

        returnLabel = new JLabel("RETURN");
        returnLabel.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 50));
        returnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        returnLabel.setBounds(100, 520, 420, 93);
        add(returnLabel);

        settingLabel.addMouseListener(this);
        saveLabel.addMouseListener(this);
        loadLabel.addMouseListener(this);
        returnLabel.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(30, 30, 30, 230));
        g.fillRoundRect(0, 0, width, height, 30, 30);

        g.setColor(new Color(120, 170, 220));
        g.fillRoundRect(100, 67, 420, 93, 30, 30);
        g.fillRoundRect(100, 218, 420, 93, 30, 30);
        g.fillRoundRect(100, 369, 420, 93, 30, 30);
        g.fillRoundRect(100, 520, 420, 93, 30, 30);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == settingLabel){
            System.out.println("setting");
            Main.str = "GAME";
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.SETTING);
        }
        if(e.getSource() == saveLabel){
            System.out.println("save");
        }
        if(e.getSource() == loadLabel){
            System.out.println("load");
        }
        if(e.getSource() == returnLabel){
            System.out.println("return");
            Main.mainWindow.gamePanel.menuAction();
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
