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
        mainWindow.setFrontScreenAndFocus(Scene.GAME);

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
    public static int statusNum = 0;
    public static int indexNum = 0;
    public static String str = "TITLE";

    //設定のできる変数
    //名前の設定
    public static String myname = "俺";
    //1-5で設定可能
    public static int textSize = 4;
}

/*
 * started at 2024/03/17
 */