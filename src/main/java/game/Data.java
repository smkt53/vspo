package game;

public class Data {
    public static int textStatus = 1;
    public static String text = "Hello, World!";
    public static String[] textArray = text.split("");
    
    public static void setText(String text){
        Data.text = text;
        Data.textArray = text.split("");
    }
}
