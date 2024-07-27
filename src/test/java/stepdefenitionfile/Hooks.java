package stepdefenitionfile;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import reusable.BaseCode;
import java.io.IOException;

import static reusable.BaseCode.driver;

public class Hooks {

    @Before
    public void setup() throws IOException {
        System.out.println("Browser opens...");
        BaseCode.browserInvocation();
    }
    @BeforeStep
    public void beforeScreenshot(Scenario s){

        byte[] ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        s.attach(ss, "image/png",s.getName());
    }
    @AfterStep
    public void takeScreenshot(Scenario s){

        byte[] ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        s.attach(ss, "image/png",s.getName());

    }
    @After
    public void tearDown(){
        System.out.println("Browser closes...");
        driver.quit();
    }
}
