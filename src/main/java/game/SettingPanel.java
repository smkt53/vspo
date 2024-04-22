package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/* 
 * "設定できること"
 * 
 * 音量設定 バーを3つ配置して、SEの音量/BGMの音量を設定できるようにする
 * テキストのスピード バーを1つ配置して、テキストの表示スピードを設定できるようにする
 * 文字の大きさ バーを1つ配置して、文字の大きさを設定できるようにする
 * サンプルを下に配置して速さと大きさを確認できるようにする
 * 
*/

public class SettingPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
    private static final long serialVersionUID = 1L;

    public static int seVolumeX = Main.seVolume * 6 + 300;
    public static int bgmVolumeX = Main.bgmVolume * 6 + 300;
    public static int textSpeedX = Main.textSpeed * 60 + 1020;
    public static int textSizeX = Main.textSize * 120 + 1020;

    private String saveText = "";


    static JLabel returnButtonLabel;

    SettingPanel(){
        this.setLayout(null);
        this.setBackground(new Color(200, 200, 200, 255));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    public void prepareComponents(){
        returnButtonLabel = new JLabel();
        returnButtonLabel.setBackground(Color.WHITE);
        returnButtonLabel.setOpaque(true);
        returnButtonLabel.setBounds(1820, 40, 50, 50);
        returnButtonLabel.addMouseListener(this);
        this.add(returnButtonLabel);

        Main.mainWindow.sampleGameTextPanel.setBounds(100, 700, 1720, 340);
        Main.mainWindow.sampleGameTextPanel.setOpaque(true);
        Main.mainWindow.sampleGameTextPanel.fadeIn.start();
        Main.mainWindow.sampleGameTextPanel.panelAlpha = 255;
        Main.mainWindow.sampleGameTextPanel.removeMouseListener(Main.mainWindow.sampleGameTextPanel);
        this.add(Main.mainWindow.sampleGameTextPanel);
    }

    public void returnAction(){
        Data.textBox = saveText;
        System.out.println("return to " + Main.sceneStr + " screen");
        Main.statusNum = 0;
        if(Main.sceneStr == "GAME")
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.GAME);
        else if(Main.sceneStr == "TITLE")
            Main.mainWindow.setFrontScreenAndFocus(Main.Scene.TITLE);
        else
            System.out.println("error");
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            returnAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
    }

    @Override
    public void keyTyped(KeyEvent e){
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == returnButtonLabel){
            returnAction();
        }else{
            if(Main.mainWindow.sampleGameTextPanel.textAnimation.isRunning()){
                Main.mainWindow.sampleGameTextPanel.textAnimation.stop();
            }
            if(Data.textBox != "おはよう！今日も一日がんばろう！"){
                saveText = Data.textBox;
            }
            Data.textBox = "おはよう！今日も一日がんばろう！";
            Main.mainWindow.sampleGameTextPanel.textNum = 0;
            Main.mainWindow.sampleGameTextPanel.textBaseBox = "";
            Main.mainWindow.sampleGameTextPanel.textAnimation.start();
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

    @Override
    public void mouseDragged(MouseEvent e){
        if(e.getX() >= 300 && e.getX() <= 900 && e.getY() > 200 && e.getY() < 220){
            //SE音量の設定　0-100
            seVolumeX = e.getX();
            Main.seVolume = (seVolumeX - 300) / 6;
            repaint();
        }
        if(e.getX() >= 300 && e.getX() <= 900 && e.getY() > 400 && e.getY() < 420){
            //BGM音量の設定　0-100
            bgmVolumeX = e.getX();
            Main.bgmVolume = (bgmVolumeX - 300) / 6;
            repaint();
        }
        if(e.getX() > 1020 && e.getX() < 1620 && e.getY() > 200 && e.getY() < 220){
            //テキストスピードの設定 1-10
            textSpeedX = e.getX();
            Main.textSpeed = (textSpeedX - 1020) / 60 + 1;
            Main.mainWindow.gameTextPanel.textAnimation.setDelay(300 - Main.textSpeed * 30);
            Main.mainWindow.sampleGameTextPanel.textAnimation.setDelay(300 - Main.textSpeed * 30);
            repaint();
        }
        if(e.getX() > 1020 && e.getX() < 1620 && e.getY() > 400 && e.getY() < 420){
            //テキストサイズの設定 2-5
            textSizeX = e.getX();
            Main.textSize = (textSizeX - 1020) / 150 + 2;
            Main.mainWindow.gameTextPanel.textLabel.setFont(new Font("ＭＳ 明朝", Font.BOLD, Main.textSize * 10));
            Main.mainWindow.sampleGameTextPanel.textLabel.setFont(new Font("ＭＳ 明朝", Font.BOLD, Main.textSize * 10));
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(30, 30, 30, 230));
        g.fillRoundRect(300, 200, 600, 20, 5, 10); //300 1320 300 = 1920 = 300 600 120 600 300
        g.fillRoundRect(300, 400, 600, 20, 5, 10);
        g.fillRoundRect(1020, 200, 600, 20, 5, 10);
        g.fillRoundRect(1020, 400, 600, 20, 5, 10);

        Font font = new Font("ＭＳ ゴシック", Font.PLAIN, 50);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString("SE音量 : "+ Main.seVolume, 320, 180);
        g.drawString("BGM音量 : "+ Main.bgmVolume, 320, 380);
        g.drawString("文字スピード : "+ Main.textSpeed, 1040, 180);
        g.drawString("文字サイズ : "+ Main.textSize, 1040, 380);

        g.setColor(new Color(220, 220, 220));
        g.fillOval(seVolumeX - 15, 195, 30, 30);
        g.fillOval(bgmVolumeX - 15, 395, 30, 30);
        g.fillOval(textSpeedX - 15, 195, 30, 30);
        g.fillOval(textSizeX - 15, 395, 30, 30);
    }
}


