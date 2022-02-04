
package platforms.ui.Web;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import static utils.iUtils.driver;
//import static utils.iUtils.htmlReporter;


@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src/test/feature/ui/Web"},
    //      tags = {"@Recurring_Weekly_Payments__NEDBANK_Current_Account_Repeat_By_End_Date"},
      tags ={"@run1,@run2,@run3,@run4,@run5"},
     //  tags ={"@run1,@run4"},
        glue = {"platforms.ui.Web.StepDefinitions"},
        dryRun =false,
        format = {"pretty"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/WebReports/Web.html"}
        , monochrome = true)


@Test
public class RegressionRunner {
    private static Logger log = Logger.getLogger(RegressionRunner.class);
    public static Utils utils = new Utils();

    @BeforeClass
    public static void setUp(){

    }
    @org.junit.AfterClass
    public static void writeExtentReport() throws IOException {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+ "/extent-web-config.xml"));
        Reporter.setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Java Version",System.getProperty("java.version"));
        Reporter.setSystemInfo("OS Version",System.getProperty("os.name"));
        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        copyLatestExtentReport();
        Reporter.loadXMLConfig("extent-web-config.xml");
      //  driver.quit();
    }

    /***EXTENT REPORT****************************************************************/

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

            while((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void copyLatestExtentReport() throws IOException {
        String timestamp = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss").format(Calendar.getInstance().getTime()).replaceAll(":", "-");
        File source = new File(System.getProperty("user.dir") + "/target/cucumber-reports/WebReports/Web.html");
        File dest = new File(System.getProperty("user.dir") + "/target/cucumber-reports/WebReports/Web_"+ timestamp + ".html");
        copyFileUsingStream(source, dest);
    }

}
