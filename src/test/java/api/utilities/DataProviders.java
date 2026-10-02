package api.utilities;

import java.io.IOException;

public class DataProviders
{

    public static void main(String[] args) throws IOException {
        DataProviders.getAllData();
        DataProviders.getUserName();

    }


    @org.testng.annotations.DataProvider(name ="Data")
    public static String[][] getAllData() throws IOException {

        String path = "C:\\Users\\sekha\\Desktop\\API Testing\\ServiceObjectDesignPattern\\PetStoreAutomation\\testData\\user_data.xlsx";

        XLUtilities  xls = new XLUtilities(path);
        int rowxl =  xls.getRowCount("Users");
        int colxl = xls.getLastCellCount("Users",1);

        String apiData[][] = new String[rowxl][colxl];
        for (int row=1;row<=rowxl;row++)
        {
            for (int col =0;col<colxl;col++)
            {
            apiData[row-1][col] = xls.getCellData(path,row,col);
            }
        }

        return apiData;
    }

    @org.testng.annotations.DataProvider(name="UserName")
    public static String[] getUserName() throws IOException {

        String path = "C:\\Users\\sekha\\Desktop\\API Testing\\ServiceObjectDesignPattern\\PetStoreAutomation\\testData\\user_data.xlsx";

        XLUtilities  xls = new XLUtilities(path);
        int rowxl =  xls.getRowCount("Users");
        int colxl = xls.getLastCellCount("Users",1);

        String apiData[] = new String [rowxl];

        for (int row=1;row<=rowxl ; row++)
        {
                apiData[row-1] = xls.getCellData(path,row,1);
        }

        return apiData;

    }








}
