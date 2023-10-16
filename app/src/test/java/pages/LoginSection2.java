package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginSection2 {
    public TextBox emailTextBox = new TextBox(By.xpath("//*[@placeholder='Introduce tu email...']"));
    public TextBox pwdTextBox = new TextBox(By.xpath("//*[@placeholder='Introduce tu contraseña...']"));
    public Button loginButton = new Button(By.id("start-email-login"));
}
