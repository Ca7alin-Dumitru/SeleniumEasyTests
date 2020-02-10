package dataprovider;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class InputFormExcel {
    private final static String fileName = "InputFormexcel.xlsx";
    private final static int excelSheet = 0;
    private final static boolean addOnFirstRowEmpty = false;
    private final static int rows = 5;
    private final static int columns = 11;

    @Step
    @DataProvider(name="formValuesWithExcel")
    public static Object[][] getDataFromDataprovider() throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File input;
        try {
            input = new File(URLDecoder.decode(classLoader.getResource(fileName).getFile(), StandardCharsets.UTF_8.toString()));

        }catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }

        if(input.exists() && !input.isDirectory()) {
            String [][] myArray;
            int i = 0;
            if (addOnFirstRowEmpty){
                myArray = new String[(rows+1)][columns];
                i = 1;
                myArray[0][0] = "";
                myArray[0][1] = "";
                myArray[0][2] = "";
                myArray[0][3] = "";
                myArray[0][4] = "";
                myArray[0][5] = "";
                myArray[0][6] = "";
                myArray[0][7] = "";
                myArray[0][8] = "";
                myArray[0][9] = "";
                myArray[0][10] = "";
                myArray[0][11] = "";
            } else {
                myArray = new String[rows][columns];
            }
            try {
                FileInputStream file = new FileInputStream(input);
                // Create Workbook instance holding reference to .xlsx file
                Workbook workbook = WorkbookFactory.create(input);

                // Get first/desired sheet from the workbook
                Sheet sheet = workbook.getSheetAt(excelSheet);

                // Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    // For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int j = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        // Check the cell type and format accordingly

                        switch (cell.getCellTypeEnum()) {
                            case NUMERIC:
                                if(cell.getNumericCellValue() == (int) cell.getNumericCellValue()){
                                    myArray[i][j] = Integer.toString((int)cell.getNumericCellValue());
                                }else{
                                    myArray[i][j] = Double.toString(cell.getNumericCellValue());
                                }
                                break;
                            case STRING:
                                myArray[i][j] = cell.getStringCellValue();
                                break;
                        }
                        j++;
                    }
                    i++;
                }
                file.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            return myArray;
        }

        return new Object[][]{
                { "", "", "", "", "", "", "", "", "", "", ""},
                { "", "", "", "", "", "", "", "", "", "", ""}
        };
    }
}
