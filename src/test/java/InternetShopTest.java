import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InternetShopTest {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]/a");
    private final By MENU = By.xpath(".//div[contains(@class, 'submenu-lvl1--index')]");
    private final String SECTION = "Mēbeles";

    @Test
    public void productPresenceInCartCheck() {
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://1a.lv");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        WebElement acceptBtn = browser.findElement(ACCEPT_COOKIES_BTN);

        acceptBtn.click();

        WebElement menuBlock = browser.findElement(MENU);
        List<WebElement> items = menuBlock.findElements(MENU_ITEM);

        boolean isSectionFound = false;
        for (WebElement we : items) {
//            System.out.println(we.getText());
            if (we.getText().equals(SECTION)) {
                wait.until(ExpectedConditions.elementToBeClickable(we));
                isSectionFound = true;
                we.click();
                break;
            }
        }

        Assertions.assertTrue(isSectionFound, "Section not found!");
    }

//    @Test
//    public void workingWithLists() {
//        List<String> names = new ArrayList<>();
//        names.add("Dmitry");
//        names.add("Laura");
//        names.add("Vitalijs");
//        names.add("Inna");
//        names.add("Anna");
}
