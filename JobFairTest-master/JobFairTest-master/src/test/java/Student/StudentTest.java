package Student;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StudentTest extends PomcnaKlasa {
    @BeforeTest
    public void UspesnoLogovanjeStudent() throws InterruptedException {
        WebElement KorisnickoIme = driver.findElement(By.xpath("//input [@id =\"loginUsername\"]"));
        KorisnickoIme.sendKeys("aleksa");
        Thread.sleep(2000);
        WebElement Lozinka = driver.findElement(By.xpath("//input [@id =\"loginPassword\"]"));
        Lozinka.sendKeys("Sifra1234$");
        Thread.sleep(2000);
        WebElement UlogujSE = driver.findElement(By.xpath("//button [@name =\"loginButton\"]"));
        UlogujSE.click();
    }

    @Test
    public void ProveravanjeMogucnostiStudent() throws InterruptedException {
        WebElement PretragaKompanija = driver.findElement(By.xpath("//*[@href=\"pretragaKompanija.php\"]"));
        PretragaKompanija.click();
        WebElement Konkursi = driver.findElement(By.xpath("//*[@href =\"pretragaKompanijaKonkursa.php\"]"));
        Konkursi.click();
        Thread.sleep(2000);
        WebElement CV = driver.findElement(By.xpath("//*[@href =\"studentCV.php\"]"));
        CV.click();
        Thread.sleep(2000);
        WebElement Rezultati = driver.findElement(By.xpath("//*[@href =\"studentRez.php\"]"));
        Rezultati.click();
        WebElement Odjavljivanje = driver.findElement(By.xpath("//*[@href =\"logout.php\"]"));
        Odjavljivanje.click();

    }
    @Test
    public void PretragaIPrijavaKonkursa() throws InterruptedException {
        WebElement Konkursi = driver.findElement(By.xpath("//*[@href =\"pretragaKompanijaKonkursa.php\"]"));
        Konkursi.click();
        WebElement NazivKompanije = driver.findElement(By.id("preNazivK"));
        NazivKompanije.sendKeys("Microsoft");
        Thread.sleep(2000);
        WebElement NazivGrada = driver.findElement(By.id("preNazivPP"));
        NazivGrada.sendKeys("Projektant softvera");
        Thread.sleep(2000);
        WebElement Praksa = driver.findElement(By.id("prePr"));
        Praksa.click();
        Thread.sleep(2000);
        WebElement Posao = driver.findElement(By.id("prePo"));
        Posao.click();
        Thread.sleep(2000);
        WebElement NazivKompanije1 = driver.findElement(By.xpath("//*[contains(text(), \"Naizv\")]"));
        NazivKompanije1.isDisplayed();
        Thread.sleep(2000);
        WebElement NazivKonkursa = driver.findElement(By.xpath("//*[contains(text(), \"Naziv konkursa\")]"));
        NazivKonkursa.isDisplayed();
        Thread.sleep(2000);
        WebElement TipKonkursa = driver.findElement(By.xpath("//*[contains(text(), \"Tip konkursa\")]"));
        TipKonkursa.isDisplayed();
        Thread.sleep(2000);
        WebElement RokZaPrijavu = driver.findElement(By.xpath("//*[contains(text(), \"Rok\")]"));
        RokZaPrijavu.isDisplayed();
        Thread.sleep(2000);
        WebElement PogledatiKonkurs = driver.findElement(By.xpath("//*[contains(text(), \"Projektant softvera\")]"));
        PogledatiKonkurs.click();
        Thread.sleep(2000);
        WebElement PropratnoPismo = driver.findElement(By.id("CLta"));
        PropratnoPismo.sendKeys("Zelim da se prijavim na ovu poziciju");
        WebElement PrijavaNaKonkurs = driver.findElement(By.xpath("//*[contains(text(), \"PRIJAVI\")]"));
        PrijavaNaKonkurs.click();
        Thread.sleep(2000);
        WebElement PorukaZaPrijavu = driver.findElement(By.id("porukaSadrzaj"));
        String trenutnaPoruka = PorukaZaPrijavu.getText();
        String ocekivanaPoruka = "Uspešno ste se prijavili na konkurs!";
        System.out.print("Trenutna poruka je:"+trenutnaPoruka);
        Assert.assertEquals(ocekivanaPoruka, trenutnaPoruka);



    }
    @Test
    public void UpisivanjePocetnimMalimSlovima () throws InterruptedException{
        WebElement Konkursi = driver.findElement(By.xpath("//*[@href =\"pretragaKompanijaKonkursa.php\"]"));
        Konkursi.click();
        WebElement NazivKompanije = driver.findElement(By.id("preNazivK"));
        NazivKompanije.sendKeys("microsoft");
        Thread.sleep(2000);
        WebElement NazivGrada = driver.findElement(By.id("preNazivPP"));
        NazivGrada.sendKeys("projektant softvera");
        Thread.sleep(2000);
        WebElement Praksa = driver.findElement(By.id("prePr"));
        Praksa.click();
        Thread.sleep(2000);
        WebElement Posao = driver.findElement(By.id("prePo"));
        Posao.click();
        Thread.sleep(2000);
        WebElement NazivKompanije1 = driver.findElement(By.xpath("//*[contains(text(), \"Naizv\")]"));
        NazivKompanije1.isDisplayed();
        Thread.sleep(2000);
        WebElement NazivKonkursa = driver.findElement(By.xpath("//*[contains(text(), \"Naziv konkursa\")]"));
        NazivKonkursa.isDisplayed();
        Thread.sleep(2000);
        WebElement TipKonkursa = driver.findElement(By.xpath("//*[contains(text(), \"Tip konkursa\")]"));
        TipKonkursa.isDisplayed();
        Thread.sleep(2000);
        WebElement RokZaPrijavu = driver.findElement(By.xpath("//*[contains(text(), \"Rok\")]"));
        RokZaPrijavu.isDisplayed();
        Thread.sleep(2000);
        WebElement PogledatiKonkurs = driver.findElement(By.xpath("//*[contains(text(), \"Projektant softvera\")]"));
        PogledatiKonkurs.click();

    }

    @Test
    public void IzmeniCV () throws InterruptedException {
        WebElement CV = driver.findElement(By.xpath("//*[@href =\"studentCV.php\"]"));
        CV.click();
        Thread.sleep(2000);
        WebElement IzmeniCV = driver.findElement(By.xpath("//button[@name= \"izmCV\"]"));
        IzmeniCV.click();
        Thread.sleep(2000);
        WebElement Opis = driver.findElement(By.id("opisCV"));
        Opis.sendKeys("Ovo je moj CV");
        Thread.sleep(2000);
        WebElement Edukacija = driver.findElement(By.xpath("//*[@value=\"3-5\"]"));
        Edukacija.click();
        Thread.sleep(2000);
        WebElement DodajEdukaciju = driver.findElement(By.xpath("//button[@name=\"obrCVdod\"]"));
        DodajEdukaciju.click();
        Thread.sleep(2000);
        WebElement DodajJezik = driver.findElement(By.xpath("//*[contains(text(), \"Srpski\")]"));
        DodajJezik.click();
        WebElement DugmeDodajJezik = driver.findElement(By.xpath("//button[@name=\"jezCVdod\"]"));
        DugmeDodajJezik.click();
        Thread.sleep(2000);
        WebElement RadnoIskustvo = driver.findElement(By.xpath("//*[contains(text(), \"Senior\")]"));
        RadnoIskustvo.click();
        Thread.sleep(2000);
        WebElement DodajRadnoIskustvo = driver.findElement(By.xpath("//button[@name=\"riCVdod\"]"));
        DodajRadnoIskustvo.click();
        Thread.sleep(2000);
        WebElement RadNaRacunaru = driver.findElement(By.xpath("//*[contains(text(), \"Java\")]"));
        RadNaRacunaru.click();
        Thread.sleep(2000);
        WebElement DodajRadNaRacunaru = driver.findElement(By.xpath("//button[@name=\"rrCVdod\"]"));
        DodajRadNaRacunaru.click();
        Thread.sleep(2000);
        WebElement Vestine = driver.findElement(By.xpath("//*[contains(text(), \"Komunikacija\")]"));
        Vestine.click();
        Thread.sleep(2000);
        WebElement DodajVesitine = driver.findElement(By.xpath("//button[@name=\"veCVdod\"]"));
        DodajVesitine.click();
        Thread.sleep(2000);
        WebElement VozackaDozvola = driver.findElement(By.xpath("//*[contains(text(), \"Nemam\")]"));
        VozackaDozvola.click();
        Thread.sleep(2000);
        WebElement DodajVozackuDozvolu = driver.findElement(By.xpath("//button[@name=\"doCVdod\"]"));
        DodajVozackuDozvolu.click();
        Thread.sleep(2000);
        WebElement PosaljiCV = driver.findElement(By.xpath("//button[@name=\"btnCV\"]"));
        PosaljiCV.click();
        Thread.sleep(2000);
        WebElement PoslatCV = driver.findElement(By.id("greskaPoruka"));
        String trenutnaPoruka = PoslatCV.getText();
        String ocekivanaPoruka = "Bravo!";
        System.out.print("Trenutna poruka je:"+trenutnaPoruka);
        Assert.assertEquals(ocekivanaPoruka, trenutnaPoruka);

    }
    @Test
    public void NemaOpisa () throws  InterruptedException {
        WebElement CV = driver.findElement(By.xpath("//*[@href =\"studentCV.php\"]"));
        CV.click();
        Thread.sleep(2000);
        WebElement IzmeniCV = driver.findElement(By.xpath("//button[@name= \"izmCV\"]"));
        IzmeniCV.click();
        Thread.sleep(2000);
        WebElement Opis = driver.findElement(By.id("opisCV"));
        Opis.isEnabled();
        Thread.sleep(2000);
        WebElement Edukacija = driver.findElement(By.xpath("//*[@value=\"3-5\"]"));
        Edukacija.click();
        Thread.sleep(2000);
        WebElement DodajEdukaciju = driver.findElement(By.xpath("//button[@name=\"obrCVdod\"]"));
        DodajEdukaciju.click();
        Thread.sleep(2000);
        WebElement DodajJezik = driver.findElement(By.xpath("//*[contains(text(), \"Srpski\")]"));
        DodajJezik.click();
        WebElement DugmeDodajJezik = driver.findElement(By.xpath("//button[@name=\"jezCVdod\"]"));
        DugmeDodajJezik.click();
        Thread.sleep(2000);
        WebElement RadnoIskustvo = driver.findElement(By.xpath("//*[contains(text(), \"Senior\")]"));
        RadnoIskustvo.click();
        Thread.sleep(2000);
        WebElement DodajRadnoIskustvo = driver.findElement(By.xpath("//button[@name=\"riCVdod\"]"));
        DodajRadnoIskustvo.click();
        Thread.sleep(2000);
        WebElement RadNaRacunaru = driver.findElement(By.xpath("//*[contains(text(), \"Java\")]"));
        RadNaRacunaru.click();
        Thread.sleep(2000);
        WebElement DodajRadNaRacunaru = driver.findElement(By.xpath("//button[@name=\"rrCVdod\"]"));
        DodajRadNaRacunaru.click();
        Thread.sleep(2000);
        WebElement Vestine = driver.findElement(By.xpath("//*[contains(text(), \"Komunikacija\")]"));
        Vestine.click();
        Thread.sleep(2000);
        WebElement DodajVesitine = driver.findElement(By.xpath("//button[@name=\"veCVdod\"]"));
        DodajVesitine.click();
        Thread.sleep(2000);
        WebElement VozackaDozvola = driver.findElement(By.xpath("//*[contains(text(), \"Nemam\")]"));
        VozackaDozvola.click();
        Thread.sleep(2000);
        WebElement DodajVozackuDozvolu = driver.findElement(By.xpath("//button[@name=\"doCVdod\"]"));
        DodajVozackuDozvolu.click();
        Thread.sleep(2000);
        WebElement PosaljiCV = driver.findElement(By.xpath("//button[@name=\"btnCV\"]"));
        PosaljiCV.click();
        WebElement Poruka = driver.findElement(By.id("porukaSadrzaj"));
        String trenutnaPoruka = Poruka.getText();
        String ocekivanaPoruka = "Niste uneli opis!";
        System.out.print("Trenutna poruka je:"+trenutnaPoruka);
        Assert.assertEquals(ocekivanaPoruka, trenutnaPoruka);


    }
    @Test
    public void PogledajRezultateKonkursa () throws InterruptedException{
        WebElement Rezultati = driver.findElement(By.xpath("//*[@href =\"studentRez.php\"]"));
        Rezultati.click();
        Thread.sleep(2000);
        WebElement RezultatiKonkursa = driver.findElement(By.xpath("//*[@href=\"studentRez.php?idk=3&rez=1\"]"));
        RezultatiKonkursa.click();
        WebElement Osoba = driver.findElement(By.xpath("//*[contains(text(), \"Osoba\")]"));
        Osoba.isDisplayed();
        WebElement Status = driver.findElement(By.xpath("//*[contains(text(), \"Status\")]"));
        Status.isDisplayed();
        WebElement Poruka = driver.findElement(By.xpath("//*[contains(text(), \"Poruka\")]"));
        Poruka.isDisplayed();

    }



}
