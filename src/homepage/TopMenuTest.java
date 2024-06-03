package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * Write the following Test:
 * 1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 * 1.1 Mouse hover on “Desktops” Tab and click
 * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
 * 1.3 Verify the text ‘Desktops’
 * 2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
 * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
 * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
 * 2.3 Verify the text ‘Laptops & Notebooks’
 * 3. verifyUserShouldNavigateToComponentsPageSuccessfully()
 * 3.1 Mouse hover on “Components” Tab and click
 * 3.2 call selectMenu method and pass the menu = “Show All Components”
 * 3.3 Verify the text ‘Components’
 */
public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {                   //Open browser
        this.openBrowser(this.baseUrl);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuElement = getMultipleElements(By.xpath("//a[@class='see-all']"));
        for (WebElement e : topMenuElement) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        //Verify the text ‘Desktops’
        Assert.assertEquals("Desktops", getTextFromElement(By.xpath("//h2[text()='Desktops']")));
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals("Laptops & Notebooks", getTextFromElement(By.xpath("//h2[text()='Laptops & Notebooks']")));
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //Mouse hover on “Components” Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Components']"));
        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        //Verify the text ‘Components’
        Assert.assertEquals("Components", getTextFromElement(By.xpath("//h2[text()='Components']")));
    }
      @After
      public void tearDown() {                //Close browser
          closeBrowser();
      }
}
