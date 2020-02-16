package dataprovider;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;

public class InputFormClass {
    @Step
    @DataProvider(name="formValuesWithClass")
    public static Object[][] getDataFromDataprovider() {
        return new Object[][]{
                {"test1", "test2", "test2@test1.com", "(845)111-999", "Street Hello, No. 1", "My City", "New Mexico", "99999", "www.automation1.com", "no", "this is a test form project1"},
                {"test3", "test4", "test4@test4.com", "(111)222-333", "Street Happy, No. 2", "My New City", "daho", "11111", "www.automation2.com", "yes", "this is a test form project2"}
        };
    }
}
