package game;


public class Main{

    static MainWindow mainWindow;
    public static void main(String[] args){
        System.out.println("started");
        mainWindow = new MainWindow("Vspo!!");
        mainWindow.preparePanels();
        mainWindow.prepareComponents();
        mainWindow.setFrontScreenAndFocus(Scene.TITLE);

        mainWindow.repaint();
        mainWindow.setVisible(true);

        }

    public enum Scene{
        GAME,
        TITLE,
        SETTING
    }

    public class Num{
        public static int statusNum = 0;
    }

    public static String str = "TITLE";
}

/*
 * started at 2024/03/17
 */