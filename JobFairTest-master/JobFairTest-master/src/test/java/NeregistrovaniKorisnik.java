import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.*;

public class NeregistrovaniKorisnik {
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

    @Test()
    public void NeregistrovaniKorisnikMogucnosti() throws InterruptedException {
        WebElement PretragaKompanija = driver.findElement(By.xpath("//a[@href =\"pretragaKompanija.php\"]"));
        PretragaKompanija.click();
        Thread.sleep(2000);
        WebElement nazivKopanijeInput = driver.findElement(By.xpath("//input[@id=\"preNazivKompanije\"]"));
        nazivKopanijeInput.sendKeys("Microsoft");
        Thread.sleep(2000);
        WebElement gradKompanijeInput = driver.findElement(By.xpath("//input[@id=\"preGradKompanije\"]"));
        gradKompanijeInput.isEnabled();
        Thread.sleep(2000);
        WebElement DelatnostiMenu = driver.findElement(By.xpath("//*[@id=\"preDelatnostKompanije\"]"));
        DelatnostiMenu.isDisplayed();
        Thread.sleep(2000);
        WebElement KompanijaIme = driver.findElement(By.xpath("//*[@class=\"beliLinkovi\"]"));
        KompanijaIme.click();
        Thread.sleep(2000);
        WebElement PovratakNaPocetnuStranu = driver.findElement(By.xpath("//*[@href =\"pretragaKompanija.php\"]"));
        PovratakNaPocetnuStranu.click();
        Thread.sleep(2000);


    }

    @Test
    public void NeregistrovaniKorisnikMalaSlova() throws InterruptedException {
        WebElement PretragaKompanija = driver.findElement(By.xpath("//a[@href =\"pretragaKompanija.php\"]"));
        PretragaKompanija.click();
        Thread.sleep(2000);
        WebElement nazivKopanijeInput = driver.findElement(By.xpath("//input[@id=\"preNazivKompanije\"]"));
        nazivKopanijeInput.sendKeys("microsoft");
        Thread.sleep(2000);
        WebElement gradKompanijeInput = driver.findElement(By.xpath("//input[@id=\"preGradKompanije\"]"));
        gradKompanijeInput.sendKeys("beograd");
        Thread.sleep(2000);
        WebElement DelatnostiMenu = driver.findElement(By.xpath("//*[@id=\"preDelatnostKompanije\"]"));
        DelatnostiMenu.isDisplayed();
        Thread.sleep(2000);
        WebElement KompanijaIme = driver.findElement(By.xpath("//*[@class=\"beliLinkovi\"]"));
        KompanijaIme.click();
        Thread.sleep(2000);
        WebElement PovratakNaPocetnuStranu = driver.findElement(By.xpath("//*[@class=\"beliLinkovi\"]"));
        PovratakNaPocetnuStranu.click();
        Thread.sleep(2000);
    }
}



