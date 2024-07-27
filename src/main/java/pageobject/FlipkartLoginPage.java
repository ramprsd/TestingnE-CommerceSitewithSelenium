package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import reusable.BaseCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipkartLoginPage extends BaseCode {

    public static void enterPhoneNoOrEmail(String user){
        driver.findElement(By.cssSelector(".r4vIwl.BV\\+Dqf")).sendKeys(user);
    }

    public static void clickRequestOTP(){
        driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
    }

//    public static void clickVerify() throws InterruptedException {
//        driver.findElement((By.xpath("//button[text()='Verify']"))).click();
//        Thread.sleep(2000);
//    }

    public static void enterOTP() throws IOException, InterruptedException {
        List<WebElement> otp = driver.findElements(By.cssSelector(".r4vIwl.IX3CMV"));

        Scanner myInput = new Scanner( System.in );
        System.out.println("Enter OTP numbers individually and press enter ... ");
        int[] getOtp= {1,2,3,4,5,6};

        for(int i=1;i<=6;i++){
            System.out.println("Number "+i+" :");
            getOtp[i-1]=myInput.nextInt();
            otp.get(i-1).sendKeys(String.valueOf(getOtp[i-1]));
        }
        Thread.sleep(2000);
    }
}
