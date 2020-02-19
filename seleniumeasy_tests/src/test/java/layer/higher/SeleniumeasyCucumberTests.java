package layer.higher;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"./../seleniumeasy_cucumber_tests/src/main/java/features"}, glue = {"layer.higher.cucumber.steps"}, plugin = {"pretty"})
public class SeleniumeasyCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void startFlow(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper}
     *         objects.
     */
    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void tearDown(){
        testNGCucumberRunner.finish();
    }
}
