package game;

import java.io.File;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.crypt.*;

public class Data  {
    
    public static int routeNum = 0;
    /*  0 : MainScenario
        1 : SubScenario
        2 : nazunaScenario
        3 : ramuneScenario
        4 : tsunaScenario
        5 : noahScenario
        6 : metoScenario
    */

    public static int rowNum = 2;
    public static int cellNum = 3;
    public static String textBox = "";
    public static String nameBox = "";
    public static Sheet MainScenario;
    public static Sheet SubScenario;
    public static Row row;
    public static Cell cell;

    public static void setExcel() throws Exception{
        String password = "password";
        POIFSFileSystem fs = new POIFSFileSystem(new File("./data/Scenario.xlsx"));
        EncryptionInfo info = new EncryptionInfo(fs);
        Decryptor d = Decryptor.getInstance(info);
        d.verifyPassword(password);
        Workbook excel = WorkbookFactory.create(d.getDataStream(fs));
        MainScenario = excel.getSheet("MainScenario");
        //SubScenario = excel.getSheet("SubScenario");
    }

    public static void getTextBox() throws Exception{
        if(routeNum == 0){
            row = MainScenario.getRow(rowNum);
        }
        if(routeNum == 1){
            row = SubScenario.getRow(rowNum);
        }
        cell = row.getCell(cellNum);
        nameBox = cell.getStringCellValue();
        row = MainScenario.getRow(rowNum);
        cell = row.getCell(cellNum + 1);
        textBox = cell.getStringCellValue();
    }        
}
