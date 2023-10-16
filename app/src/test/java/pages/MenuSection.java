package pages;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button addNewProject = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox nameProject = new TextBox(By.id("NewProjNameInput"));
    public Button saveProject = new Button(By.id("NewProjNameButton"));

    public Button selectProject = new Button(By.xpath("//li[last()]//td[text()='NewProject']"));
    public  TextBox newItem = new TextBox(By.id("NewItemContentInput"));
    public Button addNewItem = new Button(By.id("NewItemAddButton"));

    public TextBox selectItem = new TextBox(By.xpath("//div[contains(text(), 'hefowferw')]"));
}