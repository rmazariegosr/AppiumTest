package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;

import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumSampleTest {

    public static void main(String[] args) {

        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "192.168.0.32:5555"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.1.1");
        caps.setCapability("appPackage", "com.android.vending");
        caps.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        caps.setCapability("noReset", "true");

        //Instantiate Appium Driver
        try {
            AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

            MobileElement searchbar = driver.findElementByAccessibilityId("Search");
            searchbar.click();
            WebDriverWait wait = new WebDriverWait(driver,4);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
            searchbar = driver.findElement(By.className("android.widget.EditText"));
            searchbar.sendKeys("slack", Keys.ENTER);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }

}