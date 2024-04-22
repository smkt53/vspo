package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements MouseListener, KeyListener{
    private static final long serialVersionUID = 1L;

    public JLabel menuLabel;
    public JLabel backLabel;
    public JLabel charaLabel;

    //背景画像を取得してサイズを変更
    ImageIcon backImageBefore = new ImageIcon("./data/station.png");
    Image res = backImageBefore.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
    ImageIcon backImage = new ImageIcon(res);

    //メニューアイコン
    ImageIcon menuIcon = new ImageIcon("./data/menu.png");


    public GamePanel() {
        setLayout(null);
        addKeyListener(this);
        addMouseListener(this);
    }

    //コンポーネントの設定
    public void prepareComponents(){
        backLabel = new JLabel();
        backLabel.setBounds(0, 0, 1920, 1080);
        backLabel.setIcon(backImage);
        add(backLabel, Main.indexNum);

        menuLabel = new JLabel();
        menuLabel.setBounds(1820, 40, 50, 50);
        menuLabel.setOpaque(true);
        menuLabel.setBackground(new Color(0, 0, 0, 0));
        menuLabel.setIcon(menuIcon);
        add(menuLabel, Main.indexNum);
        menuLabel.addMouseListener(this);
        
        Main.mainWindow.gameTextPanel.setBounds(100, 700, 1720, 340);
        add(Main.mainWindow.gameTextPanel, Main.indexNum);

        add(Main.mainWindow.menuPanel, Main.indexNum);
        Main.mainWindow.menuPanel.setVisible(false);
    }

    //メニューアクションが発生したらメニューパネルを表示する, 最初は非表示で配置してある
    public void menuAction() {
        System.out.println("menuAction");
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.mainWindow.menuPanel.setVisible(!Main.mainWindow.menuPanel.isVisible());
        if(Main.mainWindow.menuPanel.isVisible()){
            Main.mainWindow.menuPanel.requestFocus();
        }
    }

    public void goNextScenario() {
        Data.rowNum++;
        try {
            if(Main.mainWindow.gameTextPanel.textAnimation.isRunning()){
                Main.mainWindow.gameTextPanel.textAnimation.stop();
                Main.mainWindow.gameTextPanel.textLabel.setText(Data.textBox);
            }else{
                Main.mainWindow.gameTextPanel.textNum = 0;
                Data.setExcel();
                Data.getTextBox();
                Main.mainWindow.gameTextPanel.textBaseBox = "";
                Main.mainWindow.gameTextPanel.textAnimation.start();
                Main.mainWindow.gameTextPanel.nameLable.setText(Data.nameBox);
            }
            //テキストボックスが空である
            if(Data.textBox == ""){
                //パネルが表示されている
                if(Main.mainWindow.gameTextPanel.textPanelFadeBoolean == true){
                    //パネルをフェードアウトさせる
                    Main.mainWindow.gameTextPanel.textLabel.setText("");
                    Main.mainWindow.gameTextPanel.repaint();
                    Main.mainWindow.gameTextPanel.textPanelFade();
                }
            //テキストボックスに文字が入っている
            }else{
                //パネルが表示されている
                if(Main.mainWindow.gameTextPanel.textPanelFadeBoolean == false){
                    //パネルをフェードインさせる
                    Main.mainWindow.gameTextPanel.textPanelFade();
                }
            }
            Main.mainWindow.gameTextPanel.repaint();
        } catch (Exception ex) {
            System.out.println("error at \"goNextScenario\"");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //ESCキーが押されたらメニューアクションを実行
            menuAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == menuLabel){
            //メニューアイコンがクリックされたらメニューアクションを実行
            menuAction();
        }else{
            goNextScenario();
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
    protected void paintComponent(Graphics g) {

    }
}