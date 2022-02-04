package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;
public class ObjMethod  {

        public static WebDriver driver = clsConstants.driver;
        public static Map<String, String> page_Objects = new HashMap<String, String>();
        public static WebElement element = null;
        public static String browser;
        public static Map<String, String> dictionary = new HashMap<String, String>();


        public static WebElement getElement(String[] str)
        {

            try
            {
                String desc=page_Objects.get(str);
                switch(str[0])
                {
                    case "ID":  return clsConstants.driver.findElement(By.id(str[1]));
                    case "CLASSNAME":  return clsConstants.driver.findElement(By.className(str[1]));
                    case "LINKTEXT":  return clsConstants.driver.findElement(By.linkText(str[1]));
                    case "NAME":  return clsConstants.driver.findElement(By.name(str[1]));
                    case "xpath":  return clsConstants.driver.findElement(By.xpath(str[1]));
                    //My_Page_Obejcts.put("Username", "xpath|//[contains(@id,'j_username')");
                    //	driver.findElement(By.xpath("//input[contains(@id,'j_username')]"));

                    default: System.out.println("Function getElement cannot return object for " + str);break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Exeption in clsWrp.getElement - ");
                return null;
            }
            return null;
        }

        public static void click(String elementName,String xmlpath) throws Exception
        {
            String[] elementName1 =  iUtils.xmlParser( xmlpath, elementName);
            String strError = null;

            try
            {
                WebElement elmn=getElement( elementName1);

                for(int i = 0;i<50000;i++) {
                    if (elmn.isDisplayed()||elmn.isEnabled())
                    {
                        System.out.println("Click element: " + elementName);
                        //Thread.sleep(3000);
                        /*try {

                            if (clsConstants.driver.findElement(By.xpath("//a[@id='go-to-lifecycle']")).isDisplayed()) {
                                clsConstants.driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
                            }
                        } catch (Exception e) {
                        }*/
                        elmn.click();
                        break;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Exeption in clsWrp.click - "+elementName);}
        }

        public static void setText(String elementName, String textToSet,String xmlpath) throws Exception
        {
            String[] elementName1 =  iUtils.xmlParser( xmlpath, elementName);


            try
            {
                if(textToSet!=null)
                {
                    WebElement elmn=getElement(elementName1);

                    if(elmn.isDisplayed()||elmn.isEnabled())
                    {

                        /*try {

                            if (clsConstants.driver.findElement(By.xpath("//a[@id='go-to-lifecycle']")).isDisplayed()) {
                                clsConstants.driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
                            }
                        } catch (Exception e) {
                        }*/
                        elmn.clear();
                        System.out.println("Populate Textbox: "+elementName+" With value: "+textToSet);

                        elmn.sendKeys(textToSet);

                    }
                    else
                    {

                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Exeption in clsWrp.setText - "+elementName);
            }

        }

        public static void selecttext(String elementName, String textToSet, String xmlpath) throws Exception
        {
            String[] elementName1 =  iUtils.xmlParser( xmlpath, elementName);
            try
            {
                if(textToSet!=null)
                {
                    WebElement elmn=getElement(elementName1);
                    if(elmn.isDisplayed()||elmn.isEnabled())
                    {
                        System.out.println("Populate drop down Field: "+elementName+" With value: "+textToSet);
                        elmn.sendKeys(textToSet);

                    }
                    else
                    {

                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Exeption in clsWrp.setText - "+elementName);
            }

        }

public static String getProperty(String elementName, String propertyName,String xmlpath) throws Exception
{
    String res;
    String[] elementName1 =  iUtils.xmlParser( xmlpath, elementName);
      try {

        WebElement elmn = getElement(elementName1);
          res = elmn.getAttribute(propertyName);

        }
    catch(Exception e)
    {
        System.out.println("Exeption in clsWrp.getProperty - "+elementName);
        res  = null;
    }
    return res;
}

    public  boolean isDisplayed(String elementName,String xmlpath) throws Exception
    {
        String[] elementName1 =  iUtils.xmlParser( xmlpath, elementName);
        boolean res = false;
        try {

            WebElement elmn = getElement(elementName1);
            if (elmn.isDisplayed()||elmn.isEnabled())
            {
                 res = true;
            }

        }

        catch(Exception e)
            {
                System.out.println("Exeption in clsWrp.setText - "+elementName);
                res  = false;
            }
            return res;

    }
        public static String gettext(String elementName,String xmlpath) throws Exception
        {
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(true);


            String[] elementName1 =  iUtils.xmlParser( xmlpath, elementName);
            String strGettxt = null;

            try
            {


                WebElement elmn=getElement(elementName1);
                if(elmn.isDisplayed()||elmn.isEnabled())
                {
                    strGettxt = elmn.getText();

                }
                else
                {
                }
                soft.assertAll();
            }
            catch(Exception e)
            {
                System.out.println("Exeption in clsWrp.setText - "+elementName);
                soft.assertAll();
            }
            return strGettxt;
        }


    }
