import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;





public class Primsol_automated {
    private WebDriver driver;

    @Test
    public void start() throws InterruptedException {
        //Locate chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open Chrome browser
        //Import Selenuimdriver
        WebDriver driver = new ChromeDriver();

        //2. Input your selenium Demo Page URL (https://primso-staging.lawpavilion.com/)
        driver.get("https://primso-staging.lawpavilion.com/");

        Thread.sleep(1000);
        //3. Maximize the Chrome browser
        driver.manage().window().maximize();

        //4. Click the feature tab
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[2]/a")).click();

        //5. Verify Element on the feature tab
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-features/div/section[6]/div/h2")).getText();


        //6. Click on Pricing tab
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[3]/a")).click();

        //Confirm page title
        String expectedpageUrl = "https://primso-staging.lawpavilion.com/compare";
        String actualPageurl = driver.getCurrentUrl();
        if (actualPageurl.contains(expectedpageUrl))
            //Pass
            System.out.println("Pricing page url is Correct");
        else
            //Fail
            System.out.println("Wrong pricing page Url");

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-compare-page/section/section[1]/table/thead/tr[1]/th[6]/div/div/div")).getText();
        Thread.sleep(3000);

        //Click on the What's new tab
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[4]/a")).click();
        Thread.sleep(3000);

        //Click on the contact us tab
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/ul/li[5]/a")).click();
        Thread.sleep(3000);
        //Locate and fill details in the Get in touch page. Fill First name field.
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Doyin");
        Thread.sleep(3000);
        //Locate and fill Last name field
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("Oye");
        Thread.sleep(3000);
        //Locate and fill Subject field
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[2]/input")).sendKeys("What do you do?");
        Thread.sleep(3000);
        //Locate and fill email field
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[3]/input")).sendKeys("oyedoyin@mailinator.com");
        Thread.sleep(3000);
        //Locate and fill Phone number field
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[4]/input")).sendKeys("08132640905");
        Thread.sleep(3000);
        //Locate and fill Message field
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/div[5]/textarea")).sendKeys("What do you do?");
        Thread.sleep(3000);
        //Click send button
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-contact-us/section/div/div[2]/div/form/button")).click();
        Thread.sleep(3000);

        //At the click of the send button an unregistered user should be redirected to the Home tab

        //Click on the subscribe tab, It should redirect user to a new URL
        driver.findElement(By.xpath("/html/body/app-root/app-layout/app-header/header/nav/div[2]/a")).click();
        Thread.sleep(5000);
        //Test case 2: Verify that User is redirected to LawPavilion store at the click of Subscribe tab
        String newUrl = "https://store-staging.lawpavilion.com/register";
        String LawPavilionUrl = driver.getCurrentUrl();
        if (LawPavilionUrl.contains(newUrl))
            //Pass
            System.out.println("Valid webpage");
        else
            //Fail
            System.out.println("Invalid webpage");
        Thread.sleep(5000);
    }
    public void closeBrowser() {
        //12. Quitting browser
        driver.quit();
    }
    
}

