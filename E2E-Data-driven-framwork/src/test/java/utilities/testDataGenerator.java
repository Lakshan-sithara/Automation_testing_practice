package utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class testDataGenerator {

    @DataProvider(name="excel")
    public static Object[][] testDataGenerator() throws IOException {

        File f = new File("src/test/java/testData/sample_data.xlsx");
        FileInputStream fs = new FileInputStream(f);
        XSSFWorkbook wk = new XSSFWorkbook(fs);
        XSSFSheet loginSeet = wk.getSheet("login");

        int numberOfData = loginSeet.getPhysicalNumberOfRows();

        Object [][] testData = new Object[numberOfData][2];

        for(int i=0 ; i< numberOfData ;i++ ){
            XSSFRow row = loginSeet.getRow(i);
            XSSFCell username = row.getCell(0);
            XSSFCell password = row.getCell(1);
            testData[i][0] = username.getStringCellValue();
            testData[i][1] = password.getStringCellValue();
        }

        return testData;
    }

}
