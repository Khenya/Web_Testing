package crearActualizar;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CrearActualizarProject {
    ChromeDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();

        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        chrome.get("http://todo.ly/");
        // login brendaaa@gmail.com
        // click login button
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        // set email
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("brendaaa@gmail.com");
        // set password
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

    }

    @Test
    public void verifyCrateProjectTest() throws InterruptedException {
        List<WebElement> similarElementsBefore = chrome.findElements(By.xpath(String.format("//td[text()='%s']", "brendaaa")));
        Thread.sleep(5000);
        // click AddNewProjDiv
        chrome.findElement(By.xpath("//div[@class=\"AddProjectLiDiv\"]")).click();
        // set project
        chrome.findElement(By.id("NewProjNameInput")).sendKeys("brendaaa");
        // click add
        chrome.findElement(By.id("NewProjNameButton")).click();

        Thread.sleep(5000);

        // verificar si se creo el projecto
        List<WebElement> similarElementsAfter = chrome.findElements(By.xpath(String.format("//td[text()='%s']", "brendaaa")));
        Assertions.assertTrue(similarElementsBefore.size() < similarElementsAfter.size(),
                "ERROR no se pudo crear el projecto");
    }

    @Test
    public void verifyEditProjectTest() throws InterruptedException {
        List<WebElement> similarProjectsBefore = chrome.findElements(By.xpath(String.format("//td[text()='%s']", "brendaaa edit")));
        List<WebElement> similarElements = chrome.findElements(By.xpath(String.format("//tr[td[@class='ProjItemContent' and text()='%s']]", "brendaaa")));
        WebElement lastProjectCreated = similarElements.get(similarElements.size() - 1);
        lastProjectCreated.click();
        // click menu
        lastProjectCreated.findElement(By.xpath(".//div[@class='ProjItemMenu']/img")).click();
        // click edit
        chrome.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]/li[@class='edit']")).click();
        // set nuw name
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys(" edit");
        // click save
        chrome.findElement(By.id("ItemEditSubmit")).click();

        Thread.sleep(5000);

        // verificar si se cambio el nopmbre
        List<WebElement> similarProjectsAfter = chrome.findElements(By.xpath(String.format("//td[text()='%s']", "brendaaa edit")));
        Assertions.assertTrue(similarProjectsBefore.size() < similarProjectsAfter.size(),
                "ERROR no se pudo editar el proyecto");
    }
    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }
}

