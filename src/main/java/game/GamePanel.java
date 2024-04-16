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
    ImageIcon backImageBefore = new ImageIcon("./station.png");
    Image res = backImageBefore.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
    ImageIcon backImage = new ImageIcon(res);

    //メニューアイコン
    ImageIcon menuIcon = new ImageIcon("./menu.png");


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
            Data.setText();
            Main.mainWindow.gameTextPanel.textLabel.setText(Data.textBox);
            Main.mainWindow.gameTextPanel.nameLable.setText(Data.nameBox);
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