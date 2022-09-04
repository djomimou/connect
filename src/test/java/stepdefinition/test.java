package stepdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
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

        driver.findElement(By.Name("keyword")).clear();


        driver.findElement(By.Name("keyword")).sendkeys("volkswagen");
        driver.findElement(By.Classename("btn btn-primary input-group-text")).click();


    }

    @And("saisir la marque de voiture")
    public void saisirLaMarqueDeVoiture() {
    }
}