package pages;

import controls.Button;
import org.openqa.selenium.By;

public class MainPage {

    public Button loginButton = new Button(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]"));
    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));
}