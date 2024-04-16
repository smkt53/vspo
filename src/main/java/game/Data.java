package game;

public class Data {
    
    public static int textNum = 0;
    public static String textBox = "";
    public static String nameBox = "";

    public static void setText(){
        switch(textNum){
            case 0:
                Main.mainWindow.gameTextPanel.fadeIn.start();
                textBox = "桜が散っているが";
                break;
            case 1:
                textBox = "いつもと変わらない日常";
                break;
            case 2:
                Main.mainWindow.gameTextPanel.fadeOut.start();
                textBox = "";
                break;
            case 3:
                Main.mainWindow.gameTextPanel.fadeIn.start();
                nameBox = Main.myname;
                textBox = "はやくしろよー";
                break;
            case 4:
                textBox = "また遅刻ギリギリになるよ";
                break;            
            case 5:
                nameBox = "";
                textBox = "つなと駅で待ち合わせて学校に向かっている";
                break;
            case 6:
                nameBox = "つな";
                textBox = "ごめんごめん、昨日"+ Main.myname + "君が落ちたあとランクしてたら全然寝れなかったんだよね";
                break;
            case 7:
                textBox = "でも、間に合うから大丈夫でしょ？";
                break;
            case 8:
                nameBox = Main.myname;
                textBox = "あの後まだやってたのか、体力すごいな";
                break;
            case 9:
                textBox = "先生話してる時に寝るなよ～";
                break;
            case 10:
                nameBox = "";
                textBox = "バスを降りて学校に向かっている";
                break;
            case 11:
                nameBox = "???";
                textBox = "おはよー！";
                break;
            case 12:
                nameBox = "";
                textBox = "誰かが後ろから走ってくる";
                break;
            case 13:
                nameBox = "???";
                textBox = "おはよー、"+ Main.myname + "君！";
                break;
            case 14:
                nameBox = Main.myname;
                textBox = "誰かと思ったららむねか、おはよう！";
                break;
            case 15:
                textBox = "今日も元気そうだな";
                break;
            case 16:
                nameBox = "つな";
                textBox = "おはよ～";
            case 17:
                nameBox = "らむね";
                textBox = "今日のクラス発表、たのしみだね！";
                break;

            default:
                textBox = "error";
                break;
        }
        textNum++;
    }
}
