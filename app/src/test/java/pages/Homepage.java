package pages;

import controls.Control;
import org.openqa.selenium.By;

public class Homepage {
    public Control todayTitle = new Control(By.xpath("//h1/span[text()='Today']"));
}
