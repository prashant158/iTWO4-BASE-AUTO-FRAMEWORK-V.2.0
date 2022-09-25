package iTWO_Utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.poi.EncryptedDocumentException;

public class Fillo_Excel_Util {

    private String query;
    private String filePath;
    public String sheet;
    public Fillo fillo;

    public Fillo_Excel_Util(String sheetName) {

        try {
            filePath = System.getProperty("user.dir") + "/src/test/resources/iTWO_TestData/FilloData.xlsx";
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        }
        sheet = sheetName;
    }

    public String SelectParticularValue(String FieldName, String ColumnName) {
        String inputData = new String();
        try {
            query = "SELECT * FROM " + sheet + " WHERE FiledName='" + FieldName + "'";
            fillo = new Fillo();
            Connection connection = fillo.getConnection(filePath);
            Recordset recordset = connection.executeQuery(query);
            while (recordset.next()) {
                inputData = recordset.getField(ColumnName);
            }
            recordset.close();
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputData;

    }

    public String SelectAnyValue(String FieldName, String...ColumnName) {
        String inputData = new String();
        try {
            query = "SELECT "+String.join(",",ColumnName)+" FROM " + sheet + " WHERE FiledName='" + FieldName + "'";
            fillo = new Fillo();
            Connection connection = fillo.getConnection(filePath);
            Recordset recordset = connection.executeQuery(query);
            while (recordset.next()) {
                inputData = recordset.getField(String.join(",",ColumnName));
            }
            recordset.close();
            connection.close();
        } catch (FilloException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputData;

    }
}
