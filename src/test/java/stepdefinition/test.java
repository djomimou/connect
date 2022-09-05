package stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test {
    public WebDriver driver;

    @Given("lancer la page de recherche")
    public void openBrowser() {
        String SystemProp = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", SystemProp + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://www.automobile.tn/fr");
        driver.manage().window().maximize();
    }

    @When("saisir l'objet de recherche")
    public void saisirrecherche() {

        driver.findElement(By.name("keyword")).clear();
        driver.findElement(By.name("keyword")).sendKeys("volkswagen");
        driver.findElement(By.xpath("//*[@id=\"global-search\"]/button/i")).click();


    }




    @And("choisir la marque de voiture")
    public void choisirLaMarqueDeVoiture() {
        driver.findElement(By.xpath("//*[@id=\"detail_content\"]/div[2]/a")).click();
    }

    @And("choisir le modele de voiture")
    public void choisirLeModeleDeVoiture() {
        driver.findElement(By.xpath("//*[@id=\"w0\"]/div[4]/span[7]/div/a/h2")).click();
    }

    @Then("nous sommes sur la page sible")
    public void nousSommesSurLaPageSible() {
        String message = driver.findElement(By.className("page-title")).getText();
        Assert.assertEquals("VOLKSWAGEN POLO SEDAN",message);
    }
    @After
    public void closeNavigator(){
        driver.quit();
    }
}