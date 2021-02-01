package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "allValidFields")
    public static Object[][] getDataWithAllValidFields() {
        Object[][] data = new Object[1][4];
        data[0][0] = "Article Title field";
        data[0][1] = "Article About field";
        data[0][2] = "Write your Article field";
        data[0][3] = "Article Tag field";
        return data;
    }

    @DataProvider(name = "Empty fields")
    public static Object[][] getDataWithAllEmptyFields() {
        Object[][] data = new Object[1][4];
        data[0][0] = "";
        data[0][1] = "";
        data[0][2] = "";
        data[0][3] = "";
        return data;
    }

    @DataProvider(name = "allValidFields for check edit option")
    public static Object[][] getDataWithAllValidFieldsUpdated() {
        Object[][] data = new Object[1][8];
        data[0][0] = "Article Title field";
        data[0][1] = "Article About field";
        data[0][2] = "Write your Article field";
        data[0][3] = "Article Tag field";
        data[0][4] = "Article Title field Updated";
        data[0][5] = "Article About field Updated";
        data[0][6] = "Write your Article field Updated";
        data[0][7] = "Article Tag field Updated";
        return data;
    }
}
