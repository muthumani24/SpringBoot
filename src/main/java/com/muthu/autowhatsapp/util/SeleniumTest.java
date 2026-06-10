package com.muthu.autowhatsapp.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "user-data-dir=C:\\WhatsappProfile"
        );

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://web.whatsapp.com");

        Thread.sleep(30000); // 30 seconds

        //driver.quit();
    }
}