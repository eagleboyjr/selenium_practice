package utilities.classes;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Todd on 11/16/2016.
 */
public class ExcelDataReadUtil {
    private static XSSFWorkbook workBook;
    private static XSSFSheet workSheet;

    public static void setExcelFile(String path, String sheetName)throws IOException{
        try{
            //Open Excel File
            FileInputStream excelFile = new FileInputStream(path);

            //Access Excel Data Sheet
            workBook = new XSSFWorkbook(excelFile);
            workSheet = workBook.getSheet(sheetName);

        }catch(Exception e){
            throw(e);
        }
    }

    public static String[][] getTestData() throws IOException {
        String[][] testData = null;

        int rowCount = workSheet.getLastRowNum();

        int columnCount = workSheet.getRow(0).getLastCellNum();

        testData = new String[rowCount][columnCount];

        try {

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = workSheet.getRow(i + 1).getCell(j);
                    testData[i][j] = cell.getStringCellValue();
                }
            }
        }catch (Exception e){
            throw(e);
        }
        workBook.close();
        return testData;
    }
}
