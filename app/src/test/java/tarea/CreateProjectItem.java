package tarea;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginSection;
import pages.MainPage;
import pages.MenuSection;
import session.Session;

public class CreateProjectItem {
    MenuSection menuSection = new MenuSection();
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("http://todo.ly/");
        // login
        mainPage.loginButton.click();
        loginSection.emailTextBox.setText("brendaaa@gmailm");
        loginSection.emailTextBox.clearSetText("brendaaa@gmail.com");
        loginSection.pwdTextBox.setText("12345");
        loginSection.loginButton.click();
    }
    @Test
    public void createProject(){
        menuSection.addNewProject.click();
        menuSection.nameProject.setText("NewProject");
        menuSection.saveProject.click();
        // verificacion
        Assertions.assertTrue(menuSection.nameProject.isControlDisplayed(),
                "ERROR no se pudo crear el proyecto");
    }

    @Test
    public void createItem(){
        menuSection.selectProject.click();
        menuSection.newItem.setText("hefowferw");
        menuSection.addNewItem.click();
        // verificacion
        Assertions.assertTrue(menuSection.newItem.isControlDisplayed(),
                "ERROR no se pudo crear el item");

    }

    @Test
    public void updateItem(){
        menuSection.selectProject.click();
        menuSection.selectItem.click();
//        menuSection.selectItem.clearSetText("bolwrbd");
//        menuSection.selectItem.setText("holaaaaa");
// debo terminar
//        // verificacion
//        Assertions.assertTrue(menuSection.newItem.isControlDisplayed(),
//                "ERROR no se pudo crear el item");
    }
    @AfterEach
    public  void  close(){
        Session.getInstance().closeSession();
    }
}
