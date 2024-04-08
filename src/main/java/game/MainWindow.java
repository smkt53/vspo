package game;


import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private static final long serialVersionUID = 1L;

    final static int WIDTH = 1920;
    final static int HEIGHT = 1080;

    TitlePanel titlePanel;
    SettingPanel settingPanel;
    GamePanel gamePanel;

    static CardLayout layout = new CardLayout();

    MainWindow(String title){
        setLayout(layout);
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        ImageIcon icon = new ImageIcon("icon.png");
        setIconImage(icon.getImage());
        setUndecorated(true);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
        setMinimumSize(new Dimension(1920, 1080));
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void preparePanels(){
        titlePanel = new TitlePanel();
        settingPanel = new SettingPanel();
        gamePanel = new GamePanel();
        this.add(titlePanel, "title");
        this.add(settingPanel, "setting");
        this.add(gamePanel, "game");
        this.pack();
    }

    public void prepareComponents(){
        titlePanel.preaprePanels();
        gamePanel.prepareComponents();
        settingPanel.prepareComponents();
    }

    public void setFrontScreenAndFocus(Main.Scene scene){
        switch(scene){
            case TITLE:
                layout.show(this.getContentPane(), "title");
                titlePanel.requestFocusInWindow();
                break;
            case GAME:
                layout.show(this.getContentPane(), "game");
                gamePanel.requestFocusInWindow();
                break;
            case SETTING:
                layout.show(this.getContentPane(), "setting");
                settingPanel.requestFocusInWindow();
                break;
        }
    }
}