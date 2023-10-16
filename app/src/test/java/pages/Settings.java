package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class Settings {
    public TextBox fullName = new TextBox(By.id("FullNameInput"));
    public  Button okButton = new Button(By.xpath("//button[span[text()='Ok']]"));
}
