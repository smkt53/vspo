package game;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
        Workbook excel = WorkbookFactory.create(new File("./data/Scenario.xlsx"));
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
