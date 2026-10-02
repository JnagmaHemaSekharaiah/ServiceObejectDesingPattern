package api.utilities;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLUtilities
{

    public FileInputStream fis;
    public FileOutputStream fos;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;

    String path;

   public XLUtilities (String path)
   {
       this.path = path;
   }


   public int getRowCount(String sheetName) throws IOException {
      fis = new FileInputStream(path);
      workbook = new XSSFWorkbook(fis);
      sheet = workbook.getSheet("Users");
      int lastRowNum = sheet.getLastRowNum();
      workbook.close();
      fis.close();
      return lastRowNum;
   }

   public int getLastCellCount(String sheetName,int rownum) throws IOException {
       fis = new FileInputStream(path);
       workbook = new XSSFWorkbook(fis);
       sheet = workbook.getSheet(sheetName);
       int lastCellNum  = sheet.getRow(rownum).getLastCellNum();
       workbook.close();
       workbook.close();
       return lastCellNum;
   }


   public String getCellData(String path,int rownum,int clonum) throws IOException {
       fis = new FileInputStream(path);
       workbook = new XSSFWorkbook(fis);
       sheet = workbook.getSheet("Users");
       row =  sheet.getRow(rownum);
       cell = row.getCell(clonum);

       DataFormatter formatter = new DataFormatter();
       String data;

       try
       {
      data = formatter.formatCellValue(cell); //Take the value from this Excel cell and return it as a properly formatted String
       }
       catch (Exception e)
       {
           data ="";
       }

       workbook.close();
       fis.close();

       return data;

   }

    public void setCellData(String path,int colnum,int rownum) throws IOException {
        File file = new File(path);
        if (!file.exists())
        {
         workbook = new XSSFWorkbook();
         fos =  new FileOutputStream(file);
         workbook.write(fos);
        }

    }




}
