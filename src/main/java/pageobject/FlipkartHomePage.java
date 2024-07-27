package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import reusable.BaseCode;
import reusable.ReadWriteExcel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipkartHomePage extends BaseCode {

    //public static Map<String,String> products= new HashMap<>();
    public static List <String> product = new ArrayList<String>();
    public static List <String> price = new ArrayList<String>();

    private static Actions a= new Actions(driver);
    public static String productName;

    public static void searchKeyword(String keyword) throws InterruptedException {
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(keyword);
        driver.findElement(By.xpath("//input[@name='q']")).submit();
        Thread.sleep(2000);
    }

    public static void sortHighToLow() throws InterruptedException {
        driver.findElement(By.xpath("//div[normalize-space(text())='Price -- High to Low']")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }

    public static void verifyPageHeaderAssertions(){
        String expected_result="Mobile Phone- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
        String actual_result=driver.getTitle();
        Assert.assertEquals(expected_result,actual_result);
    }

    public static void storeResultToMap(){
        List<WebElement> productElement=driver.findElements(By.cssSelector(".wjcEIp"));

        List <String> colOne = new ArrayList<String>();
        for(WebElement g:productElement){
            colOne.add(g.getText());
        }

        List<WebElement> priceElement=driver.findElements(By.cssSelector(".Nx9bqj"));
        List <String> colTwo = new ArrayList<String>();
        for(WebElement h:priceElement){
            colTwo.add(h.getText());
        }
        System.out.println(colOne.size());
        for(int i=0;i<colOne.size();i++){
            //products.put(colOne.get(i),colTwo.get(i)); // map
            product.add(colOne.get(i));
            price.add(colTwo.get(i));
        }
    }

    public static void storeResultToExcel() throws IOException {
        ReadWriteExcel.writeToExcel();
    }

    public static void clickLoginButton(){
        driver.findElement(By.xpath("//span[text()='Login']")).click();
    }

    public static void selectProduct(String keyword) throws InterruptedException{
        System.out.println(driver.getTitle());
        String xpath = "//div[contains(text(),'"+keyword+"')]";
        driver.findElement(By.xpath(xpath)).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

    public static void selectVariant(int size) throws InterruptedException {
        String xpath = "//a[contains(text(),'"+size+" GB')]";
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//a[contains(text(),'256 GB')]")).click();
        productName = driver.findElement(By.className("VU-ZEz")).getText();
    }

    public static void addToKart(){
        driver.findElement(By.cssSelector(".QqFHMw.vslbG\\+.In9uk2")).click();
        driver.navigate().back();
    }

    public static void verifyKart() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Cart']")).click();
        String xpath = "//a[contains(text(),'"+productName+"')]";
        Assert.assertEquals(productName,driver.findElement(By.cssSelector(".T2CNXf.QqLTQ-")).getText());
        driver.navigate().back();

    }

    public static void addShippingAddress() throws InterruptedException {
        a.moveToElement(driver.findElement(By.xpath("//div[text()='My Account']"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='My Account']")).click();
        driver.findElement(By.cssSelector(".PbekyG.xrBehW")).click();
        driver.findElement(By.cssSelector(".QqFHMw.qrx0s9.M5XAsp")).click();

        driver.findElement(By.name("name")).sendKeys("Jon Stewart Doe");
        driver.findElement(By.name("phone")).sendKeys("6019521325");
        driver.findElement(By.name("pincode")).sendKeys("600001");
        driver.findElement(By.name("addressLine2")).sendKeys("1600 Amphitheatre Parkway");
        driver.findElement(By.name("addressLine1")).sendKeys("1600 Amphitheatre Parkway\n" + "Apartment 1");
        driver.findElement(By.id("WORK")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    public static void proceedToCheckout() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Cart']")).click();
        driver.findElement(By.cssSelector(".QqFHMw.zA2EfJ._7Pd1Fp")).click();
        Thread.sleep(2000);
    }

    public static void verifyCheckout(){
        String xpath = "//div[contains(text(),'"+productName+"')]";
        if(driver.findElement(By.xpath(xpath)).isDisplayed()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}
