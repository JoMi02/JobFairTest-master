package Kompanija;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KompanijaTest extends PomocnaKlasa{
    @BeforeTest
    public void UspesnoLogovanjeKompanija ()throws InterruptedException {
        WebElement KorisnickoIme = driver.findElement(By.xpath("//input [@id =\"loginUsername\"]"));
        KorisnickoIme.sendKeys("microsoft");
        Thread.sleep(2000);
        WebElement Lozinka = driver.findElement(By.xpath("//input [@id =\"loginPassword\"]"));
        Lozinka.sendKeys("MSbgd.123");
        Thread.sleep(2000);
        WebElement UlogujSE = driver.findElement(By.xpath("//button [@name =\"loginButton\"]"));
        UlogujSE.click();
    }
    @Test
    public void ProveraMogucnostiKompanije () throws InterruptedException{
        WebElement PretragaKompanija = driver.findElement(By.xpath("//*[@href=\"pretragaKompanija.php\"]"));
        PretragaKompanija.click();
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
        WebElement Konkursi = driver.findElement(By.xpath("//*[@href =\"kompanijaKonkurs.php\"]"));
        Konkursi.click();
        Thread.sleep(2000);
        WebElement Sajmovi = driver.findElement(By.xpath("//*[@href =\"kompanijaSajam.php\"]"));
        Sajmovi.click();
        Thread.sleep(2000);
        WebElement Odjavljivanje = driver.findElement(By.xpath("//*[@href =\"logout.php\"]"));
        Odjavljivanje.click();

    }
    @Test
    public void OtvaranjeKonkursa() throws InterruptedException {
        WebElement Konkursi = driver.findElement(By.xpath("//*[@href =\"kompanijaKonkurs.php\"]"));
        Konkursi.click();
        Thread.sleep(2000);
        WebElement DodajNoviKonkurs = driver.findElement(By.xpath("//*[contains(text(), \"DODAJ\")]"));
        DodajNoviKonkurs.click();
        Thread.sleep(2000);
        WebElement NazivKonkursa = driver.findElement(By.id("nazivKon"));
        NazivKonkursa.sendKeys("Developer");
        Thread.sleep(2000);
        WebElement RokKonkursa = driver.findElement(By.id("rokKon"));
        RokKonkursa.sendKeys("12/10/2022");
        Thread.sleep(2000);
        WebElement TeksKonkursa = driver.findElement(By.id("tekstKon"));
        TeksKonkursa.sendKeys("Ovo je konkurs za developera");
        Thread.sleep(2000);
        WebElement NoviKonkurs = driver.findElement(By.id("noviKonDugme"));
        NoviKonkurs.click();
        Thread.sleep(2000);
        WebElement PorukaZaOtvaranjeKonkursa = driver.findElement(By.id("greskaPoruka"));
        String trenutnaPoruka = PorukaZaOtvaranjeKonkursa.getAttribute("poruka");
        String ocekivanaPoruka = "Novi konkurs je otvoren";
        Assert.assertEquals(trenutnaPoruka, ocekivanaPoruka);

    }
    @Test
    public void RangiranjeKonkursa()throws InterruptedException {
        WebElement Konkursi = driver.findElement(By.xpath("//*[@href =\"kompanijaKonkurs.php\"]"));
        Konkursi.click();
        Thread.sleep(2000);
        WebElement Rangiranje = driver.findElement(By.xpath("//*[@href =\"kompanijaKonkurs.php?rng&idk=34\"]"));
        Rangiranje.click();
        WebElement Ocena = driver.findElement(By.id("ocena1"));
        Ocena.sendKeys("-1");
        WebElement Poruka = driver.findElement(By.id("id1"));
        Poruka.sendKeys("Hvala na učestvovanju");
        WebElement Ocena2 = driver.findElement(By.id("id2"));
        Ocena2.sendKeys("5");
        WebElement Poruka2 = driver.findElement(By.id("po2"));
        Poruka2.sendKeys("Bravo");
        WebElement Rangiraj = driver.findElement(By.xpath("//*[contains(text(), \"RANGIRAJ\")]"));
        Rangiraj.click();
        WebElement Rangirane = driver.findElement(By.id("porukaSadrzaj"));
        String trenutnaPoruka = Rangirane.getText();
        String ocekivanaPoruka = "Uspesno ste rangirali";
        System.out.print("Trenutna poruka je:"+trenutnaPoruka);
        Assert.assertEquals(trenutnaPoruka, ocekivanaPoruka);





    }

    @Test
    public void PrijavljivanjeNaSajam () throws InterruptedException {
        WebElement Sajmovi = driver.findElement(By.xpath("//*[@href =\"kompanijaSajam.php\"]"));
        Sajmovi.click();
        Thread.sleep(2000);
        WebElement Prijava = driver.findElement(By.xpath("////*[@class=\"beliLinkovi\"]"));
        Prijava.click();
        WebElement Paket = driver.findElement(By.id("osnovniPaket"));
        Paket.isEnabled();
        WebElement DugmeZaprijavu = driver.findElement(By.xpath("//button[@name=\"dugmePriSajam\"]"));
        DugmeZaprijavu.click();
        WebElement Potvrdi = driver.findElement(By.xpath("//*[contains(text(), \"POTVRDI\")]"));
        Potvrdi.click();
        WebElement Poruka = driver.findElement(By.id("porukaSadrzaj"));
        String trenutnaPoruka = Poruka.getText();
        String ocekivanaPoruka = "Uspesno ste se prijavili";
        System.out.print("Trenutna poruka je:"+trenutnaPoruka);
        Assert.assertEquals(trenutnaPoruka, ocekivanaPoruka);
        WebElement Sajmovi1 = driver.findElement(By.xpath("//*[@href =\"kompanijaSajam.php\"]"));
        Sajmovi1.click();
        WebElement PonovnoPrijavljivanje = driver.findElement(By.xpath("*[contains(text(), \"PRIJAVLJENI\")]"));
        PonovnoPrijavljivanje.isDisplayed();





    }



}
