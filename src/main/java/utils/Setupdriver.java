package utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setupdriver {

  public static WebDriver driver = null;

    public static WebDriver initializeWedriver(String sdriverName, String strURL)
    {
        try
        {
            switch (sdriverName.toUpperCase())
            {
                case "CHROME":
                    try
                    {
                        System.setProperty("webdriver.chrome.driver","Drivers/Windows/chromedriver.exe");
                        ChromeOptions options = new ChromeOptions();
                     //   options.setExperimentalOption("useAutomationExtension", false);
                        options.addArguments("start-maximized");
                        System.out.println("before initialising driver");
                        WebDriver driver = new ChromeDriver(options);
                        System.out.println("before launching simplybiz");
                      //  driver = (WebDriver) new ChromeDriver();
                        System.out.println("after launching simplybiz");
                        driver.get(strURL);
                          clsConstants.driver=driver;

                    }catch(Exception e) {
                        System.out.print("not a Mac machine");
                        System.setProperty("webdriver.chrome.driver","drivers/Chromedriver.exe");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-maximized");
                        driver = (WebDriver) new ChromeDriver(options);
                        // driver.manage().window().maximize();


                    }
                    break;

                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                    ///	  WebDriver driver2 =  new WebDriver();
                    break;


                case "IE":
                    System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
                    driver = (WebDriver) new InternetExplorerDriver();
                    break;

            }
            clsConstants.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        }catch(Exception e)
        {
            System.out.print(e.getMessage());
        }

        return clsConstants.driver;

    }

}
