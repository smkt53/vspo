package game;


public class Main{

    static MainWindow mainWindow;
    public static void main(String[] args){
        System.out.println("started");
        //ウィンドウの作成、タイトルの設定
        mainWindow = new MainWindow("Vspo!!");
        //パネルの準備
        mainWindow.preparePanels();
        mainWindow.prepareComponents();

        //起動時の画面
        mainWindow.setFrontScreenAndFocus(Scene.TITLE);

        //ウィンドウの表示
        mainWindow.repaint();
        mainWindow.setVisible(true);
    }


    //画面の種類
    public enum Scene{
        GAME,
        TITLE,
        SETTING
    }

    //変数
    //0に設定すると他の操作が可能になる数値
    public static int statusNum = 0;
    /*
     * 0 : システム終了できる状態
     * 1 : 
     * 2 : 
     */

    public static int indexNum = 0;
    public static String sceneStr = "TITLE";


    //設定のできる変数
    //名前の設定
    public static String myname = "俺";
    //SE音量　未設定
    public static int seVolume = 100;
    //BGM音量　未設定
    public static int bgmVolume = 100;
    //テキストスピード　1-10で設定可能
    public static int textSpeed = 6;
    //テキストサイズ　1-5で設定可能
    public static int textSize = 4;

}

/*
 * started at 2024/03/17
 */