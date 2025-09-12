package utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Excelreader {

    // DataProvider method
    @DataProvider(name = "excelread")
    public Object[][] getExcelData() {
        Object[][] data = null;

        try {
            // Path to your Excel file
            String fpath = "C:\\Users\\DELL\\OneDrive\\Desktop\\LoginData.xlsx";
            File file = new File(fpath);
            FileInputStream fis = new FileInputStream(file);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("userdata");

            int rows = sheet.getPhysicalNumberOfRows();
            int cells = sheet.getRow(0).getPhysicalNumberOfCells();

            // Initialize data array (excluding header row)
            data = new Object[rows - 1][cells];

            // Loop through rows (starting from 1 to skip header)
            for (int i = 1; i < rows; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < cells; j++) {
                    XSSFCell cell = row.getCell(j);
                    data[i - 1][j] = (cell != null) ? cell.toString() : "";
                    System.out.print(data[i - 1][j] + " | ");
                }
                System.out.println();
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
