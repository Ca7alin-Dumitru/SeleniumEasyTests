package layer.higher;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

import static org.junit.Assert.assertTrue;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"./../seleniumeasy_cucumber_reader/src/main/java/features"}, glue = {"layer.higher.cucumber.steps"}, plugin = {"pretty"})
public class SeleniumeasyCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    private Logger logger;
    private String failedMessage;

    @BeforeClass
    public void setup(){
        logger = Logger.getLogger("ApiBddTests.class");
        PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources"+ File.separator +"log4j.properties");
        logger.setLevel(Level.ERROR);
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        logger.info("=== PO Starts tests ===");
    }

    @Test(dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
        failedMessage = "Test failed for this \"" +
                pickleEvent.getPickleEvent().uri.substring(
                        pickleEvent.getPickleEvent().uri.lastIndexOf("\\")+1,
                        pickleEvent.getPickleEvent().uri.lastIndexOf(".")) + "\" feature at this\"" +
                pickleEvent.getPickleEvent().pickle.getName() + "\" scenario!";
    }

    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper}
     *         objects.
     */
    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS != result.getStatus()) {
            logger.error("Test: " + result.getName() + " method is with status FAILED! " + failedMessage);
        }
    }

    @AfterClass
    public void tearDown(){
        testNGCucumberRunner.finish();
        logger.info("=== PO tests end ===");
    }
}
