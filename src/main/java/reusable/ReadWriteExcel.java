package reusable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.poi.ss.util.CellUtil.createCell;
import static pageobject.FlipkartHomePage.price;
import static pageobject.FlipkartHomePage.product;

public class ReadWriteExcel {

    public static void writeToExcel() throws IOException {

        // Define the file directory
        String directoryPath = "src/main/resources/testresult/";
        // Get the current timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
        // Create the file name with the timestamp
        String fileName = "SearchResults" + timestamp + ".xlsx";
        // Create the full path
        String fullPath = directoryPath + fileName;
        // Create the file
        Path filePath = Paths.get(fullPath);
        try {
            filePath.toFile().createNewFile();
            System.out.println("File created: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCreationHelper createHelper = workbook.getCreationHelper();
        XSSFSheet sheet = workbook.createSheet("Results");
        XSSFRow rowhead = sheet.createRow((short)0);

        rowhead.createCell(0).setCellValue("Product Name");
        rowhead.createCell(1).setCellValue("Price");

        for(int i=1;i<= product.size();i++) {
            Row r =sheet.createRow(i);
            r.createCell(0, CellType.STRING ).setCellValue(product.get(i - 1));
            r.createCell(1).setCellValue(price.get(i - 1));

            System.out.println(product.get(i - 1));
            System.out.println(price.get(i - 1));
        }
        FileOutputStream resultExcel = new FileOutputStream(fullPath);
        workbook.write(resultExcel);
        workbook.close();
        resultExcel.close();
    }
}
