package com.example.demo1;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
class MainPageTest {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        WebDriver driver  = new ChromeDriver();

        driver.get("https://www.avito.ru/avito-care/eco-impact");
        driver.manage().window().maximize();


        WebElement element = driver.findElement(By.xpath ("//*[@id=\"app\"]/div/div[3]/div/div/div/div/div[3]/div/div[2]"));


        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);

        ImageIO.write(screenshot.getImage(), "jpg", new File("/Users/vladimirbarkan/Desktop/ElementScreenshot.jpg"));
    }
}