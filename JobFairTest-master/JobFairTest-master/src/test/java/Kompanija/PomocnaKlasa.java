package Kompanija;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PomocnaKlasa {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost/projekat1/projekat1/projekat1/JobFair/login.php";
    String driverPath = "C:\\Users\\joka\\Downloads\\chromedriver_win32//chromedriver.exe";

    @BeforeTest
    public void PokreniChrome() {
        System.out.print("Pokreni Chrome");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterTest(alwaysRun = true)
    public void ZatvoriChrome() {
        driver.quit();

}

}
