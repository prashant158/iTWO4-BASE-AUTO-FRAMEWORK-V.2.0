package iTWO_Utilities;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.HashMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

    public static Workbook wb;
    public static Sheet sh;

    private String query;
    private String filePath;

    public ExcelUtil(String sheetName) {
        String filePath = System.getProperty("user.dir")+"/src/test/resources/iTWO_TestData/Data.xlsx";
                                                        /*/src/test/resources/iTWO_TestData/TestData.xlsx*/
        File testDataFile = new File(filePath);

        try {
            wb = WorkbookFactory.create(testDataFile);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sh = wb.getSheet(sheetName);
    }


    @SuppressWarnings("deprecation")
    public HashMap<String, String> getTestDataInHashmap(int rowNum, String sheetName) throws EncryptedDocumentException, IOException {
        HashMap<String, String> testData = new HashMap<String, String>();
        sh = wb.getSheet(sheetName);
        for(int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
            //	sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
            String key = sh.getRow(0).getCell(i).toString();
            String value = sh.getRow(rowNum).getCell(i).toString();
            testData.put(key, value);
        }
        return testData;
    }

    public int getRowCount() {
        return sh.getLastRowNum();
    }

}
