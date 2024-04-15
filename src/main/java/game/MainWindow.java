package game;


import java.awt.CardLayout;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private static final long serialVersionUID = 1L;

    final static int WIDTH = 1920;
    final static int HEIGHT = 1080;
    
    //データを保持するクラス
    Data data;
    
    //各パネルを保持する変数
    TitlePanel titlePanel;
    SettingPanel settingPanel;
    GamePanel gamePanel;
    MenuPanel menuPanel;
    GameTextPanel gameTextPanel;

    static CardLayout layout = new CardLayout();

    //メインウィンドウの設定
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

    //各パネルを作成し、追加
    public void preparePanels(){
        data = new Data();
        titlePanel = new TitlePanel();
        settingPanel = new SettingPanel();
        gamePanel = new GamePanel();
        menuPanel = new MenuPanel();
        gameTextPanel = new GameTextPanel();
        this.add(titlePanel, "title");
        this.add(settingPanel, "setting");
        this.add(gamePanel, "game");
        this.pack();
    }

    //各パネルのコンポーネントを準備
    public void prepareComponents(){
        titlePanel.preapreComponents();
        gamePanel.prepareComponents();
        settingPanel.prepareComponents();
        gameTextPanel.prepareComponents();
    }

    //指定したシーンを表示し、フォーカスを設定
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