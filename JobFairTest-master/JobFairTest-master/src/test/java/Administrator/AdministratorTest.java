package Administrator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdministratorTest extends PomocnaKlasa {
    @BeforeTest
    public void UspesnoLogovanjeAdmin ()throws InterruptedException {
        WebElement KorisnickoIme = driver.findElement(By.xpath("//input [@id =\"loginUsername\"]"));
        KorisnickoIme.sendKeys("admin");
        Thread.sleep(2000);
        WebElement Lozinka = driver.findElement(By.xpath("//input [@id =\"loginPassword\"]"));
        Lozinka.sendKeys("Admin123.");
        Thread.sleep(2000);
        WebElement UlogujSE = driver.findElement(By.xpath("//button [@name =\"loginButton\"]"));
        UlogujSE.click();
    }
    @Test
    public void ProveravanjeMogucnosti ()throws InterruptedException {
        WebElement PretragaKompanija = driver.findElement(By.xpath("//*[@href=\"pretragaKompanija.php\"]"));
        PretragaKompanija.click();
        Thread.sleep(2000);
        WebElement PocetnaStrana = driver.findElement(By.xpath("//*[@class=\"navbar-brand\"]"));
        PocetnaStrana.click();
        Thread.sleep(2000);
        WebElement Rokovi = driver.findElement(By.xpath("//*[@href=\"adminRokovi.php\"]"));
        Rokovi.click();
        Thread.sleep(2000);
        WebElement NoviSajam = driver.findElement(By.xpath("//*[@href=\"adminNoviSajam.php\"]"));
        NoviSajam.click();
        Thread.sleep(2000);
        WebElement AdminPregled = driver.findElement(By.xpath("//*[@href=\"adminPregled.php\"]"));
        AdminPregled.click();
        Thread.sleep(2000);
        WebElement Izlazak = driver.findElement(By.xpath("//*[@href=\"logout.php\"]"));
        Izlazak.click();
    }
    @Test
        public void NeupisivanjeRokova()throws InterruptedException {
        WebElement Rokovi = driver.findElement(By.xpath("//*[@href=\"adminRokovi.php\"]"));
        Rokovi.click();
        WebElement RokZaOstavljanjeCV1 = driver.findElement(By.xpath("//input[@id=\"rokCVdole\"]"));
        RokZaOstavljanjeCV1.sendKeys("000000");
        Thread.sleep(2000);
        WebElement RokZaOstavljanjeCV2 = driver.findElement(By.xpath("//input[@id=\"rokCVgore\"]"));
        RokZaOstavljanjeCV2.sendKeys("000000");
        Thread.sleep(2000);
        WebElement RokZaPrijavljivanjeKompanija1 = driver.findElement(By.xpath("//input[@id=\"rokSAdole\"]"));
        RokZaPrijavljivanjeKompanija1.sendKeys("000000");
        Thread.sleep(2000);
        WebElement RokZaPrijavljivanjeKompanija2 = driver.findElement(By.xpath("//input[@id=\"rokSAgore\"]"));
        RokZaPrijavljivanjeKompanija2.sendKeys("000000");
        Thread.sleep(2000);
        WebElement Azuriraj = driver.findElement(By.xpath("//*[@class=\"btn btn-warning\"]"));
        Azuriraj.click();
        Thread.sleep(2000);
        WebElement PromenaRokova = driver.findElement(By.xpath("//*[@id=\"poruka\"]"));
        String trenutnaPoruka = PromenaRokova.getText();
        String ocekivanaPoruka = "Аžuriranje nije uspelo";
        System.out.print("Trenutna poruka je: " + trenutnaPoruka);
        Assert.assertEquals(trenutnaPoruka, ocekivanaPoruka);

    }
    @Test
    public void ProveravanjeRokova() throws InterruptedException {
        WebElement Rokovi = driver.findElement(By.xpath("//*[@href=\"adminRokovi.php\"]"));
        Rokovi.click();
        WebElement RokZaOstavljanjeCV1 = driver.findElement(By.xpath("//input[@id=\"rokCVdole\"]"));
        RokZaOstavljanjeCV1.sendKeys("12/05/2022");
        Thread.sleep(2000);
        WebElement RokZaOstavljanjeCV2 = driver.findElement(By.xpath("//input[@id=\"rokCVgore\"]"));
        RokZaOstavljanjeCV2.sendKeys("12/19/2022");
        Thread.sleep(2000);
        WebElement RokZaPrijavljivanjeKompanija1 = driver.findElement(By.xpath("//input[@id=\"rokSAdole\"]"));
        RokZaPrijavljivanjeKompanija1.sendKeys("12/05/2022");
        Thread.sleep(2000);
        WebElement RokZaPrijavljivanjeKompanija2 = driver.findElement(By.xpath("//input[@id=\"rokSAgore\"]"));
        RokZaPrijavljivanjeKompanija2.sendKeys("12/19/2022");
        Thread.sleep(2000);
        WebElement Azuriraj = driver.findElement(By.xpath("//*[@class=\"btn btn-warning\"]"));
        Azuriraj.click();
        Thread.sleep(2000);
        WebElement PromenaRokova = driver.findElement(By.xpath("//*[@id=\"porukaSadrzaj\"]"));
        String trenutnaPoruka = PromenaRokova.getText();
        String ocekivanaPoruka = "Uspešno su promenjeni rokovi!";
        System.out.print("Trenutna poruka je:"+ trenutnaPoruka);
        Assert.assertEquals(trenutnaPoruka, ocekivanaPoruka);

    }

        @Test
    public void UspesnoKreiranjeSajmaKorak1 () throws InterruptedException {
        WebElement NoviSajam = driver.findElement(By.xpath("//*[@href=\"adminNoviSajam.php\"]"));
        NoviSajam.click();
        Thread.sleep(2000);
        WebElement NazivSajma = driver.findElement(By.xpath("//input[@id = \"nazivSajma\"]"));
        NazivSajma.sendKeys("Sajam zapošljavanja");
        Thread.sleep(2000);
        WebElement Opis = driver.findElement(By.id("opisSajma"));
        Opis.sendKeys("Ovo je sajam zapošljavanja");
        Thread.sleep(2000);
        WebElement Mesto = driver.findElement(By.xpath("//input[@id =\"mestoSajma\"]"));
        Mesto.sendKeys("Beograd");
        Thread.sleep(2000);
        WebElement Rok1 = driver.findElement(By.id("sajamDatumOD"));
        Rok1.sendKeys("12/13/2022");
        Thread.sleep(2000);
        WebElement Rok2 = driver.findElement(By.id("sajamDatumDO"));
        Rok2.sendKeys("12/14/2022");
        Thread.sleep(2000);
        WebElement VremeOD = driver.findElement(By.id("sajamVremeOD"));
        VremeOD.sendKeys("09:00 AM");
        Thread.sleep(2000);
        WebElement VremeDO = driver.findElement(By.id("sajamVremeDO"));
        VremeDO.sendKeys("01:00 PM");
        Thread.sleep(2000);
        WebElement Sala = driver.findElement(By.id("nazSale1"));
        Sala.sendKeys("Amfiteatar 2");
        Thread.sleep(2000);
        WebElement Dodaj = driver.findElement(By.xpath("//button[@name =\"obrCVdod\"]"));
        Dodaj.click();
        Thread.sleep(2000);
        WebElement RokZaPrijavu = driver.findElement(By.id("rokZaprijavuSajam"));
        RokZaPrijavu.sendKeys("12/13/2022");
        Thread.sleep(2000);
        WebElement Korak2 = driver.findElement(By.xpath("//button[@name =\"k1nak2\"]"));
        Korak2.click();
    }

        @Test (dependsOnMethods = "UspesnoKreiranjeSajmaKorak1")
        public void UspesnoKreiranjeSajmaKorak2 () throws InterruptedException{
            WebElement Predavanje = driver.findElement(By.id("0001"));
            Predavanje.click();
            Thread.sleep(2000);
            WebElement Prezentacija = driver.findElement(By.id("0012"));
            Prezentacija.click();
            Thread.sleep(2000);
            WebElement Radionica = driver.findElement(By.id("0122"));
            Radionica.click();
            WebElement Korak3 = driver.findElement(By.xpath("//button[@name =\"k2nak3\"]"));
            Korak3.click();
        }


    @Test
    public void NeUpisivanjeNazivaiOpisaSajma () throws InterruptedException {
        WebElement NoviSajam = driver.findElement(By.xpath("//*[@href=\"adminNoviSajam.php\"]"));
        NoviSajam.click();
        WebElement NazivSajma = driver.findElement(By.xpath("//input[@id = \"nazivSajma\"]"));
        NazivSajma.isEnabled();
        Thread.sleep(2000);
        WebElement Opis = driver.findElement(By.id("opisSajma"));
        Opis.isEnabled();
        Thread.sleep(2000);
        WebElement Mesto = driver.findElement(By.xpath("//input[@id =\"mestoSajma\"]"));
        Mesto.isEnabled();
        Thread.sleep(2000);
        WebElement Rok1 = driver.findElement(By.id("sajamDatumOD"));
        Rok1.isEnabled();
        Thread.sleep(2000);
        WebElement Rok2 = driver.findElement(By.id("sajamDatumDO"));
        Rok2.isEnabled();
        Thread.sleep(2000);
        WebElement VremeOD = driver.findElement(By.id("sajamVremeOD"));
        VremeOD.isEnabled();
        Thread.sleep(2000);
        WebElement VremeDO = driver.findElement(By.id("sajamVremeDO"));
        VremeDO.isEnabled();
        Thread.sleep(2000);
        WebElement Sala = driver.findElement(By.id("nazSale1"));
        Sala.isEnabled();
        Thread.sleep(2000);
        WebElement Dodaj = driver.findElement(By.xpath("//button[@name =\"obrCVdod\"]"));
        Dodaj.isEnabled();
        Thread.sleep(2000);
        WebElement RokZaPrijavu = driver.findElement(By.id("rokZaprijavuSajam"));
        RokZaPrijavu.isEnabled();
        Thread.sleep(2000);
        WebElement Korak2 = driver.findElement(By.xpath("//button[@name =\"k1nak2\"]"));
        Korak2.click();
        WebElement GreskaPoruka = driver.findElement(By.id("greskaPoruka"));
        String trenutnaPoruka = GreskaPoruka.getAttribute("poruka");
        String ocekivanaPoruka = "Niste uneli potrebne podatke";
        System.out.print("Trenutna poruka je:"+trenutnaPoruka);
        Assert.assertEquals(trenutnaPoruka, ocekivanaPoruka);

    }
    @Test (dependsOnMethods = {"UspesnoKreiranjeSajmaKorak1","UspesnoKreiranjeSajmaKorak2"})
    public void UspesnoKreiranjeSajmaKorak3 () throws InterruptedException{
        WebElement NazivPaketa = driver.findElement(By.xpath("//input[@id=\"pn1\"]"));
        NazivPaketa.sendKeys("Generalni pokrovitelj");
        Thread.sleep(2000);
        WebElement TipPaketa = driver.findElement(By.xpath("//input[@id=\"osn1\"]"));
        TipPaketa.click();
        Thread.sleep(2000);
        WebElement Stand = driver.findElement(By.xpath("//button[@onclick=\"dodStav(1)\"]"));
        Stand.click();
        Thread.sleep(2000);
        WebElement BrojPredavanja = driver.findElement(By.id("pp1"));
        BrojPredavanja.sendKeys("2");
        Thread.sleep(2000);
        WebElement BrojRadionica = driver.findElement(By.id("pr1"));
        BrojRadionica.sendKeys("1");
        Thread.sleep(2000);
        WebElement VideoPrezentacija = driver.findElement(By.id("pv1"));
        VideoPrezentacija.sendKeys("15");
        Thread.sleep(2000);
        WebElement BrojKompanija = driver.findElement(By.id("pk1"));
        BrojKompanija.sendKeys("3");
        Thread.sleep(2000);
        WebElement CenaPaketa = driver.findElement(By.id("pc1"));
        CenaPaketa.sendKeys("25000");
        Thread.sleep(2000);
        WebElement DodajPaket = driver.findElement(By.xpath("//button[@onclick=\"dodPak()\"]"));
        DodajPaket.click();
        WebElement NazivPaketa2 = driver.findElement(By.xpath("//input[@id=\"pn2\"]"));
        NazivPaketa2.sendKeys("Zlatni pokrovitelj");
        Thread.sleep(2000);
        WebElement TipPaketa2 = driver.findElement(By.xpath("//input[@id=\"osn2\"]"));
        TipPaketa2.click();
        Thread.sleep(2000);
        WebElement Stand2 = driver.findElement(By.xpath("//button[@onclick=\"dodStav(1)\"]"));
        Stand2.click();
        Thread.sleep(2000);
        WebElement BrojPredavanja2 = driver.findElement(By.id("pp2"));
        BrojPredavanja2.sendKeys("1");
        Thread.sleep(2000);
        WebElement BrojRadionica2 = driver.findElement(By.id("pr2"));
        BrojRadionica2.sendKeys("1");
        Thread.sleep(2000);
        WebElement VideoPrezentacija2 = driver.findElement(By.id("pv2"));
        VideoPrezentacija2.sendKeys("15");
        Thread.sleep(2000);
        WebElement BrojKompanija2 = driver.findElement(By.id("pk2"));
        BrojKompanija2.sendKeys("3");
        Thread.sleep(2000);
        WebElement CenaPaketa2 = driver.findElement(By.id("pc2"));
        CenaPaketa2.sendKeys("20000");
        Thread.sleep(2000);
        WebElement KreirajNovisajam = driver.findElement(By.xpath("//*[contains(text(), \"KREIRAJ SAJAM\")]"));
        KreirajNovisajam.click();
    }
    @Test (dependsOnMethods = {"UspesnoKreiranjeSajmaKorak1",  "UspesnoKreiranjeSajmaKorak2"})
    public void NeUpisivanjeNazivaPaketa () throws InterruptedException {
        WebElement NazivPaketa = driver.findElement(By.xpath("//input[@id=\"pn1\"]"));
        NazivPaketa.isEnabled();
        Thread.sleep(2000);
        WebElement TipPaketa = driver.findElement(By.xpath("//input[@id=\"osn1\"]"));
        TipPaketa.click();
        Thread.sleep(2000);
        WebElement Stand = driver.findElement(By.xpath("//button[@onclick=\"dodStav(1)\"]"));
        Stand.click();
        Thread.sleep(2000);
        WebElement BrojPredavanja = driver.findElement(By.id("pp1"));
        BrojPredavanja.sendKeys("1");
        Thread.sleep(2000);
        WebElement BrojRadionica = driver.findElement(By.id("pr1"));
        BrojRadionica.sendKeys("2");
        Thread.sleep(2000);
        WebElement VideoPrezentacija = driver.findElement(By.id("pv1"));
        VideoPrezentacija.sendKeys("15");
        Thread.sleep(2000);
        WebElement BrojKompanija = driver.findElement(By.id("pk1"));
        BrojKompanija.sendKeys("3");
        Thread.sleep(2000);
        WebElement CenaPaketa = driver.findElement(By.id("pc1"));
        CenaPaketa.sendKeys("30000");
        WebElement KreirajNovisajam = driver.findElement(By.xpath("//*[contains(text(), \"KREIRAJ SAJAM\")]"));
        KreirajNovisajam.click();
        WebElement Korak3 = driver.findElement(By.id("paketiK3"));
        Korak3.isEnabled();
    }


    @Test (dependsOnMethods ={"UspesnoKreiranjeSajmaKorak1", "UspesnoKreiranjeSajmaKorak2"} )
    public void NeUpisivanjeCenePaketa () throws InterruptedException {
        WebElement NazivPaketa = driver.findElement(By.xpath("//input[@id=\"pn1\"]"));
        NazivPaketa.sendKeys("Bronzani pokrovitelj");
        Thread.sleep(2000);
        WebElement TipPaketa = driver.findElement(By.xpath("//input[@id=\"osn1\"]"));
        TipPaketa.click();
        Thread.sleep(2000);
        WebElement Stand = driver.findElement(By.xpath("//button[@onclick=\"dodStav(1)\"]"));
        Stand.click();
        Thread.sleep(2000);
        WebElement BrojPredavanja = driver.findElement(By.id("pp1"));
        BrojPredavanja.sendKeys("1");
        Thread.sleep(2000);
        WebElement BrojRadionica = driver.findElement(By.id("pr1"));
        BrojRadionica.sendKeys("2");
        Thread.sleep(2000);
        WebElement VideoPrezentacija = driver.findElement(By.id("pv1"));
        VideoPrezentacija.sendKeys("15");
        Thread.sleep(2000);
        WebElement BrojKompanija = driver.findElement(By.id("pk1"));
        BrojKompanija.sendKeys("3");
        Thread.sleep(2000);
        WebElement CenaPaketa = driver.findElement(By.id("pc1"));
        CenaPaketa.isEnabled();
        WebElement KreirajNovisajam = driver.findElement(By.xpath("//*[contains(text(), \"KREIRAJ SAJAM\")]"));
        KreirajNovisajam.click();
        WebElement Korak3 = driver.findElement(By.id("paketiK3"));
        Korak3.isEnabled();
    }
    @Test (dependsOnMethods ={"UspesnoKreiranjeSajmaKorak1", "UspesnoKreiranjeSajmaKorak2"} )
    public void NeupisivanjeOstalihPodataka () throws InterruptedException {
        WebElement NazivPaketa = driver.findElement(By.xpath("//input[@id=\"pn1\"]"));
        NazivPaketa.sendKeys("Bronzani pokrovitelj");
        Thread.sleep(2000);
        WebElement TipPaketa = driver.findElement(By.xpath("//input[@id=\"osn1\"]"));
        TipPaketa.click();
        Thread.sleep(2000);
        WebElement Stand = driver.findElement(By.xpath("//button[@onclick=\"dodStav(1)\"]"));
        Stand.click();
        Thread.sleep(2000);
        WebElement BrojPredavanja = driver.findElement(By.id("pp1"));
        BrojPredavanja.isEnabled();
        Thread.sleep(2000);
        WebElement BrojRadionica = driver.findElement(By.id("pr1"));
        BrojRadionica.isEnabled();
        Thread.sleep(2000);
        WebElement VideoPrezentacija = driver.findElement(By.id("pv1"));
        VideoPrezentacija.isEnabled();
        Thread.sleep(2000);
        WebElement BrojKompanija = driver.findElement(By.id("pk1"));
        BrojKompanija.isEnabled();
        Thread.sleep(2000);
        WebElement CenaPaketa = driver.findElement(By.id("pc1"));
        CenaPaketa.sendKeys("10000");
        WebElement KreirajNovisajam = driver.findElement(By.xpath("//*[contains(text(), \"KREIRAJ SAJAM\")]"));
        KreirajNovisajam.click();
        WebElement Korak3 = driver.findElement(By.id("paketiK3"));
        Korak3.isEnabled();

    }



}
